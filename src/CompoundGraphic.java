import java.util.ArrayList;
import java.util.List;

public class CompoundGraphic implements Graphic {
    private int x;
    private int y;
    private final List<Graphic> children = new ArrayList<>();

    public CompoundGraphic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        for (Graphic child : children) {
            child.move(deltaX, deltaY);
        }
    }

    @Override
    public void draw() {
        System.out.println("CompoundGraphic at (" + x + ", " + y + ") with children:");
        for (Graphic child : children) {
            child.draw();
        }
    }
}
