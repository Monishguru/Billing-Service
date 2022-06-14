package com.dhl.test.billing.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Tracking {

	
	private String trackingId;
	
	private UUID shipmentId;
}
