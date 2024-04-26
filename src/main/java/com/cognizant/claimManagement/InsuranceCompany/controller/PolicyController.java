


package com.cognizant.claimManagement.InsuranceCompany.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.PolicyService;

import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@EnableAspectJAutoProxy
/**
 * @author Noimik
 * Restful Web service - Rest Controller
 */

@Tag(name="PolicyController",description = "PolicyController Rest API")
@CrossOrigin("*")

public class PolicyController {
	
	
//	@Autowired
//	private PolicyRepo policyRepo;
//	
//	
//
//	
//	  
//	  @Autowired
//	  private PolicyDTO policyModel;
//	  
//	 
	  
	 @Autowired 
	 private PolicyService policyService;
	  
	
	  
	  /////////////////////////////////////////////////////////POLICY SECTION /////////////////////////////////////////////////////  
	  //http://localhost:8082/addPolicy  
	@PostMapping("/addPolicy")
	public ResponseEntity<PolicyDTO> addNewPolicy(@RequestBody PolicyDTO policyModel) {
		System.out.println(policyModel);
		PolicyDTO addedPolicyModel=policyService.addNewPolicy(policyModel);
		
		return new ResponseEntity<>(addedPolicyModel,HttpStatus.OK);
	}
	
	
	//http://localhost:8082/getAllPolicy
	@GetMapping("/getAllPolicy")
	public ResponseEntity<List<PolicyDTO>> getAllPolicies() {	
		try {
			List<PolicyDTO> allPolicy= policyService.getAllPolicy();
			if(allPolicy.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(allPolicy ,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//http://localhost:8082/getAllPolicy
	@GetMapping("/getAllPolicyId")
	public ResponseEntity<?> getAllPolicyId() {	
		try {
			List<String> allPolicyId= policyService.getAllPolicyId();
			if(allPolicyId.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(allPolicyId,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

	

		
		

}
