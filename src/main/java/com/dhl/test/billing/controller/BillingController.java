package com.dhl.test.billing.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.test.billing.entity.Shipment;
import com.dhl.test.billing.serviceimpl.BillingServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value ="/billing")
@Slf4j
public class BillingController {
	
	@Autowired
	BillingServiceImpl billingServiceImpl;
	
	@RequestMapping(method = RequestMethod.POST, value = "/generateBill")
	@Operation (summary ="This service is used to Generate Bill for DHL")
	public Shipment generateBill(@RequestBody Shipment shipment) {
		log.info("Generating Bill");
		return billingServiceImpl.generateBilling(shipment);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/payBill")
	@Operation (summary ="This service is used to Pay Bill for DHL")
	public Shipment generateBill(@RequestParam(value = "shipmentId") UUID shipmentId) {
		log.info("Paying Bill for Shipment");
		return billingServiceImpl.payBill(shipmentId);
	}

}
