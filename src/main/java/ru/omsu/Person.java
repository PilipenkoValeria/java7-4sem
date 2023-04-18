package ru.omsu;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirthday;

    public Person(String surname, String name, String patronymic, String dateOfBirthday) {
        if (surname == null || surname.length() < 1 || name == null || name.length() < 1 ||
                patronymic == null || patronymic.length() == 0 || dateOfBirthday==null) {
            throw new IllegalArgumentException("Ошибка! Получены некорректные данные.");
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return surname.equals(person.surname) &&
                name.equals(person.name) &&
                patronymic.equals(person.patronymic) &&
                dateOfBirthday.equals(person.dateOfBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, dateOfBirthday);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
}
