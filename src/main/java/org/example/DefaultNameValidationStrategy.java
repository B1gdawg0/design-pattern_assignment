package org.example;

/**
 * 6510450917 Lerdphipat Kanjanarungroj
 */

public class DefaultNameValidationStrategy implements NameValidationStrategy {
    public void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name is in the wrong format");
        }
    }
}
