package Homework10.Animal;

public class Animal {
    String name;
    private static int countAnimal = 0;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    public String getName() {
        return name;
    }

}

class Dog extends Animal {
    private static int countDog = 0;
    private int runLimit = 500;
    private int swimLimit = 10;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не может пробежать " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " не может проплыть " + distance + " метров");
        }
    }

    public static int getCountDog() {
        return countDog;
    }

}

class Cat extends Animal {
    private static int countCat = 0;
    private int runLimit = 200;

    private boolean full;

    public Cat(String name) {
        super(name);
        countCat++;
        this.full = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не может пробежать " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eatFromBowl(Bowl bowl) {
        if (bowl.amountFood() >= 10) {
            bowl.putAwayFood(10);
            this.full = true;
            System.out.println(name + " сытно покушал");
        } else {
            System.out.println(name + " хотел бы еще еды");
        }
    }

    public boolean full() {
        return full;
    }

    public static int getCountCat() {
        return countCat;
    }

}

class Bowl {
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