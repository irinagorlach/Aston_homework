package Homework10.Shapes;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, Color.green, Color.orange);
        Rectangle rectangle = new Rectangle(25, 50, Color.blue, Color.red);
        Triangle triangle = new Triangle(50, 40, 18, Color.black, Color.white);

        printShapesInfo(circle);
        printShapesInfo(rectangle);
        printShapesInfo(triangle);
    }

    private static void printShapesInfo(Shapes shapes) {
        System.out.println("Периметр: " + shapes.getPerimeter());
        System.out.println("Площадь: " + shapes.getArea());
        System.out.println("Цвет заливки: " + shapes.getFillColor());
        System.out.println("Цвет границ: " + shapes.getBorderColor());
        System.out.println("-------------------------------------------");
    }

}
