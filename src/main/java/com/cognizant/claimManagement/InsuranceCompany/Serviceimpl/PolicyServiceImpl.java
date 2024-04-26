
package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.PolicyService;
import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;
import com.cognizant.claimManagement.InsuranceCompany.repo.PolicyRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.PolicyMapper;

@Service
/**
 * @Author Nomik
 * Business service for Policy
 */
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepo policyRepo;

	@Autowired
	private PolicyMapper policyMapper;

	@Override
	public PolicyDTO addNewPolicy(PolicyDTO policyModel) {
		// TODO Auto-generated method stub

		Policy newPolicy = new Policy();
		newPolicy.setPolicyId(policyMapper.generatePolicyId(policyModel));
		newPolicy.setInsuredFirstName(policyModel.getInsuredFirstName());
		newPolicy.setInsuredLastName(policyModel.getInsuredLastName());
		newPolicy.setDateOfInsurance(policyModel.getDateOfInsurance());
		newPolicy.setEmail(policyModel.getEmail());
		newPolicy.setVehicleNo(policyModel.getVehicleNo());
		newPolicy.setStatus(policyModel.isStatus());

		Policy policyObj = policyRepo.save(newPolicy);

		PolicyDTO addedModel = policyMapper.toModel(policyObj);

		return addedModel;
	}

	@Override
	public List<PolicyDTO> getAllPolicy() {
		// TODO Auto-generated method stub

		List<Policy> allPolicy = policyRepo.findAll();
		List<PolicyDTO> allPolicyModel = policyMapper.toModels(allPolicy);
		return allPolicyModel;
	}

	@Override
	public List<String> getAllPolicyId() {
		// TODO Auto-generated method stub
		
		List<Policy> allPolicy = policyRepo.findAll();
		List<PolicyDTO> allPolicyModel = policyMapper.toModels(allPolicy);
		List<String> allClaimList = allPolicyModel.stream()
		        .map(e -> e.getPolicyId()) // Use 'map' instead of 'flatMap'
		        .collect(Collectors.toList());

		
		return allClaimList;
	}

}