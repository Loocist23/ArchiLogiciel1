public abstract class Appareil {
    protected String nom;
    protected Mediator mediator;

    public Appareil(String nom, Mediator mediator) {
        this.nom = nom;
        this.mediator = mediator;
        mediator.ajouterAppareil(this);
    }

    public abstract void envoyerMessage(String message);

    public void recevoirMessage(String message) {
        System.out.println(nom + " a reçu le message : " + message);
    }
}
