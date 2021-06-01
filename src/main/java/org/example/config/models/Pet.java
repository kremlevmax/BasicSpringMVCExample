package org.example.config.models;

import javax.validation.constraints.*;

public class Pet {
    int id;
    @NotBlank(message = "You have to enter pet type")
    String type;

    @NotBlank(message =  "You have to enter pet's name")
    String name;

    @NotBlank(message = "You have to enter owner's email")
    @Email
    String email;

    @NotNull(message = "You have to enter pet's age")
    @Min(value = 0, message = "Age can't be negative")
    Integer age;

    public Pet(){
    }

    public Pet(int id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
