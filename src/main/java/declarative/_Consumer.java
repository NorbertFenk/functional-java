package main.java.declarative;

import javax.swing.text.StyledEditorKit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        greetCustomer(new Customer("Joana", "1234"));
        greetCustomerByFunction.accept(new Customer("Ada", "4321"));
        greetCustomerAndPrintPhoneNumberByBiFunction.accept(new Customer("Ada", "4321"), false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerAndPrintPhoneNumberByBiFunction = (customer, showPhoneNumber)
            -> System.out.println("Hello "
            + customer.name
            + ", thanks for registering phone number: "
            + (showPhoneNumber ? customer.phoneNumber : "****"));

    static Consumer<Customer> greetCustomerByFunction = customer -> System.out.println("Hello "
            + customer.name
            + ", thanks for registering phone number: "
            + customer.phoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello "
                + customer.name
                + ", thanks for registering phone number: "
                + customer.phoneNumber);
    }

    static class Customer {
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
