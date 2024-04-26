package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.DTO.SurveyorDTO;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.entity.Surveyor;


@Component
public class SurveyorMapper {

	
	public SurveyorDTO toModel(Surveyor surveyor ) {
		
		
		SurveyorDTO model=new SurveyorDTO();
		model.setEstimateLimit(surveyor.getEstimateLimit());;
		model.setSurveyorId(surveyor.getSurveyorId());;
		model.setFirstName(surveyor.getFirstName());
		model.setLastName(surveyor.getLastName());
		return model;
	}
public List<SurveyorDTO> toModels(List<Surveyor> surveyor){
	
	  List<SurveyorDTO> models = new ArrayList<>();
	  			models.forEach(models::add);
	   for (Surveyor surveyor1 : surveyor) {
		   models.add(toModel(surveyor1));
       }
	return models;
}
}



	


