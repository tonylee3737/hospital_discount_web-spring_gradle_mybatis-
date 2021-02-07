package hospital_test.test.member;


import hospital_test.test.car.CarBean;
import hospital_test.test.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;


@Controller
public class MemberController {

    private MemberService memberService;
    private CarService carService;


    @Autowired
    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    MemberController(CarService carService){
        this.carService = carService;
    }


    @GetMapping("")
    public String main() {
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("session_id", null);
        //        session.invalidate();
        model.addAttribute("session_id", session.getAttribute("session_id"));
        return "main";

    }

    @PostMapping("/")
    public String login(@RequestParam(value = "user_id") String user_id,
                        @RequestParam(value = "user_pass") String user_pass, Model model, HttpServletRequest request) {
// 비밀번호까지 가져온 후, 세션 등록
        HttpSession session = request.getSession();
        MemberBean userInfo = memberService.getUserInfo(user_id, user_pass);
        if (userInfo != null) {
            session.setAttribute("session_id", userInfo.getClId());
            session.setAttribute("session_pass", userInfo.getClPW());
            return "dc_reg";
        } else {
            AdminBean adminInfo = memberService.getAdminInfo(user_id, user_pass);
            if (adminInfo != null) {
                session.setAttribute("session_id", adminInfo.getAdmId());
                return "discount_list";
            } else {
                model.addAttribute("m", "아이디와 비밀번호를 확인해주세요");
                return "main";
            }
        }
    }

    @GetMapping("/discount_list")
    public String admin() {
        return "discount_list";
    }

    @PostMapping("/discount_list")
    public String admin_post(MemberBean bean, Model model) {
        memberService.memberInsert(bean.getClId(), bean.ClPW);
        model.addAttribute("data1", bean.getClId());
        model.addAttribute("data2", bean.getClPW());
        return "main";
    }

    @GetMapping("/discount_time")
    public String discount_time(@RequestParam(value = "time") int time, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String session_car_id = (String) session.getAttribute("session_car_id");
//        CarBean car = carService.getCarInfo("1234");
        CarBean carOne = memberService.getCarOne(session_car_id);
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String time1 = memberService.getTime(session_car_id);
        model.addAttribute("carDate", carOne.getInsDyTe() );
        model.addAttribute("carNum", carOne.getVhlNbr());
        model.addAttribute("parking_while", time1);
            String session_id = (String) session.getAttribute("session_id");
            String session_pass =(String) session.getAttribute("session_pass");
        if (time==1) {
            memberService.memberDcTimeUpdate("60",session_id);
            MemberBean userInfo = memberService.getUserInfo(session_id, session_pass);
            model.addAttribute("dc_time", userInfo.ClDCTime1);
        return "dc_reg_confirm";
        }if (time==2) {
            memberService.memberDcTimeUpdate("120", session_id);
            MemberBean userInfo = memberService.getUserInfo(session_id, session_pass);
            model.addAttribute("dc_time", userInfo.ClDCTime1);
        return "dc_reg_confirm";
        }if(time==3){
            memberService.memberDcTimeUpdate("180", session_id);
            MemberBean userInfo = memberService.getUserInfo(session_id, session_pass);
            model.addAttribute("dc_time", userInfo.ClDCTime1);
        return "dc_reg_confirm";
        }else {
            return "main";
        }
    }
}
