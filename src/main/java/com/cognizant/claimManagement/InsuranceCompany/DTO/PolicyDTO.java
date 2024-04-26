package com.cognizant.claimManagement.InsuranceCompany.DTO;



import java.time.LocalDate;

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

public class PolicyDTO {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String policyId;
	private String insuredFirstName;
	private String insuredLastName;
	private LocalDate dateOfInsurance;
	private String email;
	private Long vehicleNo;
	private boolean status;



}






