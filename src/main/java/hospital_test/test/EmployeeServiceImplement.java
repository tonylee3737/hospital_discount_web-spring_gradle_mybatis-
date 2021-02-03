package hospital_test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    private EmployeeMapper employeeMapper;

    @Autowired
    EmployeeServiceImplement(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<Map<String, Object>> getEmployee() {
        return employeeMapper.getEmployee();
    }
}