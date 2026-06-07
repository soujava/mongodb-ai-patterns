package org.soujava.samples.ai.patterns.planning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SetupService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Inject
    public SetupService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }
}
