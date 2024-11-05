public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    // Vérifie si une cheville ronde entre dans le trou rond
    public boolean fits(RoundPeg peg) {
        return peg.getRadius() <= this.radius;
    }
}