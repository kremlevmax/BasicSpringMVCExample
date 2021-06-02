package org.example.config.dao;

import org.example.config.models.Pet;
import org.springframework.stereotype.Component;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PetDAO {
    private static int PET_COUNT;
    private List<Pet> pets;

    private static final String URL = "jdbc:postgresql://localhost:5432/pets";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Pet> index() {
        List<Pet> pets = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQLRequest = "SELECT*FROM Pet";
            ResultSet resultSet = statement.executeQuery(SQLRequest);

            while(resultSet.next()) {
                Pet pet = new Pet();
                pet.setName(resultSet.getString("name"));
                pet.setEmail(resultSet.getString("email"));
                pet.setAge(resultSet.getInt("age"));
                pet.setId(resultSet.getInt("id"));
                pet.setType(resultSet.getString("type"));
                pets.add(pet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pets;
    }

    public Pet showById(int id) {
        Pet pet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pet = pets.get(i);
            }
        } return pet;
    }

    public void save(Pet pet){
        pet.setId(++PET_COUNT);
        pets.add(pet);
    }

    public void update(int id, Pet pet) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pets.get(i).setName(pet.getName());
                pets.get(i).setType(pet.getType());
                pets.get(i).setEmail(pet.getEmail());
                pets.get(i).setAge(pet.getAge());
            }
        }
    }

    public void delete(int id) {
        pets.remove(id-1);
    }
}


