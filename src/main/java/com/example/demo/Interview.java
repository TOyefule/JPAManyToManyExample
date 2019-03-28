package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="INTERVIEW_DATA")
public class Interview  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String interviewDate;

    private String interviewTime;

    /*
    One Interview has many UserJobs (Users applying for Jobs)
    The mappedBy property is what we use to tell Hibernate which
    variable represents the parent class (Interview)
    in our child class (JobInterviewUser).
    */
    @OneToMany(mappedBy = "interview")
    private Set<JobInterviewUser> jobInterviewUser;

    public Interview(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public Set<JobInterviewUser> getJobInterviewUser() {
        return jobInterviewUser;
    }

    public void setJobInterviewUser(Set<JobInterviewUser> jobInterviewUser) {
        this.jobInterviewUser = jobInterviewUser;
    }
}
