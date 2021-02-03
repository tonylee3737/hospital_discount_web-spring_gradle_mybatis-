package hospital_test.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    private EmployeeService employeeService;

    @Autowired
    void EmployeeController(
            EmployeeService employeeService
    ) {
        this.employeeService = employeeService;
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("data", employeeService.getEmployee());
        return "hello2";
    }
}
