package org.example.config.dao;

import org.example.config.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PetDAO {
    private static int PET_COUNT;

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> index() {
        return jdbcTemplate.query("SELECT*FROM Pet", new PetRowMapper());
    }

    public Pet showById(int id) {
        return jdbcTemplate.query("SELECT*FROM Pet WHERE id =?", new Object[]{id},
                new PetRowMapper()).stream().findAny().orElse(null);
    }

    public void save(Pet pet){
        jdbcTemplate.update("INSERT INTO Pet VALUES (?, ?, ?, ?, ?)",
                ++PET_COUNT, pet.getName(), pet.getAge(), pet.getEmail(), pet.getType());
    }

    public void update(int id, Pet pet) {
        jdbcTemplate.update("INSERT INTO Pet VALUES (?, ?, ?, ?) WHERE Id = ?",
                pet.getName(), pet.getAge(), pet.getEmail(), pet.getType(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Pet WHERE id = ?", id);
    }
}


