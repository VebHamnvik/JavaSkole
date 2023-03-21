package hello.controller;

import hello.model.Episoder;
import hello.repository.TVSerieRepository;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Comparator;

public class EpisodeController {
    private TVSerieRepository tvSerieRepository;

    public EpisodeController (TVSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getAlleEpisoderSesong(Context ctx) {
        String tvSerieNavn = ctx.pathParam("tvserie-id");
        String sesongNr1 = ctx.pathParam("sesong-nr");

        int sesongNr2 = Integer.parseInt(sesongNr1);

        ArrayList<Episoder> episoderISesong = tvSerieRepository.getAlleEpisoderSesong(tvSerieNavn, sesongNr2);

        String sortering = ctx.queryParam("sortering");

        if (sortering.equals("episodenr")) {
            episoderISesong.sort(new Comparator<Episoder>() {
                @Override
                public int compare(Episoder e1, Episoder e2) {
                    if (e1.getEpisodeNummer() > e2.getEpisodeNummer()) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            });
        }

        if (sortering.equals("tittel")) {
            episoderISesong.sort(new Comparator<Episoder>() {
                @Override
                public int compare(Episoder e1, Episoder e2) {
                    return e1.getTittel().compareTo(e2.getTittel());
                    }
                }
            );
        }

        if (sortering.equals("spilletid")) {
            episoderISesong.sort(new Comparator<Episoder>() {
                @Override
                public int compare(Episoder e1, Episoder e2) {
                    if (e1.getSpilletid() > e2.getSpilletid()) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            });
        }

        ctx.json(episoderISesong);

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
