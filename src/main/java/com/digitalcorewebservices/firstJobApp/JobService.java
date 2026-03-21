package com.digitalcorewebservices.firstJobApp;

import java.util.List;

import com.digitalcorewebservices.Job;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
}
