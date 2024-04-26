
package com.cognizant.claimManagement.InsuranceCompany.testing.Serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.PolicyServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;
import com.cognizant.claimManagement.InsuranceCompany.repo.PolicyRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.PolicyMapper;

class TestPolicyService {


	@Mock
	private PolicyRepo policyRepo;
	@Mock
	PolicyMapper policyMapper;
	
	@Mock 
	Policy policy;
	
	
	
	@InjectMocks
	private PolicyServiceImpl policyServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	
 
	@Test
	 void testAddNewPolicy() {
	    
	    Policy policyEntity=new Policy();
	    policyEntity.setPolicyId("SM12345");
	    policyEntity.setInsuredFirstName("John");
	    policyEntity.setInsuredLastName("Doe");
	    policyEntity.setDateOfInsurance(LocalDate.of(2024, 2, 21));
	    policyEntity.setEmail("john.doe@example.com");
	    policyEntity.setVehicleNo(7609123L); // Corrected the casting issue
	    policyEntity.setStatus(true);

	    // Mock the behavior of your DAO
	    
	    
	    when(policyRepo.save(any())).thenAnswer(new Answer<Policy>(){

			@Override
			public Policy answer(InvocationOnMock invocation) throws Throwable {
				Policy policyEntity=new Policy();
			    policyEntity.setPolicyId("SM12345");
			    policyEntity.setInsuredFirstName("John");
			    policyEntity.setInsuredLastName("Doe");
			    policyEntity.setDateOfInsurance(LocalDate.of(2024, 2, 21));
			    policyEntity.setEmail("john.doe@example.com");
			    policyEntity.setVehicleNo(7609123L); // Corrected the casting issue
			    policyEntity.setStatus(true);

				return policyEntity;
			}
	    	
	    	
	    });
	    when(policyMapper.generatePolicyId(any())).thenReturn("test");
	    
	    //when(policyMapper.toModel(policyEntity)).thenReturn(policyModel);// Corrected the argument
	    when(policyMapper.toModel(any())).thenAnswer(new Answer<PolicyDTO>() {

			@Override
			public PolicyDTO answer(InvocationOnMock invocation) throws Throwable {
				PolicyDTO policyModel = new PolicyDTO();
			    policyModel.setPolicyId("SM12345");
			    policyModel.setInsuredFirstName("John");
			    policyModel.setInsuredLastName("Doe");
			    policyModel.setDateOfInsurance(LocalDate.of(2024, 2, 21));
			    policyModel.setEmail("john.doe@example.com");
			    policyModel.setVehicleNo(7609123L); // Corrected the casting issue
			    policyModel.setStatus(true);
			    
				return policyModel;
			}
	    	
	    });
	    
	    // Call the service method
	    PolicyDTO policyModel = new PolicyDTO();
	    policyModel.setPolicyId("SM12345");
	    policyModel.setInsuredFirstName("John");
	    policyModel.setInsuredLastName("Doe");
	    policyModel.setDateOfInsurance(LocalDate.of(2024, 2, 21));
	    policyModel.setEmail("john.doe@example.com");
	    policyModel.setVehicleNo(7609123L); // Corrected the casting issue
	    policyModel.setStatus(true);
	    
	
	    PolicyDTO SavedPolicy = policyServiceImpl.addNewPolicy(policyModel);
	    	
	    // Assertions
	    assertEquals(policyModel.getPolicyId(), SavedPolicy.getPolicyId());
	    assertEquals(policyModel.getInsuredLastName(), SavedPolicy.getInsuredLastName());
	    assertEquals(policyModel.getDateOfInsurance(), SavedPolicy.getDateOfInsurance());
	    assertEquals(policyModel.getEmail(), SavedPolicy.getEmail());
	    assertEquals(policyModel.getVehicleNo(), SavedPolicy.getVehicleNo());
	    assertEquals(policyModel.isStatus(), SavedPolicy.isStatus());
	    assertEquals(policyModel.getInsuredFirstName(), SavedPolicy.getInsuredFirstName());
	}

 
	
	
	
	 @Test
	    void testGetAllPolicy_ReturnsEmptyList() {
	        
		 List<PolicyDTO> list=policyServiceImpl.getAllPolicy();
		 	// Assert
	        assertTrue(list.isEmpty());
	    }

	  
	  
	 
	 
	 @Test
		void testGetAllClaimDetail_positive() {
			 // Create a sample claim
			List<Policy> PolicyDetailsList=new ArrayList<>();
			Policy policyEntity=new Policy();
		    policyEntity.setPolicyId("SM12345");
		    policyEntity.setInsuredFirstName("John");
		    policyEntity.setInsuredLastName("Doe");
		    policyEntity.setDateOfInsurance(LocalDate.of(2024, 2, 21));
		    policyEntity.setEmail("john.doe@example.com");
		    policyEntity.setVehicleNo(7609123L); // Corrected the casting issue
		    policyEntity.setStatus(true);
		    PolicyDetailsList.add(policyEntity);
			
			 // Create a sample claimDetails DTO
			List<PolicyDTO> policyListDto=new ArrayList<>();
			PolicyDTO policyModel = new PolicyDTO();
		    policyModel.setPolicyId("SM12345");
		    policyModel.setInsuredFirstName("John");
		    policyModel.setInsuredLastName("Doe");
		    policyModel.setDateOfInsurance(LocalDate.of(2024, 2, 21));
		    policyModel.setEmail("john.doe@example.com");
		    policyModel.setVehicleNo(7609123L); // Corrected the casting issue
		    policyModel.setStatus(true);
		    policyListDto.add(policyModel);
			when(policyMapper.toModels(PolicyDetailsList)).thenReturn(policyListDto);		
			when(policyRepo.findAll()).thenReturn(PolicyDetailsList);
			List<PolicyDTO> list=policyServiceImpl.getAllPolicy();
			assertTrue(list.size()>0);
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
