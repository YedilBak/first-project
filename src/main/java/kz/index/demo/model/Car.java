package kz.index.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private int id;
    private String model;
    private double engine;
    private double cost;
    private String description;
    private String country;


}
