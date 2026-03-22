package com.digitalcorewebservices.firstJobApp.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digitalcorewebservices.firstJobApp.job.Job;
import com.digitalcorewebservices.firstJobApp.job.JobRepository;
import com.digitalcorewebservices.firstJobApp.job.JobService;

@Service
public class JobServiceImplementation implements JobService {

    JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
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
                job.setCompany(updatedJob.getCompany());
                jobRepository.save(job);
                return true;
            }
        }
        return false;
    }
}
