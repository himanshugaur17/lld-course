package oop;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int w, int h, String shapeName) {
        super(shapeName);
        this.width = w;
        this.height = h;
    }

    @Override
    double area() {
        return height * width;
    }
}