package hello;

import hello.controller.EpisodeController;
import hello.controller.TvSerieController;
import hello.repository.TVSerieDataRepository;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import org.jetbrains.annotations.NotNull;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(7070);

        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.registerModule(new JavaTimeModule());

        //Oppgave 2.3
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello, world!");
            }
        });

        //Oppgave 2.5
        TVSerieDataRepository listeSerier = new TVSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(listeSerier);
        EpisodeController episodeController = new EpisodeController(listeSerier);

        System.out.println("\n********** Alle seriene *********");
        System.out.println(listeSerier.getAlleSerier());
        System.out.println("\n********** En spesifikk serie **********");
        System.out.println(listeSerier.getEnSerie("Band of Brothers"));
        System.out.println("\n********** Teste ERROR **********");

        //Oppgave 2.6
        //VueComponent/frontend
        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));

        //API
        //Henter alle tvserier
        app.get("api/tvserie", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) {
                ctx.json(listeSerier);
            }
        });

        //Henter 1 tvserie
        //F.eks. api/tvserie/Witcher
        app.get("api/tvserie/{tvserie-id}", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) {
                tvSerieController.getEnSerie(ctx);
            }
        });

        //Henter alle episoder i 1 sesong fra 1 tvserie
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) {
                episodeController.getAlleEpisoderSesong(ctx);
            }
        });

        //Henter 1 episode fra 1 tvserie
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) {
                episodeController.getEnEpisode(ctx);
            }
        });










    }
}
