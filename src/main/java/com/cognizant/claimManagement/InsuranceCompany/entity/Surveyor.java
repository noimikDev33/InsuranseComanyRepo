package com.cognizant.claimManagement.InsuranceCompany.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="surveyor")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Surveyor {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	@Column(name = "surveyor_Id")
	private Long surveyorId;
	
	
	
	@Column(name = "first_Name")
	private String firstName;
	
	@Column(name = "last_Name")
	private String lastName;
	
	@Column(name = "estimate_Limit")
	private Long estimateLimit;

	
}
