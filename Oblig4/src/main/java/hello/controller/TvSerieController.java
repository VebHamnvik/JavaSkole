package hello.controller;

import hello.repository.TVSerieRepository;
import io.javalin.http.Context;

public class TvSerieController {
    private TVSerieRepository tvSerieRepository;

    public TvSerieController (TVSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEnSerie(Context ctx) {
        String tvSerieNavn = ctx.pathParam("tvserie-id");

        ctx.json(tvSerieRepository.getEnSerie(tvSerieNavn));
    }
}
