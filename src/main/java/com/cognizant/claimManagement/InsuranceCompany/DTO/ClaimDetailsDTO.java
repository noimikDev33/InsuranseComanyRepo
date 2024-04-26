
package com.cognizant.claimManagement.InsuranceCompany.DTO;



import java.time.LocalDate;


import org.springframework.stereotype.Component;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





/**
 * @Author Noimik
 * Business service for ClaimDetailsMappper
 */

@Component


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class ClaimDetailsDTO {
	
	@Id
	
	private String claimId;
	
	@NotEmpty(message="Policy No can't be null or blank, please put value")
	private String policyNo;
	
	@NotNull(message="estimatedLoss can't be null or blank, please put value")
	private long estimatedLoss;
	
	@NotNull(message="dateOfAccident can't be null or blank, please put value")
	private LocalDate dateOfAccident;
	

//	 @Pattern(regexp = "^(closed|open)$", message = "claimStatus must be 'closed' or 'open'")
//	    private String claimStatus;
	@NotNull(message="claimStatus can't be null or blank, please put value")
	private boolean claimStatus;
//	private long SurveyorId;
	
	@Min(value=1,message="amtApprovedBySurveyor can't be null or zero, please put value")
	private long amtApprovedBySurveyor;
	
	@NotNull(message="insuranceCompanyApproval can't be null or blank, please put value")
	private boolean insuranceCompanyApproval;
	
	@NotNull(message="withdrawClaim can't be null or blank, please put value")
	private boolean withdrawClaim;
	
	@NotNull(message="surveyorFees can't be null or blank, please put value")
	private long surveyorFees;

}

