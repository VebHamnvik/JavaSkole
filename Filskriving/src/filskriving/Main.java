package filskriving;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        //Filstien er relativ, så i dette tilfelle trenger man bare filen
        //men hvis filen er et annet sted enn koden så må filstien med
        String filsti = "novelle.txt";

        String lestTekst = "";

        System.out.println("Skriv tekst ('avslutt' for å avslutte)");

        //Lese tekst fra terminalen
        //TryExcept blokk
        //Ved å lage disse objektene i try blokken vil de lukkes automatisk. "Try-with-resources"
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(filsti, true)){

            while (!lestTekst.equals("avslutt")) {
                System.out.print(": ");
                lestTekst = bufferedReader.readLine();
                fileWriter.write(lestTekst + "\n");
            }

        }
        catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        finally {
            System.out.println("Kjøres uansett om en feil eller ikke");
        }

    }
}
