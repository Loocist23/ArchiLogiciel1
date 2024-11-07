public class PersonneDTO {
    private int id;
    private String nom;
    private String prenom;

    // Constructeur par défaut
    public PersonneDTO() {}

    // Constructeur avec paramètres
    public PersonneDTO(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "PersonneDTO{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "'}";
    }
}
