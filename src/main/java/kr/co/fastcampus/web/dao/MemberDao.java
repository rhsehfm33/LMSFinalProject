package kr.co.fastcampus.web.dao;

import kr.co.fastcampus.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    void init() {
        jdbcTemplate.update("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null)");
        jdbcTemplate.update("insert into member(username, password) values('minseongLim', '1234')");
    }

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insert(String username, String password) {
        jdbcTemplate.update("insert into member(username, password) values(?, ?)", username, password);
    }

    public List<Member> list() {
        return jdbcTemplate.query("select id, username, password from member",
                (RowMapper<Member>) (resultSet, i) ->new Member(resultSet));
    }
}
