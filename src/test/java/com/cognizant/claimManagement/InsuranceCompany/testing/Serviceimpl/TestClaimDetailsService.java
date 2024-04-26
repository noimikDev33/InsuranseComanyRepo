package com.cognizant.claimManagement.InsuranceCompany.testing.Serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.ClaimDetailsServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.exceptions.ResourceNotFoundException;
import com.cognizant.claimManagement.InsuranceCompany.repo.ClaimDetailsRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.ClaimDetailsMapper;

class TestClaimDetailsService {


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

	@Test
	void testGetAllClaimDetail_positive() {
		 // Create a sample claim
		List<ClaimDetails> claimDetail=new ArrayList<>();
		ClaimDetails claimDetails=new ClaimDetails();
		claimDetails.setClaimId("CL00001234");
		claimDetails.setPolicyNo("P123");
		claimDetails.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
		claimDetails.setClaimStatus(true);
		claimDetails.setEstimatedLoss((long) 10000.0);
		claimDetails.setAmtApprovedBySurveyor((long) 8000.0);
		claimDetails.setInsuranceCompanyApproval(true);
		claimDetails.setWithdrawClaim(false);
		claimDetails.setSurveyorFees((long) 500.0);
	
		claimDetail.add(claimDetails);
		
		 // Create a sample claimDetails DTO
		List<ClaimDetailsDTO> claimDetailDTOList=new ArrayList<>();
		ClaimDetailsDTO claimDetailsdto=new ClaimDetailsDTO();
		claimDetailsdto.setClaimId("CL00001234");
		claimDetailsdto.setPolicyNo("P123");
		claimDetailsdto.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
		claimDetailsdto.setClaimStatus(true);
		claimDetailsdto.setEstimatedLoss((long) 10000.0);
		claimDetailsdto.setAmtApprovedBySurveyor((long) 8000.0);
		claimDetailsdto.setInsuranceCompanyApproval(true);
		claimDetailsdto.setWithdrawClaim(false);
		claimDetailsdto.setSurveyorFees((long) 500.0);
		claimDetailDTOList.add(claimDetailsdto);
		when(claimDetailsRepo.findAll()).thenReturn(claimDetail);
		when(mapper.toModels(claimDetail)).thenReturn(claimDetailDTOList);		
		
		List<ClaimDetailsDTO> list=claimDetailServiceImpl.getAllClaimDetail();
		assertTrue(list.size()>0);
	}
	@Test
	void testGetAllClaimDetail_negative() {
	    List<ClaimDetails> emptyClaimDetail = new ArrayList<>();
	    when(claimDetailsRepo.findAll()).thenReturn(emptyClaimDetail);
	    List<ClaimDetailsDTO> list = claimDetailServiceImpl.getAllClaimDetail();
	    assertTrue(list.isEmpty());
	}
	
	
	
