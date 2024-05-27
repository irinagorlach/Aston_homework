package Homework6.Employee;

public class Main {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Кухарский Владимир", "Инженер", "Kuharsky@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Employee("Степанова Надежда", "Конструктор", "stepanova777@mailbox.com", "892366712", 45000, 33);
        persArray[2] = new Employee("Белодед Валентин", "Архитектор", "belodedVal@mailbox.com", "892789312", 32000, 28);
        persArray[3] = new Employee("Качан Степан", "Геолог", "kachan@mailbox.com", "892793272", 55000, 45);
        persArray[4] = new Employee("Клечанова Елизавета", "Инженер-проектировщик", "klelizan@mailbox.com", "892322332", 60000, 58);

        persArray[3].printObjectInformation();
    }
}
