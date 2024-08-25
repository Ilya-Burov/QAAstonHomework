public interface TriangleShape extends Shape {
    double getSideA();
    double getSideB();
    double getSideC();
    @Override
    default double calculatePerimeter() {
        return getSideA() + getSideB() + getSideC();
    }
    @Override
    default double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - getSideA()) * (s - getSideB()) * (s - getSideC()));
    }
}
