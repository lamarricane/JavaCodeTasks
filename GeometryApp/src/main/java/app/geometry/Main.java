package app.geometry;

import comparator.GeometryComparison;
import shapes.*;
import shapes.IncorrectTriangleAspectRatio;
import shapes3d.Cube;
import shapes3d.Sphere;

public class Main {
    public static void main(String[] args) throws IncorrectTriangleAspectRatio {
        System.out.println("---GeometryLibrary---");
        Rectangle rectangle1 = new Rectangle(3, 4);
        System.out.println("Rectangle with height = " + rectangle1.getHeight() + ", width = " + rectangle1.getWidth());
        System.out.println("P = " + rectangle1.calculatePerimeter());
        System.out.println("S = " + rectangle1.calculateArea());

        Circle circle1 = new Circle(5.0);
        System.out.println("Circle with radius = " + circle1.getR());
        System.out.println("C = " + circle1.calculateCircumference());
        System.out.println("S = " + circle1.calculateArea());

        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Triangle with sides: " + triangle1.getFirstSide() + ";" + triangle1.getSecondSide() + ";" + triangle1.getThirdSide());
        System.out.println("P = " + triangle1.calculatePerimeter());
        System.out.println("S = " + triangle1.calculateArea());

        System.out.println("---GeometryUtils---");

        Rectangle rectangle2 = new Rectangle(4, 5);
        Circle circle2 = new Circle(5.0);
        Triangle triangle2 = new Triangle(4.0, 5.0, 3.0);

        GeometryComparison geometryComparison = new GeometryComparison();
        System.out.println(geometryComparison.equal(circle1, circle2));
        System.out.println(geometryComparison.equal(triangle1, triangle2));
        System.out.println(geometryComparison.equal(rectangle1, rectangle2));

        System.out.println("---ThreeDimensionalShapes---");
        Sphere sphere = new Sphere(8.2);
        System.out.println("Sphere with radius = " + sphere.getR());
        System.out.println("V = " + sphere.calculateVolume());
        System.out.println("S = " + sphere.calculateSurfaceArea());

        Cube cube = new Cube(6);
        System.out.println("Cube with side = " + cube.getSide());
        System.out.println("V = " + cube.calculateVolume());
        System.out.println("S = " + cube.calculateSurfaceArea());
    }
}