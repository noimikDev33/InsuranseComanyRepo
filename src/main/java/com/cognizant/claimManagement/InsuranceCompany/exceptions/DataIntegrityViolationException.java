package com.cognizant.claimManagement.InsuranceCompany.exceptions;



import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataIntegrityViolationException extends RuntimeException{
	String resourceName;
	String fieldName;
	String fieldValue;
	LocalDate date;
	public DataIntegrityViolationException(String resourceName, String fieldName, String claimID) {
		super(String.format("%s the Data Exists the Id %s : %s",resourceName,fieldName,claimID));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = claimID;
	}
	
	
	
}

