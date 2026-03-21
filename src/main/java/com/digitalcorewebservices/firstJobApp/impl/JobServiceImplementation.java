package com.digitalcorewebservices.firstJobApp.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalcorewebservices.Job;
import com.digitalcorewebservices.firstJobApp.JobService;

@Service
public class JobServiceImplementation implements JobService {

    private List<Job> Jobs = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public void createJob(com.digitalcorewebservices.Job job) {
        job.setId(idCounter++);
        Jobs.add(job);
        
    }

    @Override
    public List<com.digitalcorewebservices.Job> findAll() {
        return Jobs;
    }

    @Override
    public Job findJobById(Long id) {
        for (Job job : Jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        for (Job job : Jobs) {
            if (job.getId().equals(id)) {
                Jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job : Jobs) {
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
