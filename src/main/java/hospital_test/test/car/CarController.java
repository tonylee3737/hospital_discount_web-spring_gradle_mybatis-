package hospital_test.test.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String reg_car() {
        return "dc_reg";
    }

    @PostMapping("/reg_car")
    public String reg_car(@RequestParam(value = "num") String value, Model model) {
        CarBean car = carService.getCarInfo2(value);

        model.addAttribute("carNum", car);
        return "dc_reg";
    }
}

//    @PostMapping("/reg_car")
//    public String reg_car(@RequestParam(value = "num") String value, Model model) {
//        List car = carService.getCarInfo2(value);
//        model.addAttribute("carNum", car);
//        return "dc_reg";
//    }


