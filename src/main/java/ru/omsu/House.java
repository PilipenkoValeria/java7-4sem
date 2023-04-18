package ru.omsu;

import java.io.*;
import java.util.*;

public class House implements Serializable {
    private String IdHouse;
    private String address;
    private Person leaderHouse;
    private List<Flat> flatsHouse;

    public House(String idHouse, String address, Person leaderHouse, List<Flat> flatsHouse) {
        IdHouse = idHouse;
        this.address = address;
        this.leaderHouse = leaderHouse;
        this.flatsHouse = new ArrayList<>(flatsHouse);
    }

    public House() {}

    public String getIdHouse() {
        return IdHouse;
    }

    public void setIdHouse(String idHouse) {
        IdHouse = idHouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getLeaderHouse() {
        return leaderHouse;
    }

    public void setLeaderHouse(Person leaderHouse) {
        this.leaderHouse = leaderHouse;
    }

    public List<Flat> getFlatsHouse() {
        return flatsHouse;
    }

    public void setFlatsHouse(List<Flat> flatsHouse) {
        this.flatsHouse = flatsHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(IdHouse, house.IdHouse) &&
                Objects.equals(address, house.address) &&
                Objects.equals(leaderHouse, house.leaderHouse) &&
                Objects.equals(flatsHouse, house.flatsHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdHouse, address, leaderHouse, flatsHouse);
    }

    public void serialize(ObjectOutput out) throws IOException {
        out.writeObject(this);
    }
}
