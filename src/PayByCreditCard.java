public class PayByCreditCard implements PayStrategy {
    @Override
    public void pay(int montant) {
        System.out.println("Paiement de " + montant + "€ effectué par carte de crédit.");
    }
}
