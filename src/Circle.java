public class Circle implements CircleShape {
    private double radius;
    private String fillColor;
    private String borderColor;
    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public String getName() {
        return "Круг";
    }
    @Override
    public double getRadius() {
        return radius;
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
