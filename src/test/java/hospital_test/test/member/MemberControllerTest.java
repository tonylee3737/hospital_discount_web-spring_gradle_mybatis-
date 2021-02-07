package hospital_test.test.member;

import hospital_test.test.car.CarBean;
import hospital_test.test.car.CarService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

//날짜 보여주기
//입차목록 리스트를 반환받아서 여러 차 번호 받아오기.
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberControllerTest {

    @Autowired
    MemberService memberService;
    @Autowired
    CarService carService;
    @Test
    public void 회원가입() throws Exception{
        //given
        memberService.memberInsert("test1", "123");
        //when
        MemberBean getMember = memberService.getUserInfo("test1", "123");

        //then
        Assertions.assertThat(getMember.ClId).isEqualTo("test1");
        }
    @Test
    @Transactional
    @Rollback(value = false)
    public void 할인시간업데이트() throws Exception{
        //given
        memberService.memberDcTimeUpdate("0", "test2");
        //when
        MemberBean getMemberInfo = memberService.getUserInfo("tony", "1");
        //then
        Assertions.assertThat(getMemberInfo.ClDCTime1).isEqualTo("0");
        }

    @Test
    public void 차번호확인() throws Exception {
        //given
        CarBean carOne = carService.getCarOne("대구12가1234");
        //when
        carOne.getVhlNbr();
        //then
        Assertions.assertThat(carOne.getVhlNbr()).isEqualTo("대12가1234");
    }
}
