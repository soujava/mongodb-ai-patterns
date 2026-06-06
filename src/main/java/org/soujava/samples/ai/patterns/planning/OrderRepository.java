package org.soujava.samples.ai.patterns.planning;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends BasicRepository<Order, String> {

    @Query("FROM Order WHERE customerId = :customerId AND status = 'PLACED'")
    Optional<Order> findByCustomerId(UUID customerId);
}
