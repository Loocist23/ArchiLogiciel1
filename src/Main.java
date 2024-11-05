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
    }
}
