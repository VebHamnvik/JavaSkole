package oblig6;

public class Main {
    public static void main(String[] args) {

        Panda geir = new Panda("Geir", DietType.Herbivore, 5, "Panda");
        Tiger frank = new Tiger("Frank", DietType.Carnivore, 7, "Tiger");
        Tiger helene = new Tiger("Helene", DietType.Carnivore, 17, "Tiger");
        Tiger anna = new Tiger("Anna", DietType.Carnivore, 2, "Tiger");
        Bear gunnar = new Bear("Gunnar", DietType.Omnivore, 30, "Bear");
        Bear mari = new Bear("Mari", DietType.Omnivore, 7, "Bear");

        Zoo kristiansand = new Zoo();
        kristiansand.leggTilDyr(geir);
        kristiansand.leggTilDyr(frank);
        kristiansand.leggTilDyr(helene);
        kristiansand.leggTilDyr(anna);
        kristiansand.leggTilDyr(gunnar);
        kristiansand.leggTilDyr(mari);

        kristiansand.printDyrepark();

    }
}
