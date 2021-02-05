package hospital_test.test.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CarService {

    List<Map<String, Object>> getCarMap(String carNum);

    CarBean getCarInfo(String carNum);

    CarBean getCarOne(String carNum);
}