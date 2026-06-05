package org.soujava.samples.ai.patterns.hello.books;

public record Recommendation(
        Book book,
        String reason
) {
}