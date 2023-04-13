package web.Dao;

import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImpl implements CarDao {

    private List<Car> carList = new ArrayList<>();

    public CarDaoImpl() {
        carList.add(new Car("BMW", "Black", 45000));
        carList.add(new Car("Porsche", "Grey", 75000));
        carList.add(new Car("Audi", "Blue", 40000));
        carList.add(new Car("Tesla", "White", 90000));
        carList.add(new Car("Ford", "Black", 60000));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (carList == null || carList.isEmpty())
            return Collections.emptyList();
        if (count == null) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
