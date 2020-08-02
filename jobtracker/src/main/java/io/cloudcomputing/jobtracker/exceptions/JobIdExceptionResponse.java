package io.cloudcomputing.jobtracker.exceptions;

public class JobIdExceptionResponse {
    private String jobId;

    public JobIdExceptionResponse(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
