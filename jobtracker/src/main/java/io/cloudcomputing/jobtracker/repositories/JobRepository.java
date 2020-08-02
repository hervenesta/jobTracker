package io.cloudcomputing.jobtracker.repositories;

import io.cloudcomputing.jobtracker.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
    Job findByJobId(Long jobId);

    Iterable<Job> findAll();
}
