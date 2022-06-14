package com.dhl.test.billing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	RestTemplate restTemplate;

	@Override
	public CustomerShipment getShipmentsOfCustomer(Long customerId) {

		CustomerShipment customerShipment = new CustomerShipment();

		log.info("Getting shipments associated with customer");
		customerShipment.setShipment(shipmentrepo.findByCustomerId(customerId));
		log.info("Communicating with Customer service to get customer detaile");
		Customer customerInfo = restTemplate.getForObject("http://localhost:9001/customer/getById?id=" + customerId,
				Customer.class);
		customerShipment.setCustomer(customerInfo);
		return customerShipment;
	}

}
