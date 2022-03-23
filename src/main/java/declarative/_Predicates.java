package main.java.declarative;

import java.util.function.Predicate;

public class _Predicates {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("985489"));
        System.out.println(isPhoneNumberValid("07123456789"));

        System.out.println(isPhoneNumberValidByPredicate.test("985489"));
        System.out.println(isPhoneNumberValidByPredicate.test("07123456789"));
;    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidByPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;
}
