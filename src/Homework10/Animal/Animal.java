package Homework10.Animal;

abstract class Animal {
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
