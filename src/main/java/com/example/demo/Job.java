package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="JOB_DATA")
public class Job  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;

    private String jobTitle;

    private String jobDescription;

    public Job() {
    }

    /*
    One Job has many UserInterviews (many users being interviewed for it)
    The mappedBy property is what we use to tell Hibernate which
    variable represents the parent class (Job)
    in our child class (JobInterviewUser).
    */
    @OneToMany(mappedBy = "job")
    private Set<JobInterviewUser> jobInterviewUsers;

    public Set<JobInterviewUser> getJobInterviewUsers() {
        return jobInterviewUsers;
    }

    public void setJobInterviewUsers(Set<JobInterviewUser> jobInterviewUsers) {
        this.jobInterviewUsers = jobInterviewUsers;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
