package oop;

public class Circle extends Shape {
    private int radius;

    public Circle(String shapeName, int r) {
        super(shapeName);
        this.radius = r;
    }

    @Override
    double area() {
        return (22 / 7) * radius * radius;
    }

}
