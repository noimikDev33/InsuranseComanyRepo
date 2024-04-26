package com.cognizant.claimManagement.InsuranceCompany.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="policy")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Policy {


	@Id
	
	@Column(name = "policy_Id")
	private String policyId;
	
	
	@Column(name = "insured_First_Name")
	private String insuredFirstName;
	
	@Column(name = "insured_Last_Name")
	private String insuredLastName;
	
	@Column(name = "date_Of_Insurance")
	private LocalDate dateOfInsurance;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "vehicle_No")
	private Long vehicleNo;
	
	
	@Column(name = "status")
	private boolean status;

	

}








