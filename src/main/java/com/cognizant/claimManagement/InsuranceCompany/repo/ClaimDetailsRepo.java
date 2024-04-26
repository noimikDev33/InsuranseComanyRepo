package com.cognizant.claimManagement.InsuranceCompany.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;

@Repository
/**
 * @Author Noimik
 * Repository for  ClaimDetails
 */
public interface ClaimDetailsRepo extends JpaRepository<ClaimDetails, String>  {
//	@Query("SELECT c FROM ClaimDetails c WHERE c.ClaimId IN (SELECT d.ClaimId FROM ClaimDetails d WHERE YEAR(d.DateOfAccident) =:y AND MONTH(d.DateOfAccident) =:m)")
//	<List> ClaimDetails findByDateOfAccident(@Param("m") Long month,@Param("y") Long year);

//	@Query("SELECT c FROM ClaimDetails c  WHERE YEAR(c.DateOfAccident) =:y AND MONTH(c.DateOfAccident) =:m)")
//	<List> ClaimDetails findAllByDateOfAccident(@Param("m") Long month,@Param("y") Long year);
//	
//	
	
//	@Query("SELECT c FROM ClaimDetails c WHERE c.ClaimId IN (SELECT d.ClaimId FROM ClaimDetails d WHERE YEAR(d.DateOfAccident) =:y AND MONTH(d.DateOfAccident) =:m)")
//	<List> ClaimDetails findAllByDateOfAccident(@Param("m") Long month,@Param("y") Long year);


	
 


}
