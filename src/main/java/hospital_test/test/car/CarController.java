package hospital_test.test.car;


import hospital_test.test.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/reg_car")
    public String reg_car(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("session_id")!=null){
            return "dc_reg";
        }else{
            return "main";
        }
    }
//
//    @PostMapping("/reg_car")
//    public String reg_car(@RequestParam(value = "num") String value, Model model) {
//        List car = carService.getCarMap(value);
//        if (car.size() > 0) {
//        for(int i = 0; i<car.size(); i++){
//            = car.get(i);
//        }
//        String regex = ",";
//        String[] s = car.get(0).toString().split(regex);
//        String carnum=s[4].substring(8);
//        model.addAttribute("carNum", carnum);
//
//        }
//        return "dc_reg";
//    }

    @PostMapping("/reg_car")
    public String reg_car(@RequestParam(value = "num") String value, Model model) {

            CarBean car = carService.getCarInfo(value);
            if(car!=null) {
                model.addAttribute("carDate", car.getInsDyTe());
                model.addAttribute("carNum", car.getVhlNbr());
            }else{
                model.addAttribute("carCheck", "None");
            }
            return "dc_reg";
    }
    @GetMapping("/reg_car_confirm")
    public String reg_car_confirm(@RequestParam(value = "id") String value, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("session_car_id", value);

        if (session.getAttribute("session_id") != null) {
            CarBean car =carService.getCarOne(value);
            String time = carService.getTime(value);

            model.addAttribute("carDate", car.getInsDyTe() );
            model.addAttribute("carNum", car.getVhlNbr());
            model.addAttribute("parking_while", time);
            return "dc_reg_confirm";
        }else{
            return "main";
        }
    }
}


