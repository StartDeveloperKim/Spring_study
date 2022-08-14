package com.spring.study.repository;

import com.spring.study.domain.RegisterDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String insert_sql = "insert into MEMBER2 (ID, PASSWORD, NAME, NICKNAME) values (?, ?, ?, ?)";

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
}
