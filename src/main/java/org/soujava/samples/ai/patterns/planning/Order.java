package org.soujava.samples.ai.patterns.planning;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public record Order(@Id String id, @Column String email, @Column String product) {
}
