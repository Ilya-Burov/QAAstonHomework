public class Triangle implements TriangleShape {
    private double sideA, sideB, sideC;
    private String fillColor;
    private String borderColor;
    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public String getName() {
        return "Треугольник";
    }
    @Override
    public double getSideA() {
        return sideA;
    }
    @Override
    public double getSideB() {
        return sideB;
    }
    @Override
    public double getSideC() {
        return sideC;
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
