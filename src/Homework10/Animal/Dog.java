package Homework10.Animal;

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
