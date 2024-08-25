public interface RectangleShape extends Shape {
    double getWidth();
    double getHeight();
    @Override
    default double calculatePerimeter() {
        return 2 * (getWidth() + getHeight());
    }
    @Override
    default double calculateArea() {
        return getWidth() * getHeight();
    }
}
