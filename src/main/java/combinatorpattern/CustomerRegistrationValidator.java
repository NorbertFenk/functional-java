package main.java.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.success : ValidationResult.emailNotValid;
    }

    static CustomerRegistrationValidator isPhoneNumberValid () {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                ValidationResult.success : ValidationResult.phoneNumberNotValid;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer ->
                Period.between(
                        customer.getDateOfBirth(), LocalDate.now()
                ).getYears() > 16 ?
                ValidationResult.success :  ValidationResult.isNotAnAdult;
    }

    // NOTE: if the current validation was successful
    // it will apply the next validator function and check that too.
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.success) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        success,
        phoneNumberNotValid,
        emailNotValid,
        isNotAnAdult
    }
}
