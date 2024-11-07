public class Boeing extends Appareil {
    public Boeing(String nom, Mediator mediator) {
        super(nom, mediator);
    }

    @Override
    public void envoyerMessage(String message) {
        System.out.println("Boeing " + nom + " envoie : " + message);
        mediator.envoyerMessage(message, this);
    }
}
