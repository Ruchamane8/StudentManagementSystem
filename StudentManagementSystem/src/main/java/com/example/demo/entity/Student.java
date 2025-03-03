package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a Student entity with attributes such as ID,
 * first name, last name, roll number, email, and address.
 */

@Entity
@Table(name = "students")
public class Student {

    // Unique identifier for each student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    /* @Column(unique = true)
    private Integer rollNo; */  // Changed int → Integer to allow null values

    // Email of the student, must be unique
    @Column(unique = true)
    private String email;

    // Address of the student
    private String address;

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Parameterized constructor to initialize a Student object.
     */
    public Student(Long id, String firstName, String lastName, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        
        this.email = email;
        this.address = address;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a string representation of the Student object.
     */
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", email=" + email + ", address=" + address + "]";
    }
}
