
package com.cognizant.claimManagement.InsuranceCompany.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;

import com.cognizant.claimManagement.InsuranceCompany.Service.ClaimDetailsService;

import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.exceptions.ResourceNotFoundException;
import com.cognizant.claimManagement.InsuranceCompany.repo.ClaimDetailsRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * @author Noimik Sarkar Restful Web service - Rest Controller
 * Controller for Claim Insurance Company 
 */
@RestController

@Tag(name = "ClaimDetails", description = "Claim Rest API")
@OpenAPIDefinition(info=@Info(title="ClaimManagement Rest APIs"))
@CrossOrigin("http://localhost:4200/")

public class ClaimDetailsController {

	@Autowired
	private ClaimDetailsRepo claimDetailsRepo;

	@Autowired
	private ClaimDetailsService claimDetailsService;

	// http://localhost:8082/api/claims/new
	@PostMapping("/api/claims/new")
	public ResponseEntity<ClaimDetailsDTO> addNewClaim(@Valid @RequestBody ClaimDetailsDTO claimDetailsModel) {

		ClaimDetailsDTO claim = this.claimDetailsService.addNewClaim(claimDetailsModel);
		if (claim != null) {
			return new ResponseEntity<>(claim, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

//	//http://localhost:8082/getAllClaimDetails
	@GetMapping("/getAllClaimDetails")
	public ResponseEntity<List<ClaimDetailsDTO>> getAllClaimDetails() {

		List<ClaimDetailsDTO> claimList = claimDetailsService.getAllClaimDetail();

		if (!claimList.isEmpty()) {
			return new ResponseEntity<>(claimList, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("The", "List", "Empty");
	}

//	//http://localhost:8082/getClaimDetailsById/{claimID}
	@GetMapping("/getClaimDetailsById/{claimId}")
	public ResponseEntity<?> getClaimDetailsById(@PathVariable String claimId) {
		System.out.println(claimId);

		ClaimDetailsDTO claim = claimDetailsService.getClaimDetailsById(claimId);
		

		if (claim != null) {

			return new ResponseEntity<>(claim, HttpStatus.OK);
		}
		return null;
		
	}

	// http://localhost:8082/api/claims/update/{claimID}
	@PutMapping("api/claims/update/{claimID}")
	public ResponseEntity<ClaimDetailsDTO> updateClaimData(@Valid @RequestBody ClaimDetailsDTO claimDetailsModel,
			@PathVariable String claimID) {

		ClaimDetailsDTO model = this.claimDetailsService.UpdateClaim(claimDetailsModel, claimID);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	// http://localhost:8082/api/claims/update/{claimId}/{claimAmt}
	@GetMapping("/api/claims/update/{claimId}/{claimAmt}")
	public ResponseEntity<?> approvedClaimAmtClaimId(@PathVariable String claimId, @PathVariable long claimAmt) {
		Optional<ClaimDetails> claimtProfile = (claimDetailsRepo.findById(claimId));
		if (claimtProfile.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(claimtProfile, HttpStatus.OK);
	}

	// http://localhost:8082/api/claimStatus/report/{month}/{year}
	@GetMapping("api/claimStatus/report/{month}/{year}")
	public ResponseEntity<?> ViewReportByDate(@PathVariable Long month, @PathVariable Long year) {
		List<ClaimDetailsDTO> claimList = claimDetailsService.getClaimDetailsByMonthAndYear(month, year);
		if (claimList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(claimList, HttpStatus.OK);
	}

	// http://localhost:8082/api/paymentStatus/report/{month}/{year}
	@GetMapping("api/paymentStatus/report/{month}/{year}")
	public ResponseEntity<?> ViewPayMentStatusOfClaim(@PathVariable Long month, @PathVariable Long year) {

		Map<String, Long> paymentStatus = claimDetailsService.getAllpaymentStatus(month, year);
		if (paymentStatus.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
	}

}
