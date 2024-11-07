public class Appel {
    private int level;  // Niveau de l'appel : 1, 2, 3 ou 4
    private String message;  // Message de l'appel

    // Constructeur
    public Appel(int level, String message) {
        this.level = level;
        this.message = message;
    }

    // Getters
    public int getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
