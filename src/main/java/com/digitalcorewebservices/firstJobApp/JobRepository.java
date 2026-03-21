package com.digitalcorewebservices.firstJobApp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalcorewebservices.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    
} 
