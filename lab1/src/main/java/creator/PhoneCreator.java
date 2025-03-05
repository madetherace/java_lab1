package creator;

import entity.Phone;
import validator.PhoneValidator;

public class PhoneCreator {

    public Phone createPhone(int id, String lastName, String firstName, String patronymic, String address, String creditCardNumber, double debit, double credit, double localCallTime, double longDistanceCallTime) {
        // Debugging output
        System.out.println("Creating phone with the following data:");
        System.out.printf("ID: %d, Last Name: %s, First Name: %s, Patronymic: %s, Address: %s, Credit Card: %s, Debit: %.2f, Credit: %.2f, Local Call Time: %.2f, Long Distance Call Time: %.2f%n",
                id, lastName, firstName, patronymic, address, creditCardNumber, debit, credit, localCallTime, longDistanceCallTime);

        if (PhoneValidator.isValid(id, lastName, firstName, patronymic, address, creditCardNumber, debit, credit, localCallTime, longDistanceCallTime)) {
            return new Phone(id, lastName, firstName, patronymic, address, creditCardNumber, debit, credit, localCallTime, longDistanceCallTime);
        } else {
            throw new IllegalArgumentException("Invalid phone data");
        }
    }
}