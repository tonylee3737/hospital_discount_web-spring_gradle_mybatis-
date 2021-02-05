package hospital_test.test.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;

    @Autowired
    MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public MemberBean getUserInfo(String user_id, String user_pass) {
        return memberMapper.getUserInfo(user_id, user_pass);
    }

    @Override
    public AdminBean getAdminInfo(String user_id, String user_pass) {
        return memberMapper.getAdminInfo(user_id, user_pass);
    }


}