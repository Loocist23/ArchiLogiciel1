public class SquarePegAdapter extends RoundPeg {
    private final SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        super(0); // Appel du constructeur de RoundPeg avec un rayon de 0 (le rayon est calculé différemment)
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        // Calcul du rayon minimum qui permettrait au carré d'entrer dans un trou rond
        return (squarePeg.getWidth() * Math.sqrt(2)) / 2;
    }
}