package hello.hello.spring.repository;

import hello.hello.spring.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String save_sql = "INSERT INTO MEMBER2 (ID, PASSWORD, NAME) VALUES (?, ?, ?)";
    private final String findById_sql = "SELECT * FROM MEMBER2 WHERE ID = ?";


    @Override
    public void save(Member member) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(save_sql);
                pstmt.setString(1, member.getId());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                return pstmt;
            }
        });
    }

    @Override
    public Member findById(String memberId) {
        List<Member> results = jdbcTemplate.query(findById_sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member(
                        rs.getString("ID"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME")
                );
                return member;
            }
        }, memberId);

        return !results.isEmpty() ? results.get(0) : null;
    }
}
