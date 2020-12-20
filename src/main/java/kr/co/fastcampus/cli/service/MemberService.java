package kr.co.fastcampus.cli.service;

import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@AllArgsConstructor
public class MemberService {

    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) throws SQLException {
        memberDao.insert(username, password);
    }

    public void print() throws SQLException {
        memberDao.print();
    }

}
