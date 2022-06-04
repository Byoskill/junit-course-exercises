package com.byoskill.training.junit.hamcrest;

public class Person {
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender, String country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    private String country;
}
