package com.dhl.test.billing.serviceimpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dhl.test.billing.entity.Shipment;
import com.dhl.test.billing.model.Tracking;
import com.dhl.test.billing.repository.ShipmentRepository;
import com.dhl.test.billing.service.BillingService;
import com.dhl.test.billing.util.BillingConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {

	@Autowired
	ShipmentRepository shipmentRepo;

	@Autowired
	RestTemplate resttemplate;

	@Override
	public Shipment generateBilling(Shipment shipment) {
		log.info("Bill value is being calculated");
		if (shipment.getShipmentPriority().equalsIgnoreCase(BillingConstants.HIGH_PRIORITY)) {
			shipment.setBillValue(shipment.getDistance() * shipment.getShipmentWeight() * 2);
		}

		else {
			shipment.setBillValue(shipment.getDistance() * shipment.getShipmentWeight());
		}
		if (shipment.getBillStatus() == null) {
			shipment.setBillStatus(BillingConstants.UNPAID);
		}
		return shipmentRepo.save(shipment);
	}

	@Override
	public Shipment payBill(UUID shipmentId) {
		Optional<Shipment> shipmentInfo = shipmentRepo.findById(shipmentId);
		if (shipmentInfo.get() != null
				&& shipmentInfo.get().getBillStatus().equalsIgnoreCase(BillingConstants.UNPAID)) {

			log.info("Payment Done");
			shipmentInfo.get().setBillStatus("Paid");

			Tracking trackingInfo = resttemplate.getForObject("http://localhost:9003/tracking/generateTrackingId?shipmentId="+shipmentId,
					Tracking.class);

			shipmentInfo.get().setTrackingId(trackingInfo.getTrackingId());
			return shipmentRepo.save(shipmentInfo.get());
		}
		else {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
