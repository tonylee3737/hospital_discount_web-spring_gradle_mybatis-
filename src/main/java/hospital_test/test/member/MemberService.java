package hospital_test.test.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface MemberService {
    MemberBean getUserInfo(String user_id, String user_pass);

    AdminBean getAdminInfo(String user_id, String user_pass);
}
