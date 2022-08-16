package com.spring.study.repository;

import com.spring.study.domain.MemberDTO;
import com.spring.study.domain.RegisterDTO;
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
public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String insert_sql = "insert into MEMBER2 (ID, PASSWORD, NAME, NICKNAME) values (?, ?, ?, ?)";
    private final String getMemberById_sql = "select * from MEMBER2 where id = ?";
    private final String getMemberByNickname_sql = "select * from MEMBER2 where nickname = ?";

    @Override
    public void insert(RegisterDTO registerDTO) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(insert_sql);
                pstmt.setString(1, registerDTO.getId());
                pstmt.setString(2, registerDTO.getPassword());
                pstmt.setString(3, registerDTO.getName());
                pstmt.setString(4, registerDTO.getNickname());

                return pstmt;
            }
        });
    }

    @Override
    public boolean checkIdDuplicate(String id) {
        List<MemberDTO> results = jdbcTemplate.query(getMemberById_sql, rowMapper, id);
        if (!results.isEmpty()){
            return false;
        }
        return true;
    }

    private RowMapper<MemberDTO> rowMapper = new RowMapper<MemberDTO>() {
        @Override
        public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberDTO memberDTO = new MemberDTO(
                    rs.getString("ID"),
                    rs.getString("PASSWORD"),
                    rs.getString("WRITER"),
                    rs.getString("NICKNAME"),
                    rs.getDate("REGDATE")
            );

            return memberDTO;
        }
    };
}
