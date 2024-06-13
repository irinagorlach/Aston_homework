package Homework10.Shape;

import java.awt.*;

interface Shape {
    double getPerimeter();

    double getArea();

    Color getFillColor();

    Color getBorderColor();

    default void printShapeInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("------------------------");
    }

}




