package Homework13.Phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonebook = new HashMap<>();
    private List<String> phoneNumberList;

    public void add(String surname, String phoneNumber) {
        if (phonebook.containsKey(surname)) {
            phoneNumberList = phonebook.get(surname);
        } else {
            phoneNumberList = new ArrayList<>();
        }
        phoneNumberList.add(phoneNumber);
        phonebook.put(surname, phoneNumberList);
    }

    public List<String> get(String surname) {
        return phonebook.get(surname);
    }
}
