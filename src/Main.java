public class Main {
    public static void main(String[] args) {
        ////////////////////////////////////////////

        //TEST AVEC LES BUILDERS

        // Test avec MysqlQueryBuilder
        QueryBuilder mysqlBuilder = new MysqlQueryBuilder();
        String mysqlQuery = mysqlBuilder
                .select("users", new String[]{"id", "name", "email"})
                .where("id", new String[]{">"}, new Object[]{10})
                .limit(5, 10)
                .buildQuery();
        System.out.println("MySQL Query: " + mysqlQuery);
        // Test avec PostgresQueryBuilder
        QueryBuilder postgresBuilder = new PostgresQueryBuilder();
        String postgresQuery = postgresBuilder
                .select("orders", new String[]{"order_id", "amount", "status"})
                .where("status", new String[]{"="}, new Object[]{"completed"})
                .limit(0, 5)
                .buildQuery();
        System.out.println("PostgreSQL Query: " + postgresQuery);
        // Test avec MongoQueryBuilder
        QueryBuilder mongoBuilder = new MongoQueryBuilder();
        String mongoQuery = mongoBuilder
                .select("users", new String[]{"name", "email", "age"})
                .where("age", new String[]{"$gt"}, new Object[]{18})
                .limit(5, 0)
                .buildQuery();
        System.out.println("MongoDB Query: " + mongoQuery);


        ////////////////////////////////////////////

        // TEST AVEC LES PROTOTYPE

        Circle originalCircle = new Circle();
        originalCircle.x = 10;
        originalCircle.y = 20;
        originalCircle.color = "Red";
        originalCircle.radius = 5.5;

        Circle clonedCircle = originalCircle.clone();
        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Cloned Circle: " + clonedCircle);

        Rectangle originalRectangle = new Rectangle();
        originalRectangle.x = 15;
        originalRectangle.y = 25;
        originalRectangle.color = "Blue";
        originalRectangle.width = 30;
        originalRectangle.height = 40;

        Rectangle clonedRectangle = originalRectangle.clone();
        System.out.println("Original Rectangle: " + originalRectangle);
        System.out.println("Cloned Rectangle: " + clonedRectangle);

        ///////////////////////////////////////////////

        // TEST AVEC LES ADAPTER

        // Créer un trou rond de rayon 10
        RoundHole hole = new RoundHole(10);

        // Vérifier qu'un RoundPeg de rayon 9 rentre dans le trou
        RoundPeg roundPegSmall = new RoundPeg(9);
        System.out.println("RoundPeg (radius 9) fits: " + hole.fits(roundPegSmall)); // true

        // Vérifier qu'un RoundPeg de rayon 11 ne rentre pas dans le trou
        RoundPeg roundPegLarge = new RoundPeg(11);
        System.out.println("RoundPeg (radius 11) fits: " + hole.fits(roundPegLarge)); // false

        // Vérifier qu'un SquarePeg de largeur 10 rentre dans le trou via l'adaptateur
        SquarePeg smallSquarePeg = new SquarePeg(10);
        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        System.out.println("SquarePeg (width 10) fits: " + hole.fits(smallSquarePegAdapter)); // true

        // Vérifier qu'un SquarePeg de largeur 18 ne rentre pas dans le trou via l'adaptateur
        SquarePeg largeSquarePeg = new SquarePeg(18);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);
        System.out.println("SquarePeg (width 18) fits: " + hole.fits(largeSquarePegAdapter)); // false


        /////////////////////////////////////////

        // ON TEST AVEC UN COMPOSITE

        // Création de l'objet root de type CompoundGraphic
        CompoundGraphic root = new CompoundGraphic(1, 1);
        root.add(new Dot(2, 2));
        root.add(new CircleComposite(2, 2, 50));

        // Création de l'objet graph de type CompoundGraphic
        CompoundGraphic graph = new CompoundGraphic(10, 10);
        graph.add(new Dot(20, 20));
        graph.add(new CircleComposite(30, 20, 20));

        // Ajouter graph à root
        root.add(graph);

        // Afficher le contenu de root
        System.out.println("Contenu initial de root:");
        root.draw();

        // Bouger root de (2, 2)
        root.move(2, 2);

        // Réafficher le contenu de root
        System.out.println("\nContenu de root après déplacement:");
        root.draw();

        /////////////////////////////////

        // ON TEST AVEC UN OBSERVER

        // Instancier LaPoste
        LaPoste laPoste = new LaPoste();

        // Créer 5 maisons
        Maison maison1 = new Maison("Maison 1");
        Maison maison2 = new Maison("Maison 2");
        Maison maison3 = new Maison("Maison 3");
        Maison maison4 = new Maison("Maison 4");
        Maison maison5 = new Maison("Maison 5");

        // Ajouter 4 maisons à LaPoste
        laPoste.subscribe(maison1);
        laPoste.subscribe(maison2);
        laPoste.subscribe(maison3);
        laPoste.subscribe(maison4);

        // Envoyer un message
        System.out.println("\n\nPremier message :");
        laPoste.publish("Bienvenue à LaPoste !");

        // Ajouter 3 nouvelles maisons
        Maison maison6 = new Maison("Maison 6");
        Maison maison7 = new Maison("Maison 7");
        Maison maison8 = new Maison("Maison 8");

        // Ajouter 2 de ces maisons à LaPoste
        laPoste.subscribe(maison6);
        laPoste.subscribe(maison7);

        // Envoyer un deuxième message
        System.out.println("\nDeuxième message :");
        laPoste.publish("Nouveau message à toutes les maisons abonnées !");

        // On enleve 4 maison a la poste
        laPoste.unsubscribe(maison8);
        laPoste.unsubscribe(maison6);
        laPoste.unsubscribe(maison7);
        laPoste.unsubscribe(maison5);

        // Envoyer un message
        System.out.println("\nTroisieme message :");
        laPoste.publish("HAAAAAAAAAAAAA");


        /////////////////////////////////////////

        // ON TEST AVEC UNE STRATEGY

        System.out.println("\n\n");

        // Initialisation avec une stratégie PayPal
        Context context = new Context(new PayByPaypal());
        context.pay(100);

        // Changer la stratégie pour un paiement par carte de crédit
        context.changeStrategy(new PayByCreditCard());
        context.pay(200);

        // Changer la stratégie pour un paiement en espèces
        context.changeStrategy(new PayByCash());
        context.pay(50);

        /////////////////////////////////////////

        // ON TEST AVEC UN MEDIATOR

        System.out.println("\n\n");

        // Création des tours de contrôle
        RoissyCDG roissy = new RoissyCDG();
        NYLaGuardia laGuardia = new NYLaGuardia();

        // Création des appareils
        Appareil airbus1 = new Airbus("A320", roissy);
        Appareil boeing1 = new Boeing("737", roissy);
        Appareil helico1 = new Helico("H1", laGuardia);

        // Tester la communication via RoissyCDG
        airbus1.envoyerMessage("Demande d'autorisation de décollage.");
        boeing1.envoyerMessage("Demande d'atterrissage.");

        // Tester la communication via NYLaGuardia
        helico1.envoyerMessage("En route vers le point de rendez-vous.");

        ///////////////////////////////////////////

        // ON TEST LE CHAIN OF RESPONSABILITY

        System.out.println("\n\n");

        CentreAppel centre1 = new CentreAppelLevel1();
        CentreAppel centre2 = new CentreAppelLevel2();
        CentreAppel centre3 = new CentreAppelLevel3();
        CentreAppel centre4 = new CentreAppelLevel4();

        // Définir la chaîne de responsabilité
        centre1.setNext(centre2);
        centre2.setNext(centre3);
        centre3.setNext(centre4);

        // Tester différents appels
        Appel appel1 = new Appel(1, "Problème simple");
        Appel appel2 = new Appel(2, "Problème modéré");
        Appel appel3 = new Appel(3, "Problème complexe");
        Appel appel4 = new Appel(4, "Problème critique");
        Appel appel5 = new Appel(5, "Problème inconnu");

        // Traiter les appels
        centre1.traiterAppel(appel1);
        centre1.traiterAppel(appel2);
        centre1.traiterAppel(appel3);
        centre1.traiterAppel(appel4);
        centre1.traiterAppel(appel5);

        ///////////////////////////////////////////////

        // ON TEST AVEC

    }
}
