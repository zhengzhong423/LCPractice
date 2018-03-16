package com.zhong.restful;

public class Person {
    private static volatile int cnt = 0;

    private final String name;
    private final String gender;
    private final int id;

    public Person (String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.id = cnt;
        cnt ++;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

}

