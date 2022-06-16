package com.dhl.test.billing.feign.model;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhl.test.billing.model.Tracking;

@FeignClient(name = "TRACKING-SERVICE")
public interface ConsumeTracking {
	
	@GetMapping("/tracking/generateTrackingId")
	public Tracking getTrackingId(@RequestParam UUID shipmentId);

}
