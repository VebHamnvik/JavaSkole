package oblig2_TVserier;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        TVSerie criticalRole = new TVSerie("Critical Role", "En strømmet d&d serie", 114, LocalDate.of(2015, 3, 12));
        criticalRole.printInfo();

        Episoder arrivalKrag = new Episoder("Arrival at Kraghammer", 1, 1, 183);
        arrivalKrag.printInfo();
    }
}
