package com.ashwani.jobapp.company;

import com.ashwani.jobapp.job.Job;
import com.ashwani.jobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @JsonIgnore // ignore krna hai iss field ko, Infinite recursion error aa rhi thi
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL) // ye map ho rha hai, Job class k company se, Iss Table mey ye field nhi bnega
    private List<Job> jobs;

    @OneToMany(mappedBy = "company") // one company has many reviews
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

    public Company(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
