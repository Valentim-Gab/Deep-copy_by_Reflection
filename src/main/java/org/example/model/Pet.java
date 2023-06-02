package org.example.model;

import org.example.decorators.NoCopy;

public class Pet {
    public String petName;
    @NoCopy
    public Integer age;

    public Pet() {}

    public Pet(String petName, Integer age) {
        this.petName = petName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName = '" + petName + '\'' +
                ", age = " + age +
                '}';
    }
}
