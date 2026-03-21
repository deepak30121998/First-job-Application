package com.digitalcorewebservices.firstJobApp.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digitalcorewebservices.Job;
import com.digitalcorewebservices.firstJobApp.JobRepository;
import com.digitalcorewebservices.firstJobApp.JobService;

@Service
public class JobServiceImplementation implements JobService {

    // private List<Job> Jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long idCounter = 1L;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public void createJob(com.digitalcorewebservices.Job job) {
        job.setId(idCounter++);
        jobRepository.save(job);
        
    }

    @Override
    public List<com.digitalcorewebservices.Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return job;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
