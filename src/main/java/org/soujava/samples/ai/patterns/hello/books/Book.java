package org.soujava.samples.ai.patterns.hello.books;

import java.util.List;

public record Book(
        String title,
        String author,
        String description,
        List<String> keywords
) {
}