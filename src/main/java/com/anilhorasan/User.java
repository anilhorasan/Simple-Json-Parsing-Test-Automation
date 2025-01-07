package com.anilhorasan;

/**
 * The User class represents a simple data model for a user.
 * This class is used to hold basic user information such as:
 * - name (String)
 * - email (String)
 * - age (int)
 *
 * It provides constructors for creating a user with or without initial values,
 * getters and setters for each field, and a toString method to display the user's
 * information in a readable format.
 *
 * This class is used in various tests to parse JSON data into User objects
 * and demonstrates the usage of libraries like Jackson, Gson, and org.json.
 */

public class User {
    private String name;
    private String email;
    private int age;

    // Constructors
    public User() {}
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
