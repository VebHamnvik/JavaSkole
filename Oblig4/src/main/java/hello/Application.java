package hello;

import hello.model.TVSerie;
import hello.model.TVSerieDataRepository;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import hello.model.TVSerie;
import hello.model.Episoder;
import hello.model.TVSerieDataRepository;
import hello.model.TVSerieRepository;
import java.util.ArrayList;


import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);

        //Oppgave 2.3
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello, world!");
            }
        });

        //Oppgave 2.5
        TVSerieDataRepository listeSerier = new TVSerieDataRepository();
        System.out.println("\n********** Alle seriene *********");
        listeSerier.getAlleSerier();
        System.out.println("\n********** En spesifikk serie **********");
        listeSerier.getEnSerie("Band of Brothers");

        






    }
}
