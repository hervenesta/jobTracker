package io.cloudcomputing.jobtracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Access(value=AccessType.FIELD)
public class Job {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @NotBlank(message = "Job Id is required")
//    @Size(min=3, max=6, message = "Please use 3 to 6 characters")
//    @Column(updatable = false, unique = true)
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="jobId", insertable = false, updatable = false, nullable = false, unique = true)

//    @Id
//    @Column(name = "jobId", unique = true, nullable = false)
//    @GeneratedValue(generator = "gen")
//    @GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "job") })
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    @NotBlank(message = "Job Title is required")
    private String jobTitle;

    @NotBlank(message = "Company Name is required")
    private String companyName;

    private String postURL;

    @NotBlank(message = "Job Location is required")
    private String jobLocation;

    private double salary;

    @NotBlank(message = "Job Description is required")
    private String jobDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date created_At;

    @NotBlank(message = "Job Status is required")
    private String status;

    public Job() {
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostURL() {
        return postURL;
    }

    public void setPostURL(String postURL) {
        this.postURL = postURL;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }
}
