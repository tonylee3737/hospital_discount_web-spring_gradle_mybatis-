package hospital_test.test.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
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

    @GetMapping("discount_list")
    public String admin() {
        return "discount_list";
    }

    @PostMapping("discount_list")
    public String admin_post(@RequestParam Map<String, String> map, Model model) {
        model.addAttribute("data", map.get("ClUser"));
        return "discount_list";
    }
}
