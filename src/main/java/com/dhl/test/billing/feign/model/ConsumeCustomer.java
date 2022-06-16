package com.dhl.test.billing.feign.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhl.test.billing.model.Customer;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface ConsumeCustomer {

	@GetMapping("customer/getById")
	public Customer getCustomerById(@RequestParam Long id);

}
