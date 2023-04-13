package web.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.Dao.CarDao;
import web.Model.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getCars(Integer count) {
        return carDao.getCars(count);
    }
}
