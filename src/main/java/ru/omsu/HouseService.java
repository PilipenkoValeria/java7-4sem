package ru.omsu;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class HouseService implements Serializable {
    public static void serializeHouse(House house, String filename) throws IOException {
        try (ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(house);
        }
    }

    public static House deserializeHouse(String filename) throws IOException, ClassNotFoundException, ClassCastException {
        try (ObjectInput objectInput = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (House) objectInput.readObject();
        }
    }
    public static String serializeHouseString(House house) throws IOException {
        return new ObjectMapper().writeValueAsString(house);
    }
    public static House deserializeHouseString(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, House.class);
    }
}
