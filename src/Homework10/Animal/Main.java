package Homework10.Animal;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("пес Дружок");
        Cat cat1 = new Cat("кот Тигрик");

        dog.run(500);
        cat1.run(200);
        dog.swim(10);
        cat1.swim(10);

        Bowl bowl = new Bowl(20);
        Cat[] cats = {new Cat("Плохиш"), new Cat("Гаражик"), new Cat("Попрыгун"), new Cat("Джеки")};

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.full());
        }

        bowl.addFood(10);

        System.out.println("-----------------");
        System.out.println("Всего животных: " + Animal.getCountAnimal());
        System.out.println("Всего собак: " + Dog.getCountDog());
        System.out.println("Всего котов: " + Cat.getCountCat());
    }
}
