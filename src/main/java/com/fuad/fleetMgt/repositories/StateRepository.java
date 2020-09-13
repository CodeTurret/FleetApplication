package com.fuad.fleetMgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fuad.fleetMgt.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}