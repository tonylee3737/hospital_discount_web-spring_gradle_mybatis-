package hospital_test.test.car;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface CarMapper {

    List<Map<String, Object>> getCarInfo(String carNum);

    CarBean getCarInfo2(String carNum);
}