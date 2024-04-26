package com.cognizant.claimManagement.InsuranceCompany.testing.entity;

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

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.DTO.PolicyDTO;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.ClaimDetailsServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.PolicyServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.entity.Policy;
import com.cognizant.claimManagement.InsuranceCompany.repo.ClaimDetailsRepo;
import com.cognizant.claimManagement.InsuranceCompany.repo.PolicyRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.ClaimDetailsMapper;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.PolicyMapper;

class TestClaimDetails {


	@Mock
	private ClaimDetailsRepo claimDetailsRepo;
	@Mock
	ClaimDetailsMapper mapper;
	
	@Mock 
	ClaimDetails claimDetails;
	
	
	@Mock
	ClaimDetailsDTO claimDetailsDto;
	
	
	
	@InjectMocks
	private ClaimDetailsServiceImpl claimDetailServiceImpl;
	
	
	
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	

	
 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
