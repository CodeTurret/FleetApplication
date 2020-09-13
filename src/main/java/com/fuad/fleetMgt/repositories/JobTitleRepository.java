package com.fuad.fleetMgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuad.fleetMgt.models.JobTitle;



@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
