public class Context {
    private PayStrategy strategy;

    // Constructeur
    public Context(PayStrategy strategy) {
        this.strategy = strategy;
    }

    // Méthode pour changer la stratégie
    public void changeStrategy(PayStrategy strategy) {
        this.strategy = strategy;
    }

    // Méthode pour effectuer un paiement
    public void pay(int montant) {
        strategy.pay(montant);
    }
}
