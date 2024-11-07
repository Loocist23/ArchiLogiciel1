import java.util.HashSet;
import java.util.Set;

public class LaPoste {
    private final Set<BoiteALettre> abonnes = new HashSet<>();

    // Méthode pour s'abonner
    public void subscribe(BoiteALettre boiteALettre) {
        abonnes.add(boiteALettre);
    }

    // Méthode pour se désabonner
    public void unsubscribe(BoiteALettre boiteALettre) {
        abonnes.remove(boiteALettre);
    }

    // Méthode pour envoyer un message à tous les abonnés
    public void publish(String message) {
        for (BoiteALettre boiteALettre : abonnes) {
            boiteALettre.update(message);
        }
    }
}
