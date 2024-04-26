package com.cognizant.claimManagement.InsuranceCompany.testing.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.claimManagement.InsuranceCompany.DTO.ClaimDetailsDTO;
import com.cognizant.claimManagement.InsuranceCompany.Service.ClaimDetailsService;
import com.cognizant.claimManagement.InsuranceCompany.controller.ClaimDetailsController;
import com.cognizant.claimManagement.InsuranceCompany.entity.ClaimDetails;
import com.cognizant.claimManagement.InsuranceCompany.exceptions.ResourceNotFoundException;
import com.cognizant.claimManagement.InsuranceCompany.repo.ClaimDetailsRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Import other necessary classes and packages

class TestClaimDetailsController {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ClaimDetailsRepo claimDetailsRepo;


	@Mock
	private ClaimDetails claimDetails;

	@Mock
	private ClaimDetailsDTO claimDetailsDto;

	@Mock
	private ClaimDetailsService claimDetailsService;

	@InjectMocks
	private ClaimDetailsController claimDetailsController;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Any cleanup or teardown logic if needed
	}
	
	
	
	

  
	
	
	
	
	
	
	

	@Test
	 void addClaimDetails_positive_ResponseBody() {
		// Create a sample ClaimDetailsDTO
		ClaimDetailsDTO claimDetails = new ClaimDetailsDTO();
		claimDetails.setClaimId("CL00001234");
		// Set other properties as needed

		// Mock the service method to return a non-null value
		when(claimDetailsService.addNewClaim(any())).thenReturn(claimDetails);

		// Call the controller method
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.addNewClaim(claimDetails);

		// Verify that the service method was called
		verify(claimDetailsService).addNewClaim(any());

		// Assert the response status and body
		assertEquals(claimDetails, response.getBody());
	}

	@Test
	 void testAddNewClaim_ValidClaim_Success_StatusCode() {
		// Arrange
		ClaimDetailsDTO validClaim = new ClaimDetailsDTO(); // Create a valid claim object
		when(claimDetailsService.addNewClaim(validClaim)).thenReturn(validClaim);

		// Act
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.addNewClaim(validClaim);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	 void testAddNewClaim_EmptyRequest_Failure_ResponseBody() {
		// Act
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.addNewClaim(null);

		// Assert
		assertEquals(null, response.getBody());
	}

	@Test
	 void testAddNewClaim_InvalidData_Failure_StatusCode() {
		// Arrange
		ClaimDetailsDTO invalidClaim = new ClaimDetailsDTO(); // Create an invalid claim object

		// Act
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.addNewClaim(invalidClaim);

		// Assert
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	 void getAllClaimDetails_nonEmptyList_StatusCode() {
		// Create a sample non-empty claim list
		List<ClaimDetailsDTO> claimList = new ArrayList<>();
		claimList.add(new ClaimDetailsDTO());
		// Add more claim details as needed
		// Mock the service method to return the non-empty list
		when(claimDetailsService.getAllClaimDetail()).thenReturn(claimList);

		ResponseEntity<List<ClaimDetailsDTO>> response = claimDetailsController.getAllClaimDetails();

		verify(claimDetailsService).getAllClaimDetail();

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	 void getAllClaimDetails_nonEmptyList_Response() {
		List<ClaimDetailsDTO> claimList = new ArrayList<>();
		claimList.add(new ClaimDetailsDTO());
		when(claimDetailsService.getAllClaimDetail()).thenReturn(claimList);

		ResponseEntity<List<ClaimDetailsDTO>> response = claimDetailsController.getAllClaimDetails();

		verify(claimDetailsService).getAllClaimDetail();

		assertEquals(claimList, response.getBody());
	}

	@Test
	 void getAllClaimDetails_emptyList() {
		when(claimDetailsService.getAllClaimDetail()).thenReturn(Collections.emptyList());

		assertThrows(ResourceNotFoundException.class, () -> claimDetailsController.getAllClaimDetails());
		verify(claimDetailsService).getAllClaimDetail();

	}

	@Test
	 void updateClaimData_validUpdate_StatusCode() {
		// Create a sample claim details model
		ClaimDetailsDTO claimDetails = new ClaimDetailsDTO();
		claimDetails.setClaimId("CL00001234");
		// Set other properties as needed

		// Mock the service method to return the claim details
		when(claimDetailsService.UpdateClaim(eq(claimDetails), anyString())).thenReturn(claimDetails);

		// Call the controller method
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.updateClaimData(claimDetails, "CL00001234");

		// Verify that the service method was called
		verify(claimDetailsService).UpdateClaim(eq(claimDetails), eq("CL00001234"));

		// Assert the response status and body
		assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(claimDetails, response.getBody());
	}

	@Test
	 void updateClaimData_validUpdate_Response() {
		// Create a sample claim details model
		ClaimDetailsDTO claimDetails = new ClaimDetailsDTO();
		claimDetails.setClaimId("CL00001234");
		// Set other properties as needed

		// Mock the service method to return the claim details
		when(claimDetailsService.UpdateClaim(eq(claimDetails), anyString())).thenReturn(claimDetails);

		// Call the controller method
		ResponseEntity<ClaimDetailsDTO> response = claimDetailsController.updateClaimData(claimDetails, "CL00001234");

		// Verify that the service method was called
		verify(claimDetailsService).UpdateClaim(eq(claimDetails), eq("CL00001234"));

		// Assert the response status and body
		assertEquals(claimDetails, response.getBody());
	}

	@Test
	 void updateClaimData_exceptionThrown() {
		// Mock the service method to throw an exception
		when(claimDetailsService.UpdateClaim(any(), anyString())).thenThrow(RuntimeException.class);

		// Call the controller method and expect an exception
		assertThrows(RuntimeException.class,
				() -> claimDetailsController.updateClaimData(new ClaimDetailsDTO(), "CL00001234"));

		// Verify that the service method was called
		verify(claimDetailsService).UpdateClaim(any(), eq("CL00001234"));
	}

	@Test
	 void viewReportByDate_nonEmptyList() {
		// Create a sample non-empty claim list
		List<ClaimDetailsDTO> claimList = new ArrayList<>();
		claimList.add(new ClaimDetailsDTO());
		// Add more claim details as needed

		// Mock the service method to return the non-empty list
		when(claimDetailsService.getClaimDetailsByMonthAndYear(anyLong(), anyLong())).thenReturn(claimList);

		// Call the controller method
		ResponseEntity<?> response = claimDetailsController.ViewReportByDate(3L, 2024L);

		// Verify that the service method was called
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(3L, 2024L);

		// Assert the response status and body
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(claimList, response.getBody());
	}

	@Test
	 void viewReportByDate_emptyList() {
		// Mock the service method to return an empty list
		when(claimDetailsService.getClaimDetailsByMonthAndYear(anyLong(), anyLong()))
				.thenReturn(Collections.emptyList());

		// Call the controller method
		ResponseEntity<?> response = claimDetailsController.ViewReportByDate(3L, 2024L);

		// Verify that the service method was called
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(3L, 2024L);

		// Assert the response status
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

	@Test
	void testViewReportByDate_PositiveCase_StatusCode() {
		// Arrange
		Long month = 3L; // Example month
		Long year = 2024L; // Example year

		List<ClaimDetailsDTO> mockClaimList = Collections.singletonList(new ClaimDetailsDTO());
		when(claimDetailsService.getClaimDetailsByMonthAndYear(month, year)).thenReturn(mockClaimList);

		// Act
		ResponseEntity<List<ClaimDetailsDTO>> response = (ResponseEntity<List<ClaimDetailsDTO>>) claimDetailsController
				.ViewReportByDate(month, year);

		// Assert
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(month, year);

		assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals(mockClaimList, response.getBody());

	}

	@Test
	void testViewReportByDate_PositiveCase_ResponseBody() {
		// Arrange
		Long month = 3L; // Example month
		Long year = 2024L; // Example year

		List<ClaimDetailsDTO> mockClaimList = Collections.singletonList(new ClaimDetailsDTO());
		when(claimDetailsService.getClaimDetailsByMonthAndYear(month, year)).thenReturn(mockClaimList);

		// Act
		ResponseEntity<List<ClaimDetailsDTO>> response = (ResponseEntity<List<ClaimDetailsDTO>>) claimDetailsController
				.ViewReportByDate(month, year);

		// Assert
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(month, year);

//            assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockClaimList, response.getBody());

	}

	@Test
	void testViewReportByDate_NegativeCase_StatusCode() {
		// Arrange

		Long month = 3L; // Example month
		Long year = 2024L; // Example year

		List<ClaimDetailsDTO> emptyClaimList = Collections.emptyList();
		when(claimDetailsService.getClaimDetailsByMonthAndYear(month, year)).thenReturn(emptyClaimList);

		// Act
		ResponseEntity<List<ClaimDetailsDTO>> response = (ResponseEntity<List<ClaimDetailsDTO>>) claimDetailsController
				.ViewReportByDate(month, year);

		// Assert
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(month, year);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertNull(response.getBody()); // Ensure response body is null for empty claim list
	}

	@Test

	void testViewReportByDate_NegativeCase_ResponseBody() {
		// Arrange

		Long month = 3L; // Example month
		Long year = 2024L; // Example year

		List<ClaimDetailsDTO> emptyClaimList = Collections.emptyList();
		when(claimDetailsService.getClaimDetailsByMonthAndYear(month, year)).thenReturn(emptyClaimList);

		// Act
		ResponseEntity<List<ClaimDetailsDTO>> response = (ResponseEntity<List<ClaimDetailsDTO>>) claimDetailsController.ViewReportByDate(month, year);

		// Assert
		verify(claimDetailsService).getClaimDetailsByMonthAndYear(month, year);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		assertNull(response.getBody()); // Ensure response body is null for empty claim list
	}

	@Test
	void testApprovedClaimAmtClaimId_ClaimProfileFound_StatusCode() {

		String claimId = "123"; // Example claim ID
		long claimAmt = 1000L; // Example claim amount

		ClaimDetails mockClaimProfile = new ClaimDetails(); // Create a mock claim profile
		Optional<ClaimDetails> optionalClaimProfile = Optional.of(mockClaimProfile);
		when(claimDetailsRepo.findById(claimId)).thenReturn(Optional.of(mockClaimProfile));

		// Act
		ResponseEntity<?> response = claimDetailsController.approvedClaimAmtClaimId(claimId, claimAmt);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(optionalClaimProfile, response.getBody());
	}

	@Test
	void testApprovedClaimAmtClaimId_ClaimProfileFound_Response() {

		String claimId = "123"; // Example claim ID
		long claimAmt = 1000L; // Example claim amount

		ClaimDetails mockClaimProfile = new ClaimDetails(); // Create a mock claim profile
		Optional<ClaimDetails> optionalClaimProfile = Optional.of(mockClaimProfile);
		when(claimDetailsRepo.findById(claimId)).thenReturn(Optional.of(mockClaimProfile));

		// Act
		ResponseEntity<?> response = claimDetailsController.approvedClaimAmtClaimId(claimId, claimAmt);

		// Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(optionalClaimProfile, response.getBody());
	}

	@Test
	void testApprovedClaimAmtClaimId_ClaimProfileNotFound_ResponseStatus() {

		String claimId = "456"; // Example claim ID (not found)

		when(claimDetailsRepo.findById(claimId)).thenReturn(Optional.empty());

		// Act
		ResponseEntity<?> response = claimDetailsController.approvedClaimAmtClaimId(claimId, 0L); // Claim amount
																									// doesn't matter

		// Assert
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		assertNull(response.getBody());
	}

	@Test
	void testApprovedClaimAmtClaimId_ClaimProfileNotFound_StatusCode() {

		String claimId = "456"; // Example claim ID (not found)

		when(claimDetailsRepo.findById(claimId)).thenReturn(Optional.empty());

		// Act
		ResponseEntity<?> response = claimDetailsController.approvedClaimAmtClaimId(claimId, 0L); // Claim amount
																									// doesn't matter

		// Assert
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertNull(response.getBody());
	}

	@Test
	void testViewPaymentStatusOfClaim_EmptyResult_StatusCode() {
		// Mock the service behavior
		when(claimDetailsService.getAllpaymentStatus(3L, 2024L)).thenReturn(Collections.emptyMap());

		// Call the method under test
		ResponseEntity<?> responseEntity = claimDetailsController.ViewPayMentStatusOfClaim(3L, 2024L);

		// Verify the response
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody());

		// Verify that the service method was called once
		verify(claimDetailsService, times(1)).getAllpaymentStatus(3L, 2024L);
	}

	@Test
	void testViewPaymentStatusOfClaim_EmptyResult_Response() {
		// Mock the service behavior
		when(claimDetailsService.getAllpaymentStatus(3L, 2024L)).thenReturn(Collections.emptyMap());

		// Call the method under test
		ResponseEntity<?> responseEntity = claimDetailsController.ViewPayMentStatusOfClaim(3L, 2024L);

		// Verify the response
//        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());

		// Verify that the service method was called once
		verify(claimDetailsService, times(1)).getAllpaymentStatus(3L, 2024L);
	}

	@Test
	void testViewPaymentStatusOfClaim_NonEmptyResult_StatusCode() {
		// Create sample payment status data
		Map<String, Long> paymentStatus = new HashMap<>();
		paymentStatus.put("approved", 2L);
		paymentStatus.put("new", 1L);
		paymentStatus.put("pending", 3L);

		// Mock the service behavior
		when(claimDetailsService.getAllpaymentStatus(3L, 2024L)).thenReturn(paymentStatus);

		// Call the method under test
		ResponseEntity<?> responseEntity = claimDetailsController.ViewPayMentStatusOfClaim(3L, 2024L);

		// Verify the response
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(paymentStatus, responseEntity.getBody());

		// Verify that the service method was called once
		verify(claimDetailsService, times(1)).getAllpaymentStatus(3L, 2024L);
	}

	@Test
	void testViewPaymentStatusOfClaim_NonEmptyResult_ResponseBody() {
		// Create sample payment status data
		Map<String, Long> paymentStatus = new HashMap<>();
		paymentStatus.put("approved", 2L);
		paymentStatus.put("new", 1L);
		paymentStatus.put("pending", 3L);

		// Mock the service behavior
		when(claimDetailsService.getAllpaymentStatus(3L, 2024L)).thenReturn(paymentStatus);

		// Call the method under test
		ResponseEntity<?> responseEntity = claimDetailsController.ViewPayMentStatusOfClaim(3L, 2024L);

		// Verify the response
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(paymentStatus, responseEntity.getBody());

		// Verify that the service method was called once
		verify(claimDetailsService, times(1)).getAllpaymentStatus(3L, 2024L);
	}

}

