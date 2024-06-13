package Homework10.Animal;

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
