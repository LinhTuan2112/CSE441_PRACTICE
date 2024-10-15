package com.example.cse441_btth03;

import java.util.Deque;

public class Student {
    private String id;
    private String gender;
    private String birth_date;
    private String major;
    private String address;
    private String email;
    private double gpa;
    private int year;

    public Student(String address, String birth_date, int year, String major, String id, double gpa, String gender, String email) {
        this.address = address;
        this.birth_date = birth_date;
        this.year = year;
        this.major = major;
        this.id = id;
        this.gpa = gpa;
        this.gender = gender;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Deque<Object> getFullName() {
        return null;
    }
}
