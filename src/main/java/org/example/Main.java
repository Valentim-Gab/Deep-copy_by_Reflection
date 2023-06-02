package org.example;

import org.example.model.House;
import org.example.model.Pet;
import org.example.model.User;
import org.example.services.DeepCopy;
import org.example.utils.File;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        DeepCopy deepCopy = new DeepCopy();
        File file = new File();
        Date dateBirth = Date.valueOf("2003-02-24");

        House house = new House("Casa 1");
        Pet pet = new Pet("Pet 1", 5);
        User user = new User(1, "Rafael", true, dateBirth, pet, house);
        user.tasks.add("Correr");

        User userClone = deepCopy.copyObject(user);

        user.tasks.add("Trabalhar");

        System.out.println(user);
        file.saveToFile(user.toString(), "user_and_userclone.def");

        System.out.println(userClone);
        file.saveToFile(userClone.toString(), "user_and_userclone.def");
    }
}