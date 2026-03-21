package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        Car car1 = new Car("BMW", "m5", 2025);
        Car car2 = new Car("BMW", "m4", 2024);
        Car car3 = new Car("BMW", "m3", 2023);
        Car car4 = new Car("BMW", "m2", 2022);
        Car car5 = new Car("BMW", "m1", 2021);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }
    public List <Car> getCars(int count) {
        if (count  >= cars.size()) {
            return cars;
        } else return cars.subList(0,count);
    }

}

