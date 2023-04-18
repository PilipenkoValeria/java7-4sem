package ru.omsu;

import java.io.*;
import java.util.*;

public class Flat implements Serializable {
    private int numberFlat;
    private int squareFlat;
    private List<Person> ownerFlat;

    public Flat(int numberFlat, int squareFlat, List<Person> ownerFlat) {
        this.numberFlat = numberFlat;
        this.squareFlat = squareFlat;
        this.ownerFlat = new ArrayList<>(ownerFlat);
    }

    public Flat() {}


    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    public int getSquareFlat() {
        return squareFlat;
    }

    public void setSquareFlat(int squareFlat) {
        this.squareFlat = squareFlat;
    }

    public List<Person> getOwnerFlat() {
        return ownerFlat;
    }

    public void setOwnerFlat(List<Person> ownerFlat) {
        this.ownerFlat = ownerFlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return numberFlat == flat.numberFlat &&
                squareFlat == flat.squareFlat &&
                Objects.equals(ownerFlat, flat.ownerFlat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberFlat, squareFlat, ownerFlat);
    }
}
