package com.Fawry.dao;

import com.Fawry.db.DBConnection;
import com.Fawry.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImp implements CarDAO {
    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM cars");
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Executing query: SELECT * FROM cars");

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setName(resultSet.getString("name"));
                car.setPrice(resultSet.getInt("price"));
                car.setDescription(resultSet.getString("description"));
                car.setImage(resultSet.getString("image"));
                cars.add(car);
                System.out.println("Fetched Car: " + car.getName()); // Debug print
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Total cars fetched: " + cars.size()); // Debug print
        return cars;
    }


    @Override
    public Car findByID(int theId) {
        Car car = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM cars WHERE id = ?")) {
            // Set the ID parameter
            statement.setInt(1, theId);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Check if a result is returned
                if (resultSet.next()) {
                    car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setName(resultSet.getString("name"));
                    car.setPrice(resultSet.getInt("price"));
                    car.setDescription(resultSet.getString("description"));
                    car.setImage(resultSet.getString("image"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }


    public Car save(Car car) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO cars (name, price, description, image) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, car.getName());
            statement.setInt(2, car.getPrice());
            statement.setString(3, car.getDescription());
            statement.setString(4, car.getImage());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // Other methods of the CarDAO interface implemented here


    @Override
    public void deleteCarById(int theId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM cars WHERE id = ?")) {
            // Set the ID parameter
            statement.setInt(1, theId);

            // Execute the delete statement
            statement.executeUpdate();

            System.out.println("Car with ID " + theId + " deleted successfully."); // Debug print
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Car update(Car car) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("UPDATE cars SET name = ?, price = ?, description = ?, image = ? WHERE id = ?")) {
            // Set the parameters
            statement.setString(1, car.getName());
            statement.setInt(2, car.getPrice());
            statement.setString(3, car.getDescription());
            statement.setString(4, car.getImage());
            statement.setInt(5, car.getId());

            // Execute the update statement
            statement.executeUpdate();

            System.out.println("Car with ID " + car.getId() + " updated successfully."); // Debug print
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return car;
    }
}
