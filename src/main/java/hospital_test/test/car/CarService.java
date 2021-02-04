package hospital_test.test.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CarService {

    List<Map<String, Object>> getCarInfo(String carNum);

    CarBean getCarInfo2(String carNum);
}