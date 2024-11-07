public class Airbus extends Appareil {
    public Airbus(String nom, Mediator mediator) {
        super(nom, mediator);
    }

    @Override
    public void envoyerMessage(String message) {
        System.out.println("Airbus " + nom + " envoie : " + message);
        mediator.envoyerMessage(message, this);
    }
}
