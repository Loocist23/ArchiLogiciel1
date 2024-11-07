public class PayByCash implements PayStrategy {
    @Override
    public void pay(int montant) {
        System.out.println("Paiement de " + montant + "€ effectué en espèces.");
    }
}
