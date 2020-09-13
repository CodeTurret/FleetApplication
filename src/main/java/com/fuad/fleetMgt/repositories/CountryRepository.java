package com.fuad.fleetMgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuad.fleetMgt.models.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
