package main;

import creator.PhoneCreator;
import entity.Phone;
import service.PhoneService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneCreator creator = new PhoneCreator();
        Phone[] phones = new Phone[3];

        phones[0] = creator.createPhone(1, "Иванов", "Иван", "Иванович", "ул. Ленина, 1", "1234567890123456", 100, 50, 20, 5);
        phones[1] = creator.createPhone(2, "Петров", "Петр", "Петрович", "ул. Пушкина, 2", "9876543210987654", 50, 20, 10, 0);
        phones[2] = creator.createPhone(3, "Сидоров", "Сидор", "Сидорович", "ул. Гоголя, 3", "1111222233334444", 75, 30, 15, 2);

        PhoneService service = new PhoneService();

        System.out.println("Абоненты с временем городских разговоров более 12 минут:");
        List<Phone> filteredByLocalCalls = service.filterByLocalCallTime(phones, 12);
        filteredByLocalCalls.forEach(System.out::println);

        System.out.println("\nАбоненты, пользовавшиеся междугородной связью:");
        List<Phone> filteredByLongDistance = service.filterByLongDistanceCalls(phones);
        filteredByLongDistance.forEach(System.out::println);

        System.out.println("\nАбоненты в алфавитном порядке:");
        service.sortByLastName(phones);
        Arrays.stream(phones).forEach(System.out::println);



    }
}