	 @Test
	    void testAddNewClaim() {
	        // Create a sample claim
			ClaimDetails claimDetails=new ClaimDetails();
			claimDetails.setClaimId("CL00001234");
			claimDetails.setPolicyNo("P123");
			claimDetails.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
			claimDetails.setClaimStatus(true);
			claimDetails.setEstimatedLoss((long) 10000.0);
			claimDetails.setAmtApprovedBySurveyor((long) 8000.0);
			claimDetails.setInsuranceCompanyApproval(true);
			claimDetails.setWithdrawClaim(false);
			claimDetails.setSurveyorFees((long) 500.0);
			
			when(claimDetailsRepo.save(any())).thenAnswer(new Answer<ClaimDetails>() {

				@Override
				public ClaimDetails answer(InvocationOnMock invocation) throws Throwable {
					// TODO Auto-generated method stubClaimDetails claimDetails=new ClaimDetails();
					claimDetails.setClaimId("CL00001234");
					claimDetails.setPolicyNo("P123");
					claimDetails.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
					claimDetails.setClaimStatus(true);
					claimDetails.setEstimatedLoss((long) 10000.0);
					claimDetails.setAmtApprovedBySurveyor((long) 8000.0);
					claimDetails.setInsuranceCompanyApproval(true);
					claimDetails.setWithdrawClaim(false);
					claimDetails.setSurveyorFees((long) 500.0);
					return claimDetails;
				}
				
			});
			
			//Model
		

	        // Mock the behavior of your DAO
			when(claimDetailsRepo.save(claimDetails)).thenReturn(claimDetails);
	        when(mapper.toModel(any())).thenAnswer(new Answer<ClaimDetailsDTO>() {

				@Override
				public ClaimDetailsDTO answer(InvocationOnMock invocation) throws Throwable {
					ClaimDetailsDTO claimDetailsdto=new ClaimDetailsDTO();
					claimDetailsdto.setClaimId("CL00001234");
					claimDetailsdto.setPolicyNo("P123");
					claimDetailsdto.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
					claimDetailsdto.setClaimStatus(true);
					claimDetailsdto.setEstimatedLoss((long) 10000.0);
					claimDetailsdto.setAmtApprovedBySurveyor((long) 8000.0);
					claimDetailsdto.setInsuranceCompanyApproval(true);
					claimDetailsdto.setWithdrawClaim(false);
					claimDetailsdto.setSurveyorFees((long) 500.0);
					
					return claimDetailsDto;
				
				}
	        	
	        });
	        
	        ClaimDetailsDTO claimDetailsdto=new ClaimDetailsDTO();
			claimDetailsdto.setClaimId("CL00001234");
			claimDetailsdto.setPolicyNo("P123");
			claimDetailsdto.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
			claimDetailsdto.setClaimStatus(true);
			claimDetailsdto.setEstimatedLoss((long) 10000.0);
			claimDetailsdto.setAmtApprovedBySurveyor((long) 8000.0);
			claimDetailsdto.setInsuranceCompanyApproval(true);
			claimDetailsdto.setWithdrawClaim(false);
			claimDetailsdto.setSurveyorFees((long) 500.0);
			
	        
	        	
	        // Call the service method
	        ClaimDetailsDTO savedClaimDetailDto = claimDetailServiceImpl.addNewClaim(claimDetailsdto);
	        
	        verify(claimDetailsRepo).save(any(ClaimDetails.class));
	        
	        
	        assertEquals(savedClaimDetailDto.getClaimId(), claimDetailsDto.getClaimId());
	        assertEquals(savedClaimDetailDto.getAmtApprovedBySurveyor(), claimDetailsDto.getAmtApprovedBySurveyor());
	        assertEquals(savedClaimDetailDto.getSurveyorFees(), claimDetailsDto.getSurveyorFees());
	        assertEquals(savedClaimDetailDto.getPolicyNo(), claimDetailsDto.getPolicyNo());
	        assertEquals(savedClaimDetailDto.getEstimatedLoss(), claimDetailsDto.getEstimatedLoss());
	        assertEquals(savedClaimDetailDto.getDateOfAccident(), claimDetailsDto.getDateOfAccident());
	        assertEquals(savedClaimDetailDto.isClaimStatus(), claimDetailsDto.isClaimStatus());
	        assertEquals(savedClaimDetailDto.isInsuranceCompanyApproval(), claimDetailsDto.isInsuranceCompanyApproval());
	        assertEquals(savedClaimDetailDto.isWithdrawClaim(), claimDetailsDto.isWithdrawClaim());
    }
	 
	 
	 @Test
	 void testAddNewClaimAddedFailed() {
	     // Arrange
	     ClaimDetailsDTO claimDetailsModel = new ClaimDetailsDTO();
	     claimDetailsModel.setClaimId("CL00001234");
	     claimDetailsModel.setPolicyNo("P456");
	     claimDetailsModel.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 25));
	     claimDetailsModel.setClaimStatus(true);
	     claimDetailsModel.setEstimatedLoss(12000L);
	     claimDetailsModel.setAmtApprovedBySurveyor(9000L);
	     claimDetailsModel.setInsuranceCompanyApproval(true);
	     claimDetailsModel.setWithdrawClaim(false);
	     claimDetailsModel.setSurveyorFees(600L);

	     // Mock the behavior of your DAO to simulate failure
	     when(claimDetailsRepo.save(any(ClaimDetails.class))).thenReturn(null);

	     // Act
	     claimDetailsDto = claimDetailServiceImpl.addNewClaim(claimDetailsModel);

	     // Assert
	     assertNull(claimDetailsDto); // Adding the claim failed
	     verify(claimDetailsRepo).save(any(ClaimDetails.class));
	 }

	 
 

 @Test
    void testUpdateClaimWhenClaimExists() {
	        // Arrange
	        String claimID = "CL00001234";
	        ClaimDetailsDTO claimDetailsModel = new ClaimDetailsDTO();
	        claimDetailsModel.setClaimId(claimID);
	        claimDetailsModel.setPolicyNo("P123");
	        claimDetailsModel.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
	        claimDetailsModel.setClaimStatus(true);
	        claimDetailsModel.setEstimatedLoss(10000); 
	        claimDetailsModel.setAmtApprovedBySurveyor(88888);
	        claimDetailsModel.setInsuranceCompanyApproval(true);
	        claimDetailsModel.setWithdrawClaim(false);
	        claimDetailsModel.setSurveyorFees(500);

	        ClaimDetails claimDetails = new ClaimDetails();
	        claimDetails.setClaimId(claimID);
	        claimDetails.setPolicyNo("P123");
	        claimDetails.setDateOfAccident(LocalDate.of(2024, Month.FEBRUARY, 21));
	        claimDetails.setClaimStatus(true);
	        claimDetails.setEstimatedLoss(10000);
	        claimDetails.setAmtApprovedBySurveyor(8000);
	        claimDetails.setInsuranceCompanyApproval(true);
	        claimDetails.setWithdrawClaim(false);
	        claimDetails.setSurveyorFees(500);

	        when(claimDetailsRepo.findById(claimID)).thenReturn(Optional.of(claimDetails));
	       
	        
	        when(claimDetailsRepo.save(claimDetails)).thenReturn(claimDetails);
	        
	        when(mapper.toModel(claimDetails)).thenReturn(claimDetailsModel);
	        
	        
	     // Act
	        ClaimDetailsDTO updatedModel = claimDetailServiceImpl.UpdateClaim(claimDetailsModel, claimID);
	        
	        verify(claimDetailsRepo).findById(claimID);
	        verify(claimDetailsRepo).save(any(ClaimDetails.class));
	        
	        assertNotNull(updatedModel);
	        assertEquals(claimID, updatedModel.getClaimId());
	        assertEquals(claimDetailsModel.getPolicyNo(), updatedModel.getPolicyNo());
	        assertEquals(claimDetailsModel.getDateOfAccident(), updatedModel.getDateOfAccident());
	        assertEquals(claimDetailsModel.isClaimStatus(), updatedModel.isClaimStatus());
	        assertEquals(claimDetailsModel.getEstimatedLoss(), updatedModel.getEstimatedLoss());
	        assertEquals(claimDetailsModel.getAmtApprovedBySurveyor(), updatedModel.getAmtApprovedBySurveyor());
	        assertEquals(claimDetailsModel.isInsuranceCompanyApproval(), updatedModel.isInsuranceCompanyApproval());
	        assertEquals(claimDetailsModel.isWithdrawClaim(), updatedModel.isWithdrawClaim());
	        assertEquals(claimDetailsModel.getSurveyorFees(), updatedModel.getSurveyorFees());
	    }
 
 
 @Test
 void testUpdateClaimWhenClaimNotExists() {
     // Arrange
	 try {
     String nonExistentClaimID = "CL00001234"; // Assuming this claim ID does not exist
     ClaimDetailsDTO claimDetailsModel = new ClaimDetailsDTO();
     claimDetailsModel.setClaimId(nonExistentClaimID);
     claimDetailsModel.setPolicyNo("P456");
  
     when(claimDetailsRepo.findById(nonExistentClaimID)).thenThrow(ResourceNotFoundException.class);

     // Act
     ClaimDetailsDTO updatedModel = claimDetailServiceImpl.UpdateClaim(claimDetailsModel, nonExistentClaimID);
     when(updatedModel).thenReturn(updatedModel);
     
	 }catch(Exception e) {
		 assertTrue(e instanceof ResourceNotFoundException);
	 }
    
 }

 
 
 
 
 
 @Test
  void testGetClaimDetailsByMonthAndYear() {
     // Arrange // declaring the date because of justification later so that the confusion no created later 
     long month = 2L; // February
     long year = 2024L;
     LocalDate date1 = LocalDate.of(2024, Month.FEBRUARY, 10);
     LocalDate date2 = LocalDate.of(2024, Month.FEBRUARY, 15);
     LocalDate date3 = LocalDate.of(2024, Month.MARCH, 5);

     ClaimDetails claim1 = new ClaimDetails();
     claim1.setClaimId("CL00001234");
     claim1.setPolicyNo("P123");
     claim1.setDateOfAccident(date1);
     claim1.setClaimStatus(true);
     claim1.setEstimatedLoss(10000L);
     claim1.setAmtApprovedBySurveyor(8000L);
     claim1.setInsuranceCompanyApproval(true);
     claim1.setWithdrawClaim(false);
     claim1.setSurveyorFees(500L);
     
     ClaimDetails claim2 = new ClaimDetails();
     claim2.setClaimId("CL00001235");
     claim2.setPolicyNo("P123");
     claim2.setClaimStatus(true);
     claim2.setEstimatedLoss((long) 10000.0);
     claim2.setAmtApprovedBySurveyor((long) 8000.0);
     claim2.setInsuranceCompanyApproval(true);
     claim2.setWithdrawClaim(false);
     claim2.setSurveyorFees((long) 500.0);
     claim2.setDateOfAccident(date2);

     ClaimDetails claim3 = new ClaimDetails();
     claim3.setClaimId("CL000012");
     claim3.setPolicyNo("P123");
     claim3.setClaimStatus(true);
     claim3.setEstimatedLoss((long) 10000.0);
     claim3.setAmtApprovedBySurveyor((long) 8000.0);
     claim3.setInsuranceCompanyApproval(true);
     claim3.setWithdrawClaim(false);
     claim3.setSurveyorFees((long) 500.0);
     claim3.setDateOfAccident(date3);

     List<ClaimDetails> allClaims = Arrays.asList(claim1, claim2, claim3);

     when(claimDetailsRepo.saveAll(allClaims)).thenReturn(allClaims);
//     System.out.println(allClaims);

     // Act
    
     when(claimDetailsRepo.findAll()).thenReturn(allClaims);
    
//     List<ClaimDetailsDTO> claimDetailsModels=new ArrayList<>();
     ClaimDetailsDTO claimDetailsDTO1=new ClaimDetailsDTO();
     claimDetailsDTO1.setClaimId("CL000012");
     claimDetailsDTO1.setPolicyNo("P123");
     claimDetailsDTO1.setClaimStatus(true);
     claimDetailsDTO1.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO1.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO1.setInsuranceCompanyApproval(true);
     claimDetailsDTO1.setWithdrawClaim(false);
     claimDetailsDTO1.setSurveyorFees((long) 500.0);
     claimDetailsDTO1.setDateOfAccident(date2);
     ClaimDetailsDTO claimDetailsDTO2=new ClaimDetailsDTO();
     claimDetailsDTO2.setClaimId("CL000012");
     claimDetailsDTO2.setPolicyNo("P123");
     claimDetailsDTO2.setClaimStatus(true);
     claimDetailsDTO2.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO2.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO2.setInsuranceCompanyApproval(true);
     claimDetailsDTO2.setWithdrawClaim(false);
     claimDetailsDTO2.setSurveyorFees((long) 500.0);
     claimDetailsDTO2.setDateOfAccident(date1);
     ClaimDetailsDTO claimDetailsDTO3=new ClaimDetailsDTO();
     claimDetailsDTO3.setClaimId("CL000012");
     claimDetailsDTO3.setPolicyNo("P123");
     claimDetailsDTO3.setClaimStatus(true);
     claimDetailsDTO3.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO3.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO3.setInsuranceCompanyApproval(true);
     claimDetailsDTO3.setWithdrawClaim(false);
     claimDetailsDTO3.setSurveyorFees((long) 500.0);
     claimDetailsDTO3.setDateOfAccident(date3);
     List<ClaimDetailsDTO> claimDetailsModels=Arrays.asList(claimDetailsDTO1, claimDetailsDTO2, claimDetailsDTO3);
     when(mapper.toModels(allClaims)).thenReturn(claimDetailsModels);
     List<ClaimDetailsDTO> filteredClaims = claimDetailServiceImpl.getClaimDetailsByMonthAndYear(month, year);


     // Assert
     assertTrue(filteredClaims.stream().allMatch(c -> c.getDateOfAccident().getMonthValue() == month && c.getDateOfAccident().getYear() == year));
     assertEquals(2, filteredClaims.size());

     verify(claimDetailsRepo).findAll();
     verifyNoMoreInteractions(claimDetailsRepo);
 }
 
 
 
 
 
 @Test
  void testGetClaimDetailsByMonthAndYear_Negative() {
     // Arrange
     long month = 2L; // February
     long year = 2024L;

     // Create an empty list of claims
     List<ClaimDetails> emptyClaims = Collections.emptyList();

     // Mock the repository behavior
     when(claimDetailsRepo.findAll()).thenReturn(emptyClaims);

     // Act
     List<ClaimDetailsDTO> claimDetailsModels = claimDetailServiceImpl.getClaimDetailsByMonthAndYear(month, year);

     // Assert
     assertTrue(claimDetailsModels.isEmpty());
 }
 
 
 


 
 @Test
 void testGetAllPaymentStatusss() {
	 long month = 2L; // February
     long year = 2024L;
     LocalDate date1 = LocalDate.of(2024, Month.FEBRUARY, 10);
     LocalDate date2 = LocalDate.of(2024, Month.FEBRUARY, 15);
     LocalDate date3 = LocalDate.of(2024, Month.MARCH, 5);

     ClaimDetails claim1 = new ClaimDetails();
     claim1.setClaimId("CL00001234");
     claim1.setPolicyNo("P123");
     claim1.setDateOfAccident(date1);
     claim1.setClaimStatus(true);
     claim1.setEstimatedLoss(10000L);
     claim1.setAmtApprovedBySurveyor(8000L);
     claim1.setInsuranceCompanyApproval(true);
     claim1.setWithdrawClaim(false);
     claim1.setSurveyorFees(500L);
     
     ClaimDetails claim2 = new ClaimDetails();
     claim2.setClaimId("CL00001235");
     claim2.setPolicyNo("P123");
     claim2.setClaimStatus(true);
     claim2.setEstimatedLoss((long) 10000.0);
     claim2.setAmtApprovedBySurveyor((long) 8000.0);
     claim2.setInsuranceCompanyApproval(true);
     claim2.setWithdrawClaim(false);
     claim2.setSurveyorFees((long) 500.0);
     claim2.setDateOfAccident(date2);

     ClaimDetails claim3 = new ClaimDetails();
     claim3.setClaimId("CL000012");
     claim3.setPolicyNo("P123");
     claim3.setClaimStatus(true);
     claim3.setEstimatedLoss((long) 10000.0);
     claim3.setAmtApprovedBySurveyor((long) 8000.0);
     claim3.setInsuranceCompanyApproval(true);
     claim3.setWithdrawClaim(false);
     claim3.setSurveyorFees((long) 500.0);
     claim3.setDateOfAccident(date3);

     List<ClaimDetails> allClaims = Arrays.asList(claim1, claim2, claim3);

     when(claimDetailsRepo.saveAll(allClaims)).thenReturn(allClaims);
//     System.out.println(allClaims);

     // Act
    
     when(claimDetailsRepo.findAll()).thenReturn(allClaims);
    
//     List<ClaimDetailsDTO> claimDetailsModels=new ArrayList<>();
     ClaimDetailsDTO claimDetailsDTO1=new ClaimDetailsDTO();
     claimDetailsDTO1.setClaimId("CL000012");
     claimDetailsDTO1.setPolicyNo("P123");
     claimDetailsDTO1.setClaimStatus(true);
     claimDetailsDTO1.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO1.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO1.setInsuranceCompanyApproval(true);
     claimDetailsDTO1.setWithdrawClaim(false);
     claimDetailsDTO1.setSurveyorFees((long) 500.0);
     claimDetailsDTO1.setDateOfAccident(date2);
     ClaimDetailsDTO claimDetailsDTO2=new ClaimDetailsDTO();
     claimDetailsDTO2.setClaimId("CL000012");
     claimDetailsDTO2.setPolicyNo("P123");
     claimDetailsDTO2.setClaimStatus(true);
     claimDetailsDTO2.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO2.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO2.setInsuranceCompanyApproval(true);
     claimDetailsDTO2.setWithdrawClaim(false);
     claimDetailsDTO2.setSurveyorFees((long) 500.0);
     claimDetailsDTO2.setDateOfAccident(date1);
     ClaimDetailsDTO claimDetailsDTO3=new ClaimDetailsDTO();
     claimDetailsDTO3.setClaimId("CL000012");
     claimDetailsDTO3.setPolicyNo("P123");
     claimDetailsDTO3.setClaimStatus(true);
     claimDetailsDTO3.setEstimatedLoss((long) 10000.0);
     claimDetailsDTO3.setAmtApprovedBySurveyor((long) 8000.0);
     claimDetailsDTO3.setInsuranceCompanyApproval(true);
     claimDetailsDTO3.setWithdrawClaim(true);
     claimDetailsDTO3.setSurveyorFees((long) 500.0);
     claimDetailsDTO3.setDateOfAccident(date3);
     List<ClaimDetailsDTO> claimDetailsModels=Arrays.asList(claimDetailsDTO1, claimDetailsDTO2, claimDetailsDTO3);
     when(mapper.toModels(allClaims)).thenReturn(claimDetailsModels);
     // Call your method
     Map<String, Long> claimCounts = claimDetailServiceImpl.getAllpaymentStatus(month, year);

     // Assert the expected results
     assertEquals(0L, claimCounts.get("Approved Claims"));
     assertEquals(0L, claimCounts.get("New Claims"));
     assertEquals(0L, claimCounts.get("Pending"));
 }
 
 
 
 @Test
 void testGetAllPaymentStatus_NoMatchingClaims() {
     long month = 2L; // February
     long year = 2024L;

     // Create an empty list for claimDetailsModels
     List<ClaimDetails> emptyClaimDetails = new ArrayList<>();
     List<ClaimDetailsDTO> emptyClaimModel=new ArrayList<>();

     // Mock the behavior of claimDetailsRepo.findAll()
     when(claimDetailsRepo.findAll()).thenReturn(emptyClaimDetails);
     when(mapper.toModels(emptyClaimDetails)).thenReturn(emptyClaimModel);

     // Call your method
     Map<String, Long> claimCounts = claimDetailServiceImpl.getAllpaymentStatus(month, year);

     // Assert that all counts are zero
     assertEquals(0L, claimCounts.get("Approved Claims"));
     assertEquals(0L, claimCounts.get("New Claims"));
     assertEquals(0L, claimCounts.get("Pending"));
 }

 
 
 
 
 
 
 
 
 
 
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
