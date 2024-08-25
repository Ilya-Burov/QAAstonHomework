public interface CircleShape extends Shape {
    double getRadius();
    @Override
    default double calculatePerimeter() {
        return 2 * Math.PI * getRadius();
    }
    @Override
    default double calculateArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
