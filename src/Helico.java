public class Helico extends Appareil {
    public Helico(String nom, Mediator mediator) {
        super(nom, mediator);
    }

    @Override
    public void envoyerMessage(String message) {
        System.out.println("Hélicoptère " + nom + " envoie : " + message);
        mediator.envoyerMessage(message, this);
    }
}
