package Homework13.Phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private Map<String, Set<String>> phonebook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        Set<String> phoneNumberSet = phonebook.getOrDefault(surname, new HashSet<>());
        ;
        phoneNumberSet.add(phoneNumber);
        phonebook.put(surname, phoneNumberSet);
    }

    public Set<String> get(String surname) {
        return phonebook.getOrDefault(surname, new HashSet<>());
    }
}
