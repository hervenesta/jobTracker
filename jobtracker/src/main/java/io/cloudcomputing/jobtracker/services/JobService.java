package io.cloudcomputing.jobtracker.services;

import io.cloudcomputing.jobtracker.exceptions.JobIdException;
import io.cloudcomputing.jobtracker.model.Job;
import io.cloudcomputing.jobtracker.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveOrUpdateJob(Job job){
        try{
//            job.setJobId(job.getJobId());
            return jobRepository.save(job);
        }catch(Exception ex){
            throw new JobIdException("Job ID '"+job.getJobId()+"' already exists.");
        }
    }

    public Job findJobById(Long jobId){
        Job job = jobRepository.findByJobId(jobId);

        if(job == null){
            throw new JobIdException("Job ID '"+jobId+"' doesn't exist.");
        }
        return job;
    }

    public Iterable<Job> findAllJobs(){
        return jobRepository.findAll();
    }

    public void deleteJobById(Long jobId){
        Job job = jobRepository.findByJobId(jobId);

        if(job == null){
            throw new JobIdException("Cannot delete job id '"+jobId+"' because it doesn't exist.");
        }

        jobRepository.delete(job);
    }
}
