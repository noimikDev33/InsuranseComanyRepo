
package com.cognizant.claimManagement.InsuranceCompany.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;



public interface ClaimDetailsService  {
	
	ClaimDetailsDTO addNewClaim(ClaimDetailsDTO claimDetailsModel);	
	ClaimDetailsDTO getClaimDetailsById(String claimID);
	ClaimDetailsDTO UpdateClaim(ClaimDetailsDTO claimDetailsModel, String claimID);
	public List<ClaimDetailsDTO> getAllClaimDetail();
	
	List<ClaimDetailsDTO> getClaimDetailsByMonthAndYear(Long month, Long year);
	Map<String, Long> getAllpaymentStatus(Long month, Long year);
}
