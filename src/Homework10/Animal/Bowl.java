package Homework10.Animal;

public class Bowl {
    private int amountFood;

    public Bowl(int amountFood) {
        this.amountFood = amountFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            amountFood += amount;
            System.out.println("Добавили " + amount + " еды");
        }
    }

    public int amountFood() {
        return amountFood;
    }

    public void putAwayFood(int amount) {
        if (amount > 0 && amount <= amountFood) {
            amountFood -= amount;
        }
    }

}
