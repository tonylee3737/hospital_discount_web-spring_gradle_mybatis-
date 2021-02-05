package hospital_test.test.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
    MemberBean getUserInfo(String user_id, String user_pass);

    AdminBean getAdminInfo(String user_id, String user_pass);
}
