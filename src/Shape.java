public interface Shape {
    default double calculatePerimeter() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    default double calculateArea() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    String getFillColor();
    String getBorderColor();
    String getName();
}
