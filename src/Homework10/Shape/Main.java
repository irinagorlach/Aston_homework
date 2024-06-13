package Homework10.Shape;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, Color.green, Color.orange);
        Rectangle rectangle = new Rectangle(25, 50, Color.blue, Color.red);
        Triangle triangle = new Triangle(50, 40, 18, Color.black, Color.white);

        circle.printShapeInfo();
        rectangle.printShapeInfo();
        triangle.printShapeInfo();
    }

}
