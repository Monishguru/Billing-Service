package com.dhl.test.billing.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhl.test.billing.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

	List<Shipment> findByCustomerId(Long customerId);

}
