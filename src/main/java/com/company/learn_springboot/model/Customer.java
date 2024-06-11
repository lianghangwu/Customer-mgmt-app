package com.company.learn_springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("city")
    private String city;
    @JsonProperty("pinCode")
    private int pinCode;
    @JsonProperty("age")
    private int age;


    public Customer() {

    }

    public Customer(String firstName, String lastName, String city, int pinCode, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.pinCode = pinCode;
        this.age = age;
        this.id = id;
    }

    public boolean isValid() {
        if(this.firstName == null || this.lastName == null) {
            return false;
        }
        return true;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void print() {
        System.out.println("FirstName: " + firstName + ", LastName: " + lastName + ", City: " + city + ", Age: "
            + age + ", PinCode: " + pinCode + ", Id: " + id);
    }
}
