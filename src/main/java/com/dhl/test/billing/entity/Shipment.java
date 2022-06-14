package com.dhl.test.billing.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.dhl.test.billing.util.BillingConstants;

import lombok.Data;

@Entity
@Data
public class Shipment implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID ShipmentId;
	
	private Long customerId;
	
	private String shipmentSource;
	
	private String shipmentDestination;
	
	private Long distance;
	
	private Long shipmentWeight;
	
	private String shipmentPriority;
	
	private Long billValue;
	
	private String billStatus = BillingConstants.UNPAID;
	
	private String trackingId;

}
