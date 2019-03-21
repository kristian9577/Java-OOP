package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3.0, 4.0);
        Shape circle = new Circle(3.0);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

    }
}
