package org.soujava.samples.ai.patterns.planning;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class AgentMain {
    public static void main(String[] args) {
        // Spin up the CDI container in a standard Java SE application
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            // Fetch the Orchestrator Factory
            ResolutionAgentFactory factory = container.select(ResolutionAgentFactory.class).get();
            var setupService = container.select(SetupService.class).get();
            setupService.initializeData("alice@test.com");
            CustomerResolutionAgent agent = factory.createAgent();

            System.out.println("User: Hi, my email is alice@test.com. Please cancel my current order.");

            // The ReAct loop happens automatically inside this method call!
            String response = agent.resolveIssue("Hi, my email is alice@test.com. Please cancel my current order.");

            System.out.println("Agent: " + response);
        }
    }
}