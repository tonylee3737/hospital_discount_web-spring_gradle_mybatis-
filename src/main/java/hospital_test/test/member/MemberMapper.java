package hospital_test.test.member;

import hospital_test.test.car.CarBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
    MemberBean getUserInfo(String user_id, String user_pass);

    void memberInsert(String user_id, String user_pass);

    void memberDcTimeUpdate(String dc_Time, String user_id);
    AdminBean getAdminInfo(String user_id, String user_pass);

    String getTime(String carNum);
    CarBean getCarOne(String carNum);

}
