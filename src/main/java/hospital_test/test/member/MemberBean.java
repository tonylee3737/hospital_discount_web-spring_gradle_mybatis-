package hospital_test.test.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
public class MemberBean {
    String ClId;
    String ClPW;
    String ClDCTime1;
}
