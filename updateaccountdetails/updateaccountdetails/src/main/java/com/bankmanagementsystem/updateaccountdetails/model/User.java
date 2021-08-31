package com.bankmanagementsystem.updateaccountdetails.model;

import javax.validation.constraints.Email;
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
public class User {

	@Id
	@ApiModelProperty(notes = "The User ID of the user")
	private Long id;
	@ApiModelProperty(notes = "The Username of the user")
	@NotBlank(message = "Username should not be empty")
	private String username;
	@ApiModelProperty(notes = "The Password of the user")
	@NotBlank(message = "Password should not be empty")
	private String password;
	@ApiModelProperty(notes = "The Name of the user")
	@NotBlank(message = "Name should not be empty")
	private String name;
	@ApiModelProperty(notes = "The Address of the user")
	@NotBlank(message = "Address should not be empty")
	private String address;
	@ApiModelProperty(notes = "The State of the user")
	@NotBlank(message = "State should not be empty")
	private String state;
	@ApiModelProperty(notes = "The Country of the user")
	@NotBlank(message = "Country should not be empty")
	private String country;
	@ApiModelProperty(notes = "The Email Address of the user")
	@NotBlank(message = "EmailAddress should not be empty")
	@Email(message = "Invalid email address")
	private String emailAddress;
	@ApiModelProperty(notes = "The PAN of the user")
	@NotBlank(message = "PAN should not be empty")
	private String pan;
	@ApiModelProperty(notes = "The Contact Number of the user")
	@NotBlank(message = "Contact Number should not be empty")
	private String contactNumber;
	@ApiModelProperty(notes = "The Date of Birth of the user")
	@NotBlank(message = "DOB should not be empty")
	private String dob;
	@ApiModelProperty(notes = "The Account type of the user")
	@NotBlank(message = "AccountType should not be empty")
	private String accountType;

}
