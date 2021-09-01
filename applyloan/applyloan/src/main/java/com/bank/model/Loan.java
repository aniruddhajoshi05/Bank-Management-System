package com.bank.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	
	@Id
	@ApiModelProperty(notes = "Loan id")
	private long loanId;
	@ApiModelProperty(notes = "Loan type")
	@NotBlank(message = "Type should not be empty")
	private String loanType;
	@ApiModelProperty(notes = "Loan amount")
	@NotBlank(message = "Amount should not be empty")
	private double loanAmount;
	@ApiModelProperty(notes = "Date of applying loan")
	@NotBlank(message = "Date should not be empty")
	private String date;
	@ApiModelProperty(notes = "Rate of interest per year")
	@NotBlank(message = "ROI should not be empty")
	private double rateOfInterest;
	@ApiModelProperty(notes = "Duration of loan in months")
	@NotBlank(message = "Duration should not be empty")
	private double durationOfLoan;
	@ApiModelProperty(notes = "The User ID of the user")
	@NotBlank(message = "User id should not be empty")
	private long userId;
	
}
