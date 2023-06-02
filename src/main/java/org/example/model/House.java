package org.example.model;

import org.example.decorators.NoCopy;

@NoCopy
public class House {
    public String houseName;

    public House() {}

    public House(String houseName) {
        this.houseName = houseName;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseName = '" + houseName + '\'' +
                "}";
    }
}
