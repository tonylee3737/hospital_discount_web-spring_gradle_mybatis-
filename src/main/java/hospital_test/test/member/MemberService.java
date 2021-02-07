package hospital_test.test.member;


import hospital_test.test.car.CarBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface MemberService {
    MemberBean getUserInfo(String user_id, String user_pass);

    CarBean getCarOne(String carNum);

    void memberInsert(String user_id, String user_pass);
    String getTime(String carNum);
    void memberDcTimeUpdate(String dc_Time, String user_id);
    AdminBean getAdminInfo(String user_id, String user_pass);
}
