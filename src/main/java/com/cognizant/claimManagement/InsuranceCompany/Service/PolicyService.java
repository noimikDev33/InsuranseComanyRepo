

package com.cognizant.claimManagement.InsuranceCompany.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;







public interface PolicyService  {
	
	

	PolicyDTO addNewPolicy(PolicyDTO policyModel);

	List<PolicyDTO> getAllPolicy();
	List<String> getAllPolicyId();
	
	
	

}
