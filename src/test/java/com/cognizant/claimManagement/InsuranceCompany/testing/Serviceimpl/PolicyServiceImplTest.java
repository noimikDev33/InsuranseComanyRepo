package com.cognizant.claimManagement.InsuranceCompany.testing.Serviceimpl;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.cognizant.claimManagement.InsuranceCompany.InsuranceCompanyApplication;
import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
//import com.cognizant.claimManagement.InsuranceCompany.Service.PolicyService;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.PolicyServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;
import com.cognizant.claimManagement.InsuranceCompany.repo.PolicyRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.PolicyMapper;


@SpringBootTest

@ContextConfiguration(classes = InsuranceCompanyApplication.class)
public class PolicyServiceImplTest  {
	
	
	@Autowired
    private PolicyDTO policyModel;
	@Autowired
    private PolicyRepo policyRepo;
//	@Autowired
//	private PolicyService policyService;
	
	@Autowired
	private PolicyMapper policyMapper;
	
	@Autowired
	private PolicyServiceImpl policyServiceimpl;

	@BeforeEach
	   public  void setUp() {
	 System.out.println("hello before all we start the test case ");
	 

	    }
	  @Test
	     void testAddNewPolicy() {
		  
		  policyModel = new PolicyDTO();
		  policyModel.setPolicyId("SM12345");
	        policyModel.setInsuredFirstName("John");
	        policyModel.setInsuredLastName("Doe");
	        policyModel.setDateOfInsurance(LocalDate.of(2024,02,21));
	        policyModel.setEmail("john.doe@example.com");
	        policyModel.setVehicleNo((long)7609123);
	        policyModel.setStatus(true);
	        
	        
	        policyModel = policyServiceimpl.addNewPolicy(policyModel);
	       
	       assertEquals(policyModel.getPolicyId(), policyModel.getPolicyId());
	       assertEquals(policyModel.getInsuredLastName(), policyModel.getInsuredLastName());
	       assertEquals(policyModel.getDateOfInsurance(), policyModel.getDateOfInsurance());
	       assertEquals(policyModel.getEmail(), policyModel.getEmail());
	       assertEquals(policyModel.getVehicleNo(), policyModel.getVehicleNo());
	       assertEquals(policyModel.isStatus(), policyModel.isStatus());
	       assertEquals(policyModel.getInsuredFirstName(), policyModel.getInsuredFirstName());
	    }
	  
	  
	  
	  @Test
	    void testGetAllPolicy_ReturnsEmptyList() {
	        
	       List<Policy> result=policyRepo.findAll();

	        // Assert
	        assertTrue(result.isEmpty());
	    }

	  
	  
	    @Test
	    void testGetAllPolicy_ReturnsNonEmptyList() {
	        // Arrange
	        Policy policy1 = new Policy();
	        policy1.setPolicyId("SM12345");
	        policy1.setInsuredFirstName("John");
	        policy1.setInsuredLastName("Doe");
	        policy1.setDateOfInsurance(LocalDate.of(2024, 2, 21));
	        policy1.setEmail("john.doe@example.com");
	        policy1.setVehicleNo(7609123L);
	        policy1.setStatus(true);

	        Policy policy2 = new Policy();
	        policy2.setPolicyId("SM12345");
	        policy2.setInsuredFirstName("tohn");
	        policy2.setInsuredLastName("moe");
	        policy2.setDateOfInsurance(LocalDate.of(2024, 2, 22));
	        policy2.setEmail("tohn.doe@example.com");
	        policy2.setVehicleNo(8697882L);
	        policy2.setStatus(false);
	        List<Policy> mockPolicyList = Arrays.asList(policy1, policy2);
		    List<PolicyDTO> result = policyMapper.toModels(mockPolicyList); 
		    System.out.println(result);
	        
	        // Assert
	        assertFalse(result.isEmpty());
	        assertEquals(2, result.size()); // Corrected expected size
	        // Add more assertions as needed
	    }
	    

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}


