package com.dhl.test.billing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private long phoneNumber;

	private String address;

}
