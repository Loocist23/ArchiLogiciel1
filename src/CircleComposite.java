public class CircleComposite extends Dot {
    private final int radius;

    public CircleComposite(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle at (" + x + ", " + y + "), radius: " + radius);
    }
}
