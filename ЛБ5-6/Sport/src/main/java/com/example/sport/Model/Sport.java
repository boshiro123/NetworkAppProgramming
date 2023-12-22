package com.example.sport.Model;

public class Sport {
    private int id;
    private String surname;
    private String first_name;
    private String second_name;
    private int age;
    private int height;
    private int weight;

    public Sport(int id, String surname, String first_name, String second_name, int age, int height, int weight) {
        this.id = id;
        this.surname = surname;
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Sport(String surname, String first_name, String second_name, int age, int height, int weight) {
        this.surname = surname;
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
