package service;

import entity.Phone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneService {


    public List<Phone> filterByLocalCallTime(Phone[] phones, double threshold) {
        return Arrays.stream(phones)
                .filter(phone -> phone.getLocalCallTime() > threshold)
                .collect(Collectors.toList());
    }


    public List<Phone> filterByLongDistanceCalls(Phone[] phones) {
        return Arrays.stream(phones)
                .filter(phone -> phone.getLongDistanceCallTime() > 0)
                .collect(Collectors.toList());
    }



    public void sortByLastName(Phone[] phones) {
        Arrays.sort(phones, Comparator.comparing(Phone::getLastName));
    }
}
