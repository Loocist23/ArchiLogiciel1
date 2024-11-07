import java.util.ArrayList;
import java.util.List;

public abstract class TourDeControle implements Mediator {
    protected List<Appareil> appareils = new ArrayList<>();

    @Override
    public void ajouterAppareil(Appareil appareil) {
        appareils.add(appareil);
    }

    @Override
    public void envoyerMessage(String message, Appareil appareil) {
        for (Appareil a : appareils) {
            if (a != appareil) {
                a.recevoirMessage(message);
            }
        }
    }
}
