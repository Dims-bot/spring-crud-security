package ru.jm.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "Fist name should not be empty!")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name should not be empty!")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "The age cannot be less than 0.")
    private int age;


    public User(){

    }

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
