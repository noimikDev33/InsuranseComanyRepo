package com.cognizant.claimManagement.InsuranceCompany.exceptions;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	String fieldValue;
	LocalDate date;
	public ResourceNotFoundException(String resourceName, String fieldName, String claimID) {
		super(String.format("%s Data not found in the %s : %s",resourceName,fieldName,claimID));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = claimID;
	}
	
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, LocalDate date) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,date));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.date = date;
	}
	
}
