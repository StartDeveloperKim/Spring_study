package com.spring.study.repository;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplateBoardRepository implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String insert_sql = "insert into tbl_board (BNO, TITLE, CONTENT, WRITER) values (seq_ser_saleman_cntl.nextval, ?, ?, ?)";
    private final String insertSelectKey_sql = "insert into tbl_board (BNO, TITLE, CONTENT, WRITER) values (?, ?, ?, ?)";
    private final String read_sql = "select * from tbl_board where bno = ?";
    private final String delete_sql = "delete from tbl_board where bno = ?";
    private final String update_sql = "update tbl_board set title = ?, content = ?, writer = ?, updateDate = sysdate, where bno = ?";
    private final String getListWithPaging_sql = "SELECT BNO, TITLE, CONTENT " +
            "FROM( " +
            "    select /*+ INDEX_DESC(tbl_board pk_board)*/ " +
            "        rownum rn, bno, title, content " +
            "    from tbl_board " +
            "    where rn <= 20) " +
            "WHERE rn > 10";

    public JdbcTemplateBoardRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BoardVO> getList() {
        return null;
    }

    @Override
    public List<BoardVO> getListWithPaging(Critertia cri) {
        return jdbcTemplate.query(getListWithPaging_sql, boardVORowMapper);
    }

    @Override
    public void insert(BoardVO board) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(insert_sql);
                pstmt.setString(1, board.getTitle());
                pstmt.setString(2, board.getContent());
                pstmt.setString(3, board.getWriter());

                return pstmt;
            }
        });
    }

    @Override
    public void insertSelectKey(BoardVO board) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(insertSelectKey_sql);
                pstmt.setLong(1, board.getBno());
                pstmt.setString(2, board.getTitle());
                pstmt.setString(3, board.getContent());
                pstmt.setString(4, board.getWriter());

                return pstmt;
            }
        });
    }

    @Override
    public BoardVO read(Long bno) {
        List<BoardVO> results = jdbcTemplate.query(read_sql, boardVORowMapper, bno);
        return results.isEmpty() ? null:results.get(0);
    }

    @Override
    public int delete(Long bno) {
        return jdbcTemplate.update(delete_sql, bno);
    }

    @Override
    public int update(BoardVO board) {
        return jdbcTemplate.update(update_sql, board.getTitle(), board.getContent(), board.getWriter(), board.getBno());
    }

    private RowMapper<BoardVO> boardVORowMapper = new RowMapper<BoardVO>() {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO boardVO = new BoardVO(
                    rs.getString("TITLE"),
                    rs.getString("CONTENT"),
                    rs.getString("WRITER"),
                    rs.getDate("REGDATE"),
                    rs.getDate("UPDATEDATE")
            );
            boardVO.setBno(rs.getLong("BNO"));
            return boardVO;
        }
    };
}