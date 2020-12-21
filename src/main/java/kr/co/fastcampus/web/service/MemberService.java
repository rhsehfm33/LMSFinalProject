package kr.co.fastcampus.web.service;

import kr.co.fastcampus.web.dao.MemberDao;
import kr.co.fastcampus.web.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class MemberService {

    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) {
        memberDao.insert(username, password);
    }

    public List<Member> list() {
        return memberDao.list();
    }

}
