package projects.triangles;

public class Triangle implements Comparable<Triangle> {
    private String name;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        double perimeter = side1 + side2 + side3;
        return perimeter;
    }

    public double getArea() {
        double halfPerimeter = this.getPerimeter()/2;
        double area = Math.sqrt(
                halfPerimeter * (halfPerimeter - side1)
                        * (halfPerimeter - side2)
                        * (halfPerimeter - side3));
        return area;
    }

    @Override
    public int compareTo(Triangle another) {
        int result = Double.compare(this.getArea(), another.getArea());
        if (result == 0) {
            result = this.getName().compareTo(another.getName());
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
