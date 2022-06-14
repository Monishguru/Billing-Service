package com.dhl.test.billing.service;

import java.util.UUID;

import com.dhl.test.billing.entity.Shipment;

public interface BillingService {

	public Shipment generateBilling(Shipment shipment);

	public Shipment payBill(UUID shipmentId);

}
