package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import org.springframework.stereotype.Component;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;


/**
 * @Author Noimik
 * Business service for ClaimDetailsMappper
 */
@Component
public class ClaimDetailsMapper {
	public ClaimDetailsDTO toModel(ClaimDetails claimDetails ) {
		
		
		ClaimDetailsDTO model=new ClaimDetailsDTO();
		model.setClaimId(claimDetails.getClaimId());
		model.setAmtApprovedBySurveyor(claimDetails.getAmtApprovedBySurveyor());
		model.setPolicyNo(claimDetails.getPolicyNo());
		model.setDateOfAccident(claimDetails.getDateOfAccident());
		model.setSurveyorFees(claimDetails.getSurveyorFees());
		model.setEstimatedLoss(claimDetails.getEstimatedLoss());
		model.setWithdrawClaim(claimDetails.isWithdrawClaim());
		model.setClaimStatus(claimDetails.isClaimStatus());
		model.setInsuranceCompanyApproval(claimDetails.isInsuranceCompanyApproval());
		return model;
	}
public List<ClaimDetailsDTO> toModels(List<ClaimDetails> claimDetails){
	
	  List<ClaimDetailsDTO> models = new ArrayList<>();
	  			models.forEach(models::add);
	   for (ClaimDetails claimDetails1 : claimDetails) {
		   models.add(toModel(claimDetails1));
       }
	return models;
}


public ClaimDetails toEntity(ClaimDetailsDTO claimDetailsDto ) {	
	ClaimDetails claims=new ClaimDetails();
	claims.setClaimId(claimDetailsDto.getClaimId());
	claims.setAmtApprovedBySurveyor(claimDetailsDto.getAmtApprovedBySurveyor());
	claims.setPolicyNo(claimDetailsDto.getPolicyNo());
	claims.setDateOfAccident(claimDetailsDto.getDateOfAccident());
	claims.setSurveyorFees(claimDetailsDto.getSurveyorFees());
	claims.setEstimatedLoss(claimDetailsDto.getEstimatedLoss());
	claims.setClaimStatus(claimDetailsDto.isClaimStatus());
	claims.setInsuranceCompanyApproval(claimDetailsDto.isInsuranceCompanyApproval());
	return claims;
}













public String generateClaimId(ClaimDetailsDTO claimDetailsModel) {
    // Assume PolicyNo is a 4-digit number (e.g., 1234)
    String policyNumber = claimDetailsModel.getPolicyNo(); // Replace with the actual policy number
    String requiredValue = policyNumber.substring(0, 4);
    // Get the last two digits of the current year
    int currentYear = LocalDate.now().getYear();
    String CurrentYearStr=Integer.toString(currentYear);

    // Combine the components to form the ClaimId
    String claimId = "CL" + requiredValue.toUpperCase() +CurrentYearStr;
    return claimId;
}



}
