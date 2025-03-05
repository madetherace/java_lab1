package service;

import entity.Phone;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PhoneServiceTest {
    private PhoneService phoneService;
    private Phone[] testPhones;

    @BeforeMethod
    public void setUp() {
        phoneService = new PhoneService();
        testPhones = new Phone[] {
                new Phone(1, "Doe", "John", "Smith", "123 Main St", "1234-5678-9012-3456", 100.00, 200.00, 30, 15),
                new Phone(2, "Adams", "Jane", "Doe", "456 Elm St", "5678-1234-9012-3456", 50.00, 150.00, 10, 0),
                new Phone(3, "Brown", "Charlie", "Lee", "789 Oak St", "9012-3456-7890-1234", 200.00, 250.00, 40, 25)
        };
    }

    @Test
    public void testFilterByLocalCallTime() {
        Phone[] testPhones = {
                new Phone(1, "Doe", "John", "Smith", "123 Main St", "1234-5678-9012-3456", 100.00, 200.00, 30.0, 15.0),
                new Phone(2, "Adams", "Jane", "Doe", "456 Elm St", "5678-1234-9012-3456", 50.00, 150.00, 10.0, 0.0),
                new Phone(3, "Brown", "Charlie", "Lee", "789 Oak St", "9012-3456-7890-1234", 200.00, 250.00, 40.0, 25.0)
        };

        List<Phone> filteredPhones = phoneService.filterByLocalCallTime(testPhones, 20);

        System.out.println("Filtered by Local Call Time > 20:");
        for (Phone phone : filteredPhones) {
            System.out.println(phone);
        }
        Assert.assertEquals(filteredPhones.size(), 2);
        Assert.assertTrue(filteredPhones.stream().allMatch(phone -> phone.getLocalCallTime() > 20));
    }

    @Test
    public void testFilterByLongDistanceCalls() {
        Phone[] testPhones = {
                new Phone(1, "Doe", "John", "Smith", "123 Main St", "1234-5678-9012-3456", 100.00, 200.00, 30.0, 15.0),
                new Phone(2, "Adams", "Jane", "Doe", "456 Elm St", "5678-1234-9012-3456", 50.00, 150.00, 10.0, 0.0),
                new Phone(3, "Brown", "Charlie", "Lee", "789 Oak St", "9012-3456-7890-1234", 200.00, 250.00, 40.0, 25.0)
        };

        List<Phone> filteredPhones = phoneService.filterByLongDistanceCalls(testPhones);

        System.out.println("Filtered by Long Distance Calls:");
        for (Phone phone : filteredPhones) {
            System.out.println(phone);
        }
        Assert.assertEquals(filteredPhones.size(), 2);
        Assert.assertTrue(filteredPhones.stream().allMatch(phone -> phone.getLongDistanceCallTime() > 0));
    }

    @Test
    public void testSortByLastName() {
        phoneService.sortByLastName(testPhones);

        System.out.println("Sorted Phones by Last Name: ");
        for (Phone phone : testPhones) {
            System.out.println(phone.getLastName() + ": " + phone);
        }

        Assert.assertEquals(testPhones[0].getLastName(), "Adams");
        Assert.assertEquals(testPhones[1].getLastName(), "Brown");
        Assert.assertEquals(testPhones[2].getLastName(), "Doe");
    }
}