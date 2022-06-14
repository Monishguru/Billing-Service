package com.dhl.test.billing.service;

import com.dhl.test.billing.model.CustomerShipment;

public interface ShipmentService  {

	public CustomerShipment getShipmentsOfCustomer(Long customerId);

}
