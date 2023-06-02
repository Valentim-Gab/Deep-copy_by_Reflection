package org.example.model;

import org.example.decorators.NoCopy;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class User {
    public Integer id;
    public String username;
    @NoCopy
    public Boolean alive;
    public Date dateBirth;
    public Pet pet;
    public House house;
    public List<String> tasks = new LinkedList<>();

    public User() {}

    public User(Integer id, String username, Boolean alive, Date dateBirth, Pet pet, House house) {
        this.id = id;
        this.username = username;
        this.alive = alive;
        this.dateBirth = dateBirth;
        this.pet = pet;
        this.house = house;
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\tid = " + id +
                ", \n\tusername = '" + username + '\'' +
                ", \n\talive = " + alive +
                ", \n\tdateBirth = " + dateBirth +
                ", \n\tpet = " + pet +
                ", \n\thouse = " + house +
                ", \n\ttasks = " + tasks +
                "\n}";
    }
}
