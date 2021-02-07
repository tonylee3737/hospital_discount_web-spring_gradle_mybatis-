package hospital_test.test.car;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface CarMapper {

    List<Map<String, Object>> getCarMap(String carNum);

    CarBean getCarInfo(String carNum);
    String getTime(String carNum);
    CarBean getCarOne(String carNum);
}