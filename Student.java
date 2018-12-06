package com.iopo;

public class Student {

    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;
    private final String gender;
    private final String cnp;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String cnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCnp() {
        return cnp;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}