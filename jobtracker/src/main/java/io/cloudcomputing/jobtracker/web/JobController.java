package io.cloudcomputing.jobtracker.web;

import io.cloudcomputing.jobtracker.model.Job;
import io.cloudcomputing.jobtracker.services.JobService;
import io.cloudcomputing.jobtracker.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job")
@CrossOrigin //allows us to connect with React
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewJob(@Valid @RequestBody Job job, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null){
            return errorMap;
        }

        Job job1 = jobService.saveOrUpdateJob(job);
        return new ResponseEntity<Job>(job1, HttpStatus.CREATED);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<?> getJobById(@PathVariable Long jobId){
        Job job = jobService.findJobById(jobId);
        return new ResponseEntity<Job>(job, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Job> getAllJobs(){
        return jobService.findAllJobs();
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Long jobId){
        jobService.deleteJobById(jobId);
        return new ResponseEntity<String>("Job ID '"+jobId+"' was deleted.", HttpStatus.OK);
    }
}
