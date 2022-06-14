package com.dhl.test.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.test.billing.model.CustomerShipment;
import com.dhl.test.billing.serviceimpl.ShipmentServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/shipment")
public class ShipmentController {
	
	@Autowired
	ShipmentServiceImpl shipmentServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getShipmentsForCustomer")
	@Operation (summary ="This service is used to Pay Bill for DHL")
	public CustomerShipment generateBill(@RequestParam(value = "customerId") Long customerId) {
		log.info("Getting Shipments of Customer");
		return shipmentServiceImpl.getShipmentsOfCustomer(customerId);
	}

}
