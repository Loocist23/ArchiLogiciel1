public abstract class CentreAppel {
    protected int level;
    protected CentreAppel next;

    // Constructeur
    public CentreAppel(int level) {
        this.level = level;
    }

    // Définir le centre suivant dans la chaîne
    public void setNext(CentreAppel next) {
        this.next = next;
    }

    // Méthode pour traiter l'appel
    public void traiterAppel(Appel appel) {
        if (appel.getLevel() == this.level) {
            System.out.println("Centre de niveau " + this.level + " traite l'appel : " + appel.getMessage());
        } else if (next != null) {
            next.traiterAppel(appel);
        } else {
            System.out.println("Aucun centre ne peut traiter cet appel de niveau " + appel.getLevel());
        }
    }
}
