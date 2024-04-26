
package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.ClaimDetailsService;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.exceptions.DataIntegrityViolationException;
import com.cognizant.claimManagement.InsuranceCompany.exceptions.ResourceNotFoundException;
import com.cognizant.claimManagement.InsuranceCompany.repo.ClaimDetailsRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.ClaimDetailsMapper;





@Service
/**
 * @Author Noimik
 * Business service for ClaimDetails
 */
public class ClaimDetailsServiceImpl implements ClaimDetailsService {
	
	

	
	  @Autowired
	  private ClaimDetailsRepo claimDetailsRepo;
	  
	  
	  @Autowired
	  public ClaimDetailsMapper claimDetailsMapper;
	  



	@Override
	public ClaimDetailsDTO addNewClaim(ClaimDetailsDTO claimDetailsModel) {
		// TODO Auto-generated method stub
	
		ClaimDetails c = new ClaimDetails();
		c.setClaimId(claimDetailsMapper.generateClaimId(claimDetailsModel));
		c.setPolicyNo(claimDetailsModel.getPolicyNo());
		c.setDateOfAccident(claimDetailsModel.getDateOfAccident());
		c.setClaimStatus(claimDetailsModel.isClaimStatus());
//		c.setSurveyorId(claimDetailsModel.getSurveyorId());
		c.setEstimatedLoss(claimDetailsModel.getEstimatedLoss());
		c.setAmtApprovedBySurveyor(claimDetailsModel.getAmtApprovedBySurveyor());
		c.setInsuranceCompanyApproval(claimDetailsModel.isInsuranceCompanyApproval());
		c.setWithdrawClaim(claimDetailsModel.isWithdrawClaim());
		c.setSurveyorFees(claimDetailsModel.getSurveyorFees());
		
		//Checking that ClaimId is Already Present or not
		if (claimDetailsRepo.findById(c.getClaimId()).isPresent()) {
	        throw new DataIntegrityViolationException("This","is",c.getClaimId());
	    }
		
		
		ClaimDetails claimObj =  claimDetailsRepo.save(c);	
		ClaimDetailsDTO addedModel = claimDetailsMapper.toModel(claimObj);
		
		
		return addedModel;
	}




	@Override
	public ClaimDetailsDTO UpdateClaim(ClaimDetailsDTO claimDetailsModel, String claimID) {
		ClaimDetails claims =	claimDetailsRepo.findById(claimID).orElseThrow(()->new ResourceNotFoundException("This","is",claimID));
		Optional<ClaimDetails> claimD=Optional.ofNullable(claims);
		
		ClaimDetails claimObj=null;
				
			ClaimDetails c = claimD.get();
			//c.setClaimId(claimDetailsModel.getClaimId());
			c.setPolicyNo(claimDetailsModel.getPolicyNo());
			c.setDateOfAccident(claimDetailsModel.getDateOfAccident());
			c.setClaimStatus(claimDetailsModel.isClaimStatus());
//			c.setSurveyorId(claimDetailsModel.getSurveyorId());
			c.setEstimatedLoss(claimDetailsModel.getEstimatedLoss());
			c.setAmtApprovedBySurveyor(claimDetailsModel.getAmtApprovedBySurveyor());
			c.setInsuranceCompanyApproval(claimDetailsModel.isInsuranceCompanyApproval());
			c.setWithdrawClaim(claimDetailsModel.isWithdrawClaim());
			c.setSurveyorFees(claimDetailsModel.getSurveyorFees());
			 claimObj =  claimDetailsRepo.save(c);
			 
			
		
		
	  return (ClaimDetailsDTO) claimDetailsMapper.toModel(claimObj);
	
	}
	

	
	@Override
	public List<ClaimDetailsDTO> getAllClaimDetail(){
		
		List<ClaimDetails> claimDetails = claimDetailsRepo.findAll();
        List<ClaimDetailsDTO> claimDetailsModels = claimDetailsMapper.toModels(claimDetails);
        
        return claimDetailsModels;
		
	}




	@Override
	public List<ClaimDetailsDTO> getClaimDetailsByMonthAndYear(Long month, Long year) {
		 List<ClaimDetails> claimList = claimDetailsRepo.findAll();
		 
	      List<ClaimDetailsDTO> claimDetailsModels = claimDetailsMapper.toModels(claimList);
          
	        // filter the claim list by month and year
	      claimDetailsModels = claimDetailsModels.stream()
	                .filter(i -> i.getDateOfAccident().getMonthValue() == month && i.getDateOfAccident().getYear() == year)
	                .collect(Collectors.toList());
			

	        return claimDetailsModels;
	}




	@Override
	public Map<String, Long> getAllpaymentStatus(Long month, Long year) {
		// TODO Auto-generated method stub
		List<ClaimDetails> claimList = claimDetailsRepo.findAll();
		 
	      List<ClaimDetailsDTO> claimDetailsModels = claimDetailsMapper.toModels(claimList);
        
	        // filter the claim list by month and year
	      claimDetailsModels = claimDetailsModels.stream()
	                .filter(i -> i.getDateOfAccident().getMonthValue() == month && i.getDateOfAccident().getYear() == year)
	                .collect(Collectors.toList());
			
	      
	     long approvedClaims= claimDetailsModels
	    		 	.stream()
	                .filter(i ->i.isClaimStatus()==true && i.isInsuranceCompanyApproval()==true && i.isWithdrawClaim()==true)
	                .count();
	     
	     long newClaims= claimDetailsModels
	    		 	.stream()
	                .filter(i ->i.isClaimStatus()==false && i.isInsuranceCompanyApproval()==false && i.isWithdrawClaim()==false)
	                .count();
	     long pendingClaims= claimDetailsModels
	    		 	.stream()
	                .filter(i ->i.isClaimStatus()==true && i.isInsuranceCompanyApproval()==false && i.isWithdrawClaim()==false)
	                .count();
	     
	     Map<String, Long> claimCounts = new HashMap<>();
	        claimCounts.put("Approved Claims", approvedClaims);
	        claimCounts.put("New Claims", newClaims);
	        claimCounts.put("Pending", pendingClaims);
		return claimCounts;
	}




	@Override
	public ClaimDetailsDTO getClaimDetailsById(String claimID) {
		
		// TODO Auto-generated method stub
		ClaimDetails claims =	claimDetailsRepo.findById(claimID).orElseThrow(()->new ResourceNotFoundException("This","is",claimID));
		ClaimDetailsDTO claimDto=claimDetailsMapper.toModel(claims);
		
		return claimDto;
	}






	
	

}