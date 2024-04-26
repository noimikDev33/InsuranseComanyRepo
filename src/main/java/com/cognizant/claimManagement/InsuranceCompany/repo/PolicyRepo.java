package com.cognizant.claimManagement.InsuranceCompany.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;


@Repository
public interface PolicyRepo extends JpaRepository<Policy, String>{
	
	

}