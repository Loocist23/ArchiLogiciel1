public class Circle extends Shape {
    public double radius;

    public Circle() {
    }

    public Circle(Circle circle) {
        super(circle);
        if (circle != null) {
            this.radius = circle.radius;
        }
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return "Circle [x=" + x + ", y=" + y + ", color=" + color + ", radius=" + radius + "]";
    }
}