package hospital_test.test.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class CarServiceImpl implements CarService{

    private CarMapper carMapper;


    @Autowired
    CarServiceImpl(CarMapper carMapper){
        this.carMapper = carMapper;
    }

    @Override
    public List<Map<String, Object>> getCarMap(String carNum) {
        return carMapper.getCarMap(carNum);
    }

    @Override
    public CarBean getCarInfo(String carNum) {
        return carMapper.getCarInfo(carNum);
    }

    @Override
    public String getTime(String carNum) {
        return carMapper.getTime(carNum);
    }

    @Override
    public CarBean getCarOne(String carNum) {
        return carMapper.getCarOne(carNum);
    }

}
