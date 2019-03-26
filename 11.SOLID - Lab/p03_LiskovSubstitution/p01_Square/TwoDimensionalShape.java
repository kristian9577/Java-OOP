package p03_LiskovSubstitution.p01_Square;

public  abstract class TwoDimensionalShape extends Shape {
    private double width;

    private double height;

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
