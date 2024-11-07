public class Maison implements BoiteALettre {
    private final String name;

    // Constructeur
    public Maison(String name) {
        this.name = name;
    }

    // Implémentation de la méthode update
    @Override
    public void update(String message) {
        System.out.println("Maison " + name + " a reçu le message : " + message);
    }
}
