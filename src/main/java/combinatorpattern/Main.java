package main.java.combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(
                "Alice",
                "alice@mail.com",
                "+0123",
                LocalDate.of(2000, 1, 1)
        );

        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValid(customer1));

        // Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult()).apply(customer1);

        System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.success) {
            throw new IllegalStateException(result.name());
        }
    }
}
