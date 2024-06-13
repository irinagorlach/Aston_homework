package Homework10.Shape;

import java.awt.*;

class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;


    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}
