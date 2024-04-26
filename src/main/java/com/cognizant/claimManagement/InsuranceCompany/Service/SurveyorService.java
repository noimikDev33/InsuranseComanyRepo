

package com.cognizant.claimManagement.InsuranceCompany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.DTO.SurveyorDTO;



public interface SurveyorService  {

	
	SurveyorDTO addNewSurveyor(SurveyorDTO surveyorModel);

	List<SurveyorDTO> getAllSurveyors();

	List<SurveyorDTO> getSurveyorbyEstimatedLoss(long estimatedLoss);

	Optional<SurveyorDTO> getSurveyorById(long claimId);
	
	
	

}
