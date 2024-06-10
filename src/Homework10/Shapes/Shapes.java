package Homework10.Shapes;

import java.awt.*;

interface Shapes {
    double getPerimeter();

    double getArea();

    Color getFillColor();

    Color getBorderColor();
}

class Circle implements Shapes {
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

class Rectangle implements Shapes {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;


    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
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

class Triangle implements Shapes {
    private double a;
    private double b;
    private double c;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double a, double b, double c, Color fillColor, Color borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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



