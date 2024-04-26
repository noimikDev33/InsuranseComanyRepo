package com.cognizant.claimManagement.InsuranceCompany.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.entity.Surveyor;


@Repository
public interface SurveyorRepo extends JpaRepository<Surveyor, Long>  {


}
