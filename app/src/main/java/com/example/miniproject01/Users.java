package com.example.miniproject01;

import androidx.annotation.NonNull;

public class Users {
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Users(String firstName, String lastName, String gender, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
    }

    public String fullName(){
        return String.format("%s %s",firstName,lastName);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s | %s | %s",fullName(),gender,city);
    }
}
