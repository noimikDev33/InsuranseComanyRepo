
package com.cognizant.claimManagement.InsuranceCompany.testing.Serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.cognizant.claimManagement.InsuranceCompany.DTO.SurveyorDTO;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.SurveyorServiceImpl;
import com.cognizant.claimManagement.InsuranceCompany.entity.Surveyor;
import com.cognizant.claimManagement.InsuranceCompany.repo.SurveyorRepo;
import com.cognizant.claimManagement.InsuranceCompany.Serviceimpl.Mapper.SurveyorMapper;




@ExtendWith(MockitoExtension.class)
class TestSurveyorService {


	@Mock
	private SurveyorRepo surveyorRepo;
	@Mock
	SurveyorMapper surveyorMapper;
	
	@Mock 
	Surveyor surveyors;
	
	
	@Mock
	SurveyorDTO surveyorDto;
	
	
	
	@InjectMocks
	private SurveyorServiceImpl surveyorServiceImpl;
	
	

	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	 void TestAddNewSurveyor() {
		Surveyor SurveyorEntity =new Surveyor();
		SurveyorEntity.setSurveyorId((long)123);
		SurveyorEntity.setFirstName("Noimik");
		SurveyorEntity.setLastName("Noimik");
		SurveyorEntity.setEstimateLimit((long)3000);
		when(surveyorRepo.save(any())).thenAnswer(new Answer<Surveyor>() {

			@Override
			public Surveyor answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Surveyor SurveyorEntity =new Surveyor();
				SurveyorEntity.setSurveyorId((long)123);
				SurveyorEntity.setFirstName("Noimik");
				SurveyorEntity.setLastName("Noimik");
				SurveyorEntity.setEstimateLimit((long)3000);
				
				return SurveyorEntity;
			}	
		});
		when(surveyorMapper.toModel(any())).thenAnswer(new Answer<SurveyorDTO>() {

			@Override
			public SurveyorDTO answer(InvocationOnMock invocation) throws Throwable {
				SurveyorDTO SurveyorDto=new SurveyorDTO();
				SurveyorDto.setSurveyorId((long)123);
				SurveyorDto.setFirstName("Noimik");
				SurveyorDto.setLastName("Noimik");
				SurveyorDto.setEstimateLimit((long)3000);
				
				return SurveyorDto;
			}
			
		});
		
		SurveyorDTO SurveyorDto=new SurveyorDTO();
		SurveyorDto.setSurveyorId((long)123);
		SurveyorDto.setFirstName("Noimik");
		SurveyorDto.setLastName("Noimik");
		SurveyorDto.setEstimateLimit((long)3000);
		
		SurveyorDTO savedSurveyor=surveyorServiceImpl.addNewSurveyor(SurveyorDto);
		
