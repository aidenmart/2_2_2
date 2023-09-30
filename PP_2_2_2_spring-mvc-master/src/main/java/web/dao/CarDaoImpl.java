package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Mercedes", "white", 2022, 3_650_000.00));
        carList.add(new Car("Hyundai", "blue", 2010, 700_000));
        carList.add(new Car("Audi", "red", 2017, 3_000_000));
        carList.add(new Car("BMW", "silver", 2020, 6_000_000.00));
        carList.add(new Car("Porshe", "black", 2018, 8_400_000));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}