package com.example.demo;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobInterviewUserRepository jobInterviewUserRepository;


    @RequestMapping("/")
    public String home(Model model){
    /* Just to see if the application works, we
    mock up some data in the controller
    and add it to the respective repositories. Then
    we can check the database to make sure everything is
    created as expected.

    This strategy also allows the database person to work
    independently from the other
    */

    //add record
    Job job = new Job();
    job.setJobId(1);
    job.setJobTitle("Java Instructor");
    jobRepository.save(job);

    Interview interview = new Interview();
    interview.setId(10);
    interview.setInterviewDate(LocalDate.now().toString());
    interviewRepository.save(interview);

    User user = new User();
    user.setId(1000);
    user.setFirstName("Bart");
    user.setLastName("Simpson");
    user.setEmail("bart@fox.net");
    userRepository.save(user);

    JobInterviewUser jiu = new JobInterviewUser();
    jiu.setJob(job);
    jiu.setInterview(interview);
    jiu.setUser(user);
    jobInterviewUserRepository.save(jiu);


    model.addAttribute("jobInterviewUser",jiu);
        return "index";
    }
    @RequestMapping("/show")
    public String add(){

        return "index";
    }
}