		 // Assertions
	    assertEquals(SurveyorDto.getSurveyorId(), savedSurveyor.getSurveyorId());
	    assertEquals(SurveyorDto.getFirstName(), savedSurveyor.getFirstName());
	    assertEquals(SurveyorDto.getLastName(),savedSurveyor.getLastName());
	    assertEquals(SurveyorDto.getEstimateLimit(),savedSurveyor.getEstimateLimit());	
	}
	
	@Test
	 void TestAddNewSurveyor_Failure() {
	    // Arrange
	    SurveyorDTO surveyorDto = new SurveyorDTO();
	    surveyorDto.setSurveyorId((long) 123);

	    // Mock the repository to return null (indicating failure)
	    when(surveyorRepo.save(any())).thenReturn(null);

	    // Act
	    SurveyorDTO savedSurveyor = surveyorServiceImpl.addNewSurveyor(surveyorDto);

	    // Assert
	    assertNull(savedSurveyor); // Expecting a null result due to failure
	}

	
	@Test
    void testGetSurveyorById_Success() {
        // Arrange
        long surveyorId = 123L;
        Surveyor surveyorEntity = new Surveyor();
        surveyorEntity.setSurveyorId(surveyorId);

        SurveyorDTO expectedSurveyorDto = new SurveyorDTO();
        expectedSurveyorDto.setSurveyorId(surveyorId);

        when(surveyorRepo.findById(surveyorId)).thenReturn(Optional.of(surveyorEntity));
        when(surveyorMapper.toModel(surveyorEntity)).thenReturn(expectedSurveyorDto);

        // Act
        Optional<SurveyorDTO> actualSurveyorDto = surveyorServiceImpl.getSurveyorById(surveyorId);

        // Assert
        assertTrue(actualSurveyorDto.isPresent());
        assertEquals(expectedSurveyorDto.getSurveyorId(), actualSurveyorDto.get().getSurveyorId());
    }

    @Test
    void testGetSurveyorById_NotFound() {
        // Arrange
        long nonExistentSurveyorId = 999L;

        when(surveyorRepo.findById(nonExistentSurveyorId)).thenReturn(Optional.empty());

        // Act
        Optional<SurveyorDTO> actualSurveyorDto = surveyorServiceImpl.getSurveyorById(nonExistentSurveyorId);

        // Assert
        assertFalse(actualSurveyorDto.isPresent());
    }
 
 
    
    
    
    @Test
    void testGetSurveyorByEstimatedLoss_Success() {
        // Arrange
        long estimatedLoss = 5000L;

        // Create sample surveyors
        Surveyor surveyor1 = new Surveyor();
        surveyor1.setSurveyorId(1L);
        surveyor1.setEstimateLimit(3000L);

        Surveyor surveyor2 = new Surveyor();
        surveyor2.setSurveyorId(2L);
        surveyor2.setEstimateLimit(5000L);

        Surveyor surveyor3 = new Surveyor();
        surveyor3.setSurveyorId(3L);
        surveyor3.setEstimateLimit(8000L);

        List<Surveyor> allSurveyorsEntity = new ArrayList<>();
        allSurveyorsEntity.add(surveyor1);
        allSurveyorsEntity.add(surveyor2);
        allSurveyorsEntity.add(surveyor3);

        when(surveyorRepo.findAll()).thenReturn(allSurveyorsEntity);

   

        // Act
        List<SurveyorDTO> actualSurveyors = surveyorServiceImpl.getSurveyorbyEstimatedLoss(estimatedLoss);

        // Assert
       
        assertTrue(actualSurveyors.stream().allMatch(s -> s.getEstimateLimit() == estimatedLoss));
    }
    
    
    @Test
    void testGetSurveyorByEstimatedLoss_NoMatchingSurveyors() {
        // Arrange
        long estimatedLoss = 5000L;

        // Create sample surveyors
        Surveyor surveyor1 = new Surveyor();
        surveyor1.setSurveyorId(1L);
        surveyor1.setEstimateLimit(3000L);

        Surveyor surveyor2 = new Surveyor();
        surveyor2.setSurveyorId(2L);
        surveyor2.setEstimateLimit(8000L);

        List<Surveyor> allSurveyorsEntity = new ArrayList<>();
        allSurveyorsEntity.add(surveyor1);
        allSurveyorsEntity.add(surveyor2);

        when(surveyorRepo.findAll()).thenReturn(allSurveyorsEntity);

        // Act
        List<SurveyorDTO> actualSurveyors = surveyorServiceImpl.getSurveyorbyEstimatedLoss(estimatedLoss);

        // Assert
        assertTrue(actualSurveyors.isEmpty()); // Expecting an empty list
    }
    
    @Test
    void testGetAllSurveyors_Success() {
        // Arrange
        Surveyor surveyor1 = new Surveyor();
        surveyor1.setSurveyorId(1L);

        Surveyor surveyor2 = new Surveyor();
        surveyor2.setSurveyorId(2L);

        List<Surveyor> allSurveyorsEntity = new ArrayList<>();
        allSurveyorsEntity.add(surveyor1);
        allSurveyorsEntity.add(surveyor2);

        SurveyorDTO surveyorDto1 = new SurveyorDTO();
        surveyorDto1.setSurveyorId(1L);

        SurveyorDTO surveyorDto2 = new SurveyorDTO();
        surveyorDto2.setSurveyorId(2L);

        List<SurveyorDTO> expectedSurveyors = new ArrayList<>();
        expectedSurveyors.add(surveyorDto1);
        expectedSurveyors.add(surveyorDto2);

        when(surveyorRepo.findAll()).thenReturn(allSurveyorsEntity);
        when(surveyorMapper.toModels(allSurveyorsEntity)).thenReturn(expectedSurveyors);

        // Act
        List<SurveyorDTO> actualSurveyors = surveyorServiceImpl.getAllSurveyors();

        // Assert
        assertEquals(expectedSurveyors.size(), actualSurveyors.size());
        assertTrue(actualSurveyors.containsAll(expectedSurveyors));
    }
    
    
    
    @Test
    void testGetAllSurveyors_NoSurveyorsFound() {
        // Arrange
        when(surveyorRepo.findAll()).thenReturn(Collections.emptyList());
        // Act
        List<SurveyorDTO> actualSurveyors = surveyorServiceImpl.getAllSurveyors();
        // Assert
        assertTrue(actualSurveyors.isEmpty());// Expecting an empty list
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
 
	    }
	 