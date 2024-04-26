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



/**
 * @author Noimik
 * Restful Web service - Rest Controller
 */
@Entity
@Table(name="ClaimDetails")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ClaimDetails {
	
	
	@Id
	
	@Column(name = "claim_Id")
	private String claimId;
	
	@Column(name = "policy_No")
	private String policyNo;
	
	@Column(name = "estimated_Loss")
	private long estimatedLoss;
	
	
	@Column(name = "date_Of_Accident")
	private LocalDate dateOfAccident;
	
	@Column(name = "claim_Status")
	private boolean claimStatus;
	
	@Column(name = "Amt_Approved_By_Surveyor")
	private long amtApprovedBySurveyor;
	
	@Column(name = "insurance_Company_Approval")
	private boolean insuranceCompanyApproval;
	
	@Column(name = "withdraw_Claim")
	private boolean withdrawClaim;
	
	@Column(name = "surveyor_Fees")
	private long surveyorFees;

}






















