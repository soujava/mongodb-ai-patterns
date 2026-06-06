package org.soujava.samples.ai.patterns.planning;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public record Order(@Id UUID id, @Column String email, @Column String product) {
}
