package validator;

import java.util.regex.Pattern;

public class PhoneValidator {
    public static boolean isValid(int id, String lastName, String firstName, String patronymic, String address, String creditCardNumber, double debit, double credit, double localCallTime, double longDistanceCallTime) {
        if (id <= 0) {
            System.out.println("Invalid ID: " + id);
            return false;
        }
        if (!isValidName(lastName)) {
            System.out.println("Invalid Last Name: " + lastName);
            return false;
        }
        // Add similar checks for firstName, patronymic, address, etc.

        if (!isValidCreditCard(creditCardNumber)) {
            System.out.println("Invalid Credit Card Number: " + creditCardNumber);
            return false;
        }

        if (debit < 0 || credit < 0 || localCallTime < 0 || longDistanceCallTime < 0) {
            System.out.println("Negative values found: Debit: " + debit + ", Credit: " + credit + ", Local Call Time: " + localCallTime + ", Long Distance Call Time: " + longDistanceCallTime);
            return false;
        }

        return true;
    }

    private static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-zА-Яа-яЁё]+");
    }

    private static boolean isValidCreditCard(String creditCardNumber) {
        return creditCardNumber != null && creditCardNumber.matches("\\d{16}");
    }
}