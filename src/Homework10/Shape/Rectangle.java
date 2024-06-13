package Homework10.Shape;

import java.awt.*;

class Rectangle implements Shape {
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
