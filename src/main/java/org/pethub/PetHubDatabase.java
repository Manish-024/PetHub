package org.pethub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetHubDatabase {
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pethub", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPet(Pet pet) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO pets (name, species, age, favorite_food) VALUES (?, ?, ?, ?)");
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getFavoriteFood());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFood(Food food) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO food (name, description, nutritional_value) VALUES (?, ?, ?)");
            statement.setString(1, food.getName());
            statement.setString(2, food.getDescription());
            statement.setInt(3, food.getNutritionalValue());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertItem(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO items (name, description, price) VALUES (?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

