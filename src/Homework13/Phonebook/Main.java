package Homework13.Phonebook;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Весельчакова", "+375(29)9990909");
        phonebook.add("Кулагин", "+375(29)9990989");
        phonebook.add("Бобров", "+375(44)5157018");
        phonebook.add("Бухтиярова", "+375(29)1118970");
        phonebook.add("Иванов", "+375(44)3789055");
        phonebook.add("Привалова", "+375(29)1110989");
        phonebook.add("Бобров", "+375(29)7770956");
        phonebook.add("Привалова", "+375(29)7770909");
        phonebook.add("Алехандров", "+375(29)9999999");
        phonebook.add("Привалова", "+375(29)7668909");

        System.out.println("Привалова: " + phonebook.get("Привалова"));
        System.out.println("Бобров: " + phonebook.get("Бобров"));
        System.out.println("Весельчакова: " + phonebook.get("Весельчакова"));
    }
}
