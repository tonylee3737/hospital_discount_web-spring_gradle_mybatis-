package hospital_test.test.member;


import hospital_test.test.car.CarBean;
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
    public CarBean getCarOne(String carNum) {
        return memberMapper.getCarOne(carNum);
    }

    @Override
    public void memberInsert(String user_id, String user_pass) {
        memberMapper.memberInsert(user_id, user_pass);
    }

    @Override
    public String getTime(String carNum) {
        return memberMapper.getTime(carNum);
    }

    @Override
    public void memberDcTimeUpdate(String dc_Time, String user_id) {
        memberMapper.memberDcTimeUpdate(dc_Time, user_id);

    }

    @Override
    public AdminBean getAdminInfo(String user_id, String user_pass) {
        return memberMapper.getAdminInfo(user_id, user_pass);
    }


}