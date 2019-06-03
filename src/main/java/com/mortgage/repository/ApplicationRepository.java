package com.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mortgage.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	@Query(value = "select * from application where status = \"New\" order by time_modified DESC LIMIT 3 ", nativeQuery = true)
	List<Application> getDetailsBasedOnStatusNew();

	@Query(value = "select * from application where status = \"Approved\" order by time_modified DESC LIMIT 3", nativeQuery = true)
	List<Application> getDetailsBasedOnStatusApproved();

	@Query(value = "select * from application where status = \"Funded\" order by time_modified DESC LIMIT 3", nativeQuery = true)
	List<Application> getDetailsBasedOnStatusFunded();

}
