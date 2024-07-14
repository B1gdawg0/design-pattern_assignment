package org.example;

public class UserValidator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final List<String> notAllowDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
    private static final int MINIMUM_AGE = 20;

    public boolean validate(User user) {
        validateName(user.getName());
        validateEmail(user.getEmail());
        validateAge(user.getAge());
        return true;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name is in the wrong format");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email should not be empty");
        }
        if (!validEmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is in the wrong format");
        }
        String domain = email.split("@")[1];
        if (notAllowDomains.contains(domain)) {
            throw new IllegalArgumentException("Domain Email is not allowed");
        }
    }

    private void validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age should be more than 20 years");
        }
    }
}

