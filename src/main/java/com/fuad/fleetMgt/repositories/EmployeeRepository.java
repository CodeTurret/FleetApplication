package com.fuad.fleetMgt.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fuad.fleetMgt.models.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// if nativeQuery isn't mention, Spring will throw an error
	@Query(value="select * from Employee e where e.firstname like %keyword% or e.lastname like %keyword%",nativeQuery =true)
	public List<Employee> findByKeyword(@Param("keyword") String keyword);
	
	public Employee findByUsername(String un);

}
