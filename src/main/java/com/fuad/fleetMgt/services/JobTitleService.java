package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.JobTitle;
import com.fuad.fleetMgt.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	// we need to autowire the Table from MySql
		@Autowired
		private JobTitleRepository jobTitleRepository;
				
		// Return list of jobTitles
		public List<JobTitle> getJobTitles(){
			return jobTitleRepository.findAll();
		}
				
		// Save a new JobTitle
		public void save(JobTitle jobTitle) {
			jobTitleRepository.save(jobTitle);
		}
				
		// delete a jobTitle
		public void delete(Integer id) {
			jobTitleRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<JobTitle> findById(int id){
			return jobTitleRepository.findById(id);
		}

}
