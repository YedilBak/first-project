package kz.index.demo.db;

import kz.index.demo.model.Car;
import lombok.Getter;

import java.util.ArrayList;

public class DBManager {

    private static int id = 5;

    @Getter
    private static ArrayList<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1, "BMW X5", 3.0, 150000, "GOOD CAR", "GERMANY" ));
        cars.add(new Car(2, "BMW X6", 3.0, 120000, "GOOD CAR", "GERMANY" ));
        cars.add(new Car(3, "BMW X7", 5.0, 170000, "GOOD CAR", "GERMANY" ));
        cars.add(new Car(4, "BMW M5", 5.0, 130000, "GOOD CAR", "GERMANY" ));
    }


    public static void addCar(Car car) {
        car.setId(id);
        id++;
        cars.add(car);
    }

    public static Car getCarById(int id){
        return cars.stream().filter(car -> car.getId()==id).findFirst().get();
    }

    public static void updateCar(Car car) {

        for(Car c: cars){
            if(c.getId()==car.getId()){
                c.setCost(car.getCost());
                c.setCountry(car.getCountry());
                c.setModel(car.getModel());
                c.setEngine(car.getEngine());
                c.setDescription(car.getDescription());
            }
        }
    }

    public static void deleteCarById(int id){
        cars.removeIf(car->car.getId()==id);
    }
}
