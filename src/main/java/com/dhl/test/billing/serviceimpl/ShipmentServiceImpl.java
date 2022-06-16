package com.dhl.test.billing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhl.test.billing.feign.model.ConsumeCustomer;
import com.dhl.test.billing.model.Customer;
import com.dhl.test.billing.model.CustomerShipment;
import com.dhl.test.billing.repository.ShipmentRepository;
import com.dhl.test.billing.service.ShipmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentRepository shipmentrepo;

	@Autowired
	ConsumeCustomer customerFeign;

	@Override
	public CustomerShipment getShipmentsOfCustomer(Long customerId) {

		CustomerShipment customerShipment = new CustomerShipment();

		log.info("Getting shipments associated with customer");
		customerShipment.setShipment(shipmentrepo.findByCustomerId(customerId));
		log.info("Communicating with Customer service to get customer detaile");
		Customer customerInfo = customerFeign.getCustomerById(customerId);
		customerShipment.setCustomer(customerInfo);
		return customerShipment;
	}

}
