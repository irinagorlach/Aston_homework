package Homework6.Park;


public class Main {
    public static void main(String[] args) {
        Park park = new Park(5);

        park.addAttraction("Веселая прыгалка", "10:00 - 20:00", 10);
        park.addAttraction("Весельчак", "10:30 - 22:00", 8);
        park.addAttraction("Укачайка", "10:00 - 22:00", 15);
        park.addAttraction("Огненная горка", "10:00 - 22:00", 20);
        park.addAttraction("Тайфун", "10:00 - 22:00", 20);

        park.printAttractionsInfo();

    }
}
