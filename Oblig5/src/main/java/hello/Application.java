package hello;

import hello.controller.EpisodeController;
import hello.controller.TvSerieController;
import hello.repository.TVSerieCSVRepository;
import hello.repository.TVSerieJSONRepository;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;



public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(8001);

        Thread t = Thread.currentThread();
        System.out.println("Tråden som kjører fra start: " + t.getName());

        TVSerieJSONRepository jsonData = new TVSerieJSONRepository("tvshows_10.json");
        TVSerieCSVRepository csvData = new TVSerieCSVRepository("tvshows_10.csv");
        TvSerieController tvSerieController = new TvSerieController(jsonData);
        EpisodeController episodeController = new EpisodeController(jsonData);

        app.get("/", new VueComponent("hello-world"));

        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));

        app.get("api/", new Handler() {
            @Override
            public void handle(Context cxt) {
                cxt.result("Hello, world!");
            }
        });

        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("api/tvserie", new Handler() {
            @Override
            public void handle(Context ctx) {
                tvSerieController.getAlleSerier(ctx);
            }
        });

        app.get("/tvserie/{tvserie-id}/createepisode", new VueComponent("episode-create"));
        app.post("api/tvserie/{tvserie-id}/createepisode", new Handler() {
            @Override
            public void handle(Context ctx){
                episodeController.lagOgLeggTilEpisode(ctx);
            }
        });

        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/updateepisode", new VueComponent("episode-update"));
        app.post("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/updateepisode", new Handler() {
            @Override
            public void handle(Context ctx){
                episodeController.oppdaterEpisode(ctx);
            }
        });


        app.get("api/tvserie/{tvserie-id}", new Handler() {
            @Override
            public void handle(Context ctx) {
                tvSerieController.getEnSerie(ctx);
            }
        });


        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/", new Handler() {
            @Override
            public void handle(Context ctx) {
                episodeController.getAlleEpisoderSesong(ctx);
            }
        });


        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {
            @Override
            public void handle(Context ctx) {
                episodeController.getEnEpisode(ctx);
            }
        });

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}/deleteepisode", new Handler() {
            @Override
            public void handle(Context ctx) {
                episodeController.slettEpisode(ctx);
            }
        });















    }
}
