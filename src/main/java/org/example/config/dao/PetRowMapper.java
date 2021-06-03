package org.example.config.dao;

import org.example.config.models.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
        Pet pet = new Pet();

        pet.setId(resultSet.getInt("id"));
        pet.setName(resultSet.getString("name"));
        pet.setType(resultSet.getString("type"));
        pet.setEmail(resultSet.getString("email"));
        pet.setAge(resultSet.getInt("age"));

        return pet;

    }
}
