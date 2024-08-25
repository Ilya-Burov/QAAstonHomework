public class Rectangle implements RectangleShape {
    private double width, height;
    private String fillColor;
    private String borderColor;
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public String getName() {
        return "Прямоугольник";
    }
    @Override
    public double getWidth() {
        return width;
    }
    @Override
    public double getHeight() {
        return height;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
