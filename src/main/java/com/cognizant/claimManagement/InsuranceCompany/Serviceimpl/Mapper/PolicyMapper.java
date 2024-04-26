package com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;



@Component
public class PolicyMapper {
	
	public PolicyDTO toModel(Policy policy ) {
		
		
		PolicyDTO model=new PolicyDTO();
		model.setDateOfInsurance(policy.getDateOfInsurance());
		model.setEmail(policy.getEmail());
		model.setInsuredFirstName(policy.getInsuredFirstName());
		model.setInsuredLastName(policy.getInsuredLastName());
		model.setPolicyId(policy.getPolicyId());
		model.setStatus(policy.isStatus());
		model.setVehicleNo(policy.getVehicleNo());
		return model;
	}
public List<PolicyDTO> toModels(List<Policy> policy){
	
	  List<PolicyDTO> models = new ArrayList<>();
	  			models.forEach(models::add);
	   for (Policy policy1 : policy) {
		   models.add(toModel(policy1));
       }
	return models;
}


public String generatePolicyId(PolicyDTO policyModel) {
    String lastName = policyModel.getInsuredLastName(); // Replace with the actual last name
    String initials = lastName.substring(0, 2).toUpperCase();

    Long vehicleNumber = policyModel.getVehicleNo();

    int currentYear = LocalDate.now().getYear() % 100;

    // Combine the components to form the PolicyId
    String policyId = initials + String.format("%05d", vehicleNumber) + String.format("%02d", currentYear);

    // Assign the generated PolicyId to your field (e.g., PolicyId)
    // Replace the following line with your actual field assignment:
    // PolicyId = policyId;
    return policyId;
}

}
