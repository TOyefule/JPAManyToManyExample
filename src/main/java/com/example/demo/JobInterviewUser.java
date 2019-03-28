package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
/*
JobInterviewUser allows us to "link" Jobs, Interviews and Users
by creating a table which contains a JobId, InterviewId and UserId
*/


@Entity
public class JobInterviewUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
    Each JobInterviewUser combination only occurs only once
    because there is only one interview for one user for one job
     */
    @ManyToOne
    private Job job;

    @ManyToOne
    private Interview interview;

    @ManyToOne
    private User user;

    public JobInterviewUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
