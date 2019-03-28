package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

// The User class is a POJO: Plain Old Java Object
// It meets the criteria for a Java Bean:
/*
JavaBean defines a standard:
    1. All properties private (use getters/setters)
    2. A public no-argument constructor
    3. Implements Serializable
 */
// Serializable objects can be written to
// streams, files, object databases

// Each entity represents one table in the database
// each row of the database represents one instance
// of the entity object (this class) with all its data.
// User the @Table annotation to rename the table in the
// database
@Entity
@Table(name="USER_DATA")
public class User implements Serializable {
    // JPA requires a unique primary key for each entity
    // The GeneratedValue annotation is used with the Id
    // annotation to populate the Id values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    /*
    One User has many JobInterviews
    The mappedBy property is what we use to tell Hibernate which
    variable represents the parent class (User)
    in our child class (JobInterviewUser).
    */
    @OneToMany(mappedBy = "user")
    private Set<JobInterviewUser> jobInterviewUser;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<JobInterviewUser> getJobInterviewUser() {
        return jobInterviewUser;
    }

    public void setJobInterviewUser(Set<JobInterviewUser> jobInterviewUser) {
        this.jobInterviewUser = jobInterviewUser;
    }
}
