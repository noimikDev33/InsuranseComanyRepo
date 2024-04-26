
package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.claimManagement.InsuranceCompany.DTO.SurveyorDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.SurveyorService;
import com.cognizant.claimManagement.InsuranceCompany.entity.Surveyor;
import com.cognizant.claimManagement.InsuranceCompany.repo.SurveyorRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.SurveyorMapper;


@Service
/**
 * @Author Noimik
 * Business service for Surveyor
 */
public class SurveyorServiceImpl implements SurveyorService {
	
	
	
	

	@Autowired
	private SurveyorRepo surveyorRepo;
	
	@Autowired
	private SurveyorMapper surveyorMapper;
	
	
	  





	@Override
	public SurveyorDTO addNewSurveyor(SurveyorDTO surveyorModel) {
		// TODO Auto-generated method stub
		
		
		Surveyor s=new Surveyor();
		s.setSurveyorId(surveyorModel.getSurveyorId());
		s.setFirstName(surveyorModel.getFirstName());
		s.setLastName(surveyorModel.getLastName());
		s.setEstimateLimit(surveyorModel.getEstimateLimit());
		Surveyor newSurveyor=surveyorRepo.save(s);
		SurveyorDTO newSurveyorModel = surveyorMapper.toModel(newSurveyor);
		return newSurveyorModel;
		
		
	}



	

	@Override
	public List<SurveyorDTO> getAllSurveyors() {
		// TODO Auto-generated method stub
		List<Surveyor> claimDetails = surveyorRepo.findAll();
        List<SurveyorDTO> claimDetailsModels = surveyorMapper.toModels(claimDetails);
        return claimDetailsModels;
		
	}
	
	
	
	




	@Override
	public List<SurveyorDTO> getSurveyorbyEstimatedLoss(long estimatedLoss) {
		// TODO Auto-generated method stub
	
		List<Surveyor> allSurveyorsEntity=surveyorRepo.findAll();
	
		List<SurveyorDTO> allSurveyorModel=surveyorMapper.toModels(allSurveyorsEntity);

		

		allSurveyorModel = allSurveyorModel.stream()
                .filter(i -> i.getEstimateLimit() == estimatedLoss)
                .collect(Collectors.toList());
		
	
        return allSurveyorModel;
	}





	@Override
	public Optional<SurveyorDTO> getSurveyorById(long claimId) {
		Optional<Surveyor> targetSurveyor=surveyorRepo.findById(claimId);
		Optional<SurveyorDTO> targetSurveyorModel = targetSurveyor.map(surveyorMapper::toModel);
		
		return (Optional<SurveyorDTO>)targetSurveyorModel;
	}


	

}