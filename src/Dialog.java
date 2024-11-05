public abstract class Dialog implements ButtonFactory {


    public void render() {
        // Créer le bouton "OK"
        Button okButton = createButton();
        okButton.setText("Ok");
        okButton.render();  // Affiche le bouton "Ok"

        // Créer le bouton "Annuler"
        Button cancelButton = createButton();
        cancelButton.setText("Annuler");
        cancelButton.render();  // Affiche le bouton "Annuler"
    }
}
