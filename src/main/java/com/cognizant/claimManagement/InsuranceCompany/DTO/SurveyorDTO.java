

package com.cognizant.claimManagement.InsuranceCompany.DTO;


import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class SurveyorDTO {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long surveyorId;
	private String firstName;
	private String lastName;
	private long estimateLimit;




}





