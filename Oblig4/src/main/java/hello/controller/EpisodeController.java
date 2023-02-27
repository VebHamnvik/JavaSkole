package hello.controller;

import hello.repository.TVSerieRepository;
import io.javalin.http.Context;

public class EpisodeController {
    private TVSerieRepository tvSerieRepository;

    public EpisodeController (TVSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getAlleEpisoderSesong(Context ctx) {
        String tvSerieNavn = ctx.pathParam("tvserie-id");
        String sesongNr1 = ctx.pathParam("sesong-nr");

        int sesongNr2 = Integer.parseInt(sesongNr1);

        //URL: api/tvserie/Witcher/sesong/3
        //api/tvserie/{tvserie-id}/sesong/{sesongNr}

        ctx.json(tvSerieRepository.getAlleEpisoderSesong(tvSerieNavn, sesongNr2));

    }

    public void getEnEpisode(Context ctx) {
        String tvserieNavn = ctx.pathParam("tvserie-id");
        String sesongNr1 = ctx.pathParam("sesong-nr");
        String episodeNr1 = ctx.pathParam("episode-nr");

        int sesongNr2 = Integer.parseInt(sesongNr1);
        int episodeNr2 = Integer.parseInt(episodeNr1);


        //URL: api/tvserie/Witcher/sesong/3/episode/17
        //api/tvserie/{tvserie-id}/sesong/{sesongNr}/episode/{episodeNr}
        

        ctx.json(tvSerieRepository.getEnEpisode(tvserieNavn, sesongNr2, episodeNr2));
    }
}
