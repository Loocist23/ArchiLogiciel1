public interface Mediator {
    void envoyerMessage(String message, Appareil appareil);
    void ajouterAppareil(Appareil appareil);
}
