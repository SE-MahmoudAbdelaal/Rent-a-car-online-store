package com.Fawry.dao;

import com.Fawry.entity.Car;
import java.util.*;

public interface CarDAO {
    List<Car> findAll();
    Car findByID(int theId);
    Car save(Car car);
    void deleteCarById(int theId);
    Car update(Car car);
}
