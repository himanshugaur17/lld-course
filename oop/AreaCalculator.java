package oop;

public class AreaCalculator {
    private static AreaCalculator areaCalculator = null;

    private AreaCalculator() {

    }

    public static synchronized AreaCalculator areaCalculator() {
        if (areaCalculator == null)
            areaCalculator = new AreaCalculator();
        return areaCalculator;
    }

    public double getArea(Shape shape) {
        return shape.area();
    }
}
