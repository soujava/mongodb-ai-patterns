package org.soujava.samples.ai.patterns.planning;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface OrderRepository extends BasicRepository<Order, String> {
}
