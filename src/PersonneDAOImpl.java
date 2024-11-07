import java.util.ArrayList;
import java.util.List;

public class PersonneDAOImpl implements PersonneDAO {
    private List<PersonneDTO> personnes = new ArrayList<>();

    @Override
    public List<PersonneDTO> getAll() {
        return personnes;
    }

    @Override
    public PersonneDTO get(int id) {
        for (PersonneDTO personne : personnes) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null; // Retourne null si l'id n'est pas trouvé
    }

    @Override
    public void add(PersonneDTO personne) {
        personnes.add(personne);
        System.out.println("Personne ajoutée : " + personne);
    }

    @Override
    public void save(PersonneDTO personne) {
        PersonneDTO existingPersonne = get(personne.getId());
        if (existingPersonne != null) {
            existingPersonne.setNom(personne.getNom());
            existingPersonne.setPrenom(personne.getPrenom());
            System.out.println("Personne mise à jour : " + existingPersonne);
        } else {
            System.out.println("Personne non trouvée avec l'id : " + personne.getId());
        }
    }

    @Override
    public void delete(int id) {
        PersonneDTO personne = get(id);
        if (personne != null) {
            personnes.remove(personne);
            System.out.println("Personne supprimée : " + personne);
        } else {
            System.out.println("Personne non trouvée avec l'id : " + id);
        }
    }
}
