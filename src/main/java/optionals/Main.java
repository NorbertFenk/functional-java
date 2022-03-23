package main.java.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(value);

        Object value2 = Optional.ofNullable("hello")
                .orElseGet(() -> "default value2");

        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to: " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to: " + email),
                        () -> System.out.println("error from the runnable")
                );
    }
}
