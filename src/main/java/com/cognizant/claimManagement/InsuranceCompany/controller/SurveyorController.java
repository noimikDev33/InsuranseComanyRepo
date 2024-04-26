
package com.cognizant.claimManagement.InsuranceCompany.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.claimManagement.InsuranceCompany.DTO.SurveyorDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.SurveyorService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@EnableAspectJAutoProxy

/**
 * @Author Noimik
 * Restful Web service - Rest Controller
 */

@Tag(name="SurveyorController",description = "SurveyorController Rest API")

public class SurveyorController {
	
	
	  

	  @Autowired
	  private SurveyorService surveyorService;

	
	
	
	//http://localhost:8082/api/Surveyor/new
		@PostMapping("/api/Surveyor/new")
		public ResponseEntity<SurveyorDTO> addNewSurveyor(@RequestBody  SurveyorDTO surveyorModel) {
			SurveyorDTO surveyor=this.surveyorService.addNewSurveyor(surveyorModel);
			return new ResponseEntity<>(surveyor,HttpStatus.OK);
			
		
		}
	
	
	
	
	
		
		
	
		
		//http://localhost:8082/getAllSurveyorDetails
		@GetMapping("/getAllSurveyorDetails")
		public ResponseEntity<List<SurveyorDTO>> getSurveyor() {
			
			
			try {
				List<SurveyorDTO> surveyorList = surveyorService.getAllSurveyors();
				
				if(surveyorList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(surveyorList ,HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
	
		
		

	

		
	
		
		
		//http://localhost:8082/api/surveyors/{estimatedLoss}
		@GetMapping("/api/surveyors/{estimatedLoss}")
		public ResponseEntity<List<SurveyorDTO>> getSurveyorbyEstimatedLoss(@PathVariable long estimatedLoss)  {
			
		
			try {
				List<SurveyorDTO> surveyorList = surveyorService.getSurveyorbyEstimatedLoss(estimatedLoss);
				if(surveyorList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
					  return  new ResponseEntity<>(surveyorList,HttpStatus.OK);
				
			}catch(Exception ex) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@GetMapping("/api/surveyorfees/{claimId}")
public ResponseEntity<?> approvedSurveyors(@PathVariable long claimId){
			
			Optional<SurveyorDTO> approvedSurveyor=surveyorService.getSurveyorById(claimId);
			if(approvedSurveyor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(approvedSurveyor,HttpStatus.OK);
			
		}
		
	
		


		
		

}
