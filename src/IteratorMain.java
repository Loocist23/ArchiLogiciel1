import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class IteratorMain {

    public static void main(String[] args) {
        // Création d'un ArrayList avec 10 éléments
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arrayList.add("ArrayList Element " + i);
        }

        // Création d'un Vector avec 15 éléments
        Vector<String> vector = new Vector<>();
        for (int i = 1; i <= 15; i++) {
            vector.add("Vector Element " + i);
        }

        // Création d'un HashSet avec 20 éléments
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            hashSet.add("HashSet Element " + i);
        }

        // Affichage des éléments de chaque collection
        System.out.println("Affichage des éléments de l'ArrayList :");
        afficheElements(arrayList);

        System.out.println("\nAffichage des éléments du Vector :");
        afficheElements(vector);

        System.out.println("\nAffichage des éléments du HashSet :");
        afficheElements(hashSet);
    }

    // Méthode générique pour afficher les éléments d'une collection Iterable
    public static void afficheElements(Iterable<String> collection) {
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
