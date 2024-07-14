package org.example;

/**
 * 6510450917 Lerdphipat Kanjanarungroj
 */

public class User {
    private NameValidationStrategy nameValidationStrategy;
    private static final Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final List<String> notAllowDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
    private static final int MINIMUM_AGE = 20;

    public User(NameValidationStrategy nameValidationStrategy) {
        this.nameValidationStrategy = nameValidationStrategy;
    }

    public boolean validate(User user) {
        nameValidationStrategy.validate(user.getName());
        validateEmail(user.getEmail());
        validateAge(user.getAge());
        return true;
    }
}