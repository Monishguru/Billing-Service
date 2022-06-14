package com.dhl.test.billing.model;

import java.util.List;

import com.dhl.test.billing.entity.Shipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerShipment {
	
	private Customer customer;
	
	private List<Shipment> shipment;

}
