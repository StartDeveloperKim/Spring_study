package com.spring.study.repository;

import com.spring.study.domain.BoardVO;
import com.spring.study.domain.Critertia;
import com.spring.study.domain.UpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class JdbcTemplateBoardRepository implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    // 아래에 정의한 sql문이 굉장히 보기 싫다. 나중에 정리하는 법을 공부하자 --> 2022/08/11
    // 현재 JDBC Template을 활용하여 Repository 부분을 만들었다. 다음에 Mybatis를 통해 만들자. 그 다음은 JPA
    private final String insert_sql = "insert into tbl_board (BNO, TITLE, CONTENT, WRITER) values (seq_ser_saleman_cntl.nextval, ?, ?, ?)";
    private final String insertSelectKey_sql = "insert into tbl_board (BNO, TITLE, CONTENT, WRITER) values (?, ?, ?, ?)";
    private final String read_sql = "select * from tbl_board where bno = ?";
    private final String delete_sql = "delete from tbl_board where bno = ?";
    private final String update_sql = "update tbl_board set title = ?, content = ?, updateDate = ? where bno = ?";
    private final String getListWithPaging_sql = "SELECT BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE " +
            "FROM( " +
            "select /*+ INDEX_DESC(tbl_board pk_board)*/ " +
            "rownum rn, tbl_board.* " +
            "from tbl_board " +
            "where rownum <= ?) " +
            "WHERE rn > ?";
    private final String getTotalCount_sql = "select count(*) from tbl_board where bno > 0";

    @Autowired
    public JdbcTemplateBoardRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BoardVO> getList() {
        return null;
    }

    @Override
    public List<BoardVO> getListWithPaging(Critertia cri) {
        return jdbcTemplate.query(getListWithPaging_sql, boardVORowMapper,
                cri.getPageNum()*cri.getAmount(),
                (cri.getPageNum()-1)*cri.getAmount());
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
        board.setUpdateDate(new Date());
        return jdbcTemplate.update(update_sql, board.getTitle(), board.getContent(), board.getUpdateDate(), board.getBno());
    }

    @Override
    public int getTotalCount(Critertia cri) {
        try {
            return jdbcTemplate.queryForObject(getTotalCount_sql, rowMapper);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public List<BoardVO> getFewList() {
        //6, 0
        return jdbcTemplate.query(getListWithPaging_sql, boardVORowMapper, 6, 0);
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
            //System.out.println(boardVO.toString());
            return boardVO;
        }
    };
    RowMapper<Integer> rowMapper = new RowMapper<>() {
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(1);
        }
    };
}