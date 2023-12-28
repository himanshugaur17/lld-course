package oop;

public class OpenClosedPrincSim {
    public static void main(String[] args) {
        Shape circle = new Circle("circle", 14);
        Shape rectangle = new Rectangle(3, 4, "rectangle");
        System.out.println(AreaCalculator.areaCalculator().getArea(rectangle));
        System.out.println(AreaCalculator.areaCalculator().getArea(circle));

    }
}
