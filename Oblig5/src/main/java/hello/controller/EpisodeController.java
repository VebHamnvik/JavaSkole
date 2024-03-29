package hello.controller;

import hello.model.Episoder;
import hello.repository.TVSerieRepository;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

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

        ctx.json(tvSerieRepository.getEnEpisode(tvserieNavn, sesongNr2, episodeNr2));
    }

    public void slettEpisode(Context ctx) {
        String tvserieNavn = ctx.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(ctx.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(ctx.pathParam("episode-nr"));

        tvSerieRepository.slettEpisode(tvserieNavn, sesongNr, episodeNr);

        ctx.redirect("/tvserie/" + tvserieNavn + "/sesong/" + sesongNr);
    }


    public void oppdaterEpisode(Context ctx) {
        String tvserieNavn = ctx.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(ctx.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(ctx.pathParam("episode-nr"));

        tvSerieRepository.getEnEpisode(tvserieNavn, sesongNr, episodeNr);

        String tittel = ctx.formParam("tittel");
        int nySesongNr = ctx.formParam("sesongNummer") == null ? 1 : Integer.parseInt(ctx.formParam("sesongNummer"));
        int nyEpisodeNr = ctx.formParam("episodeNummer") == null ? 1 : Integer.parseInt(ctx.formParam("episodeNummer"));
        String beskrivelse = ctx.formParam("beskrivelse");
        int spilletid = ctx.formParam("spilletid") == null ? 1 : Integer.parseInt(ctx.formParam("spilletid"));
        String utgivelse = String.valueOf(ctx.formParam("utgivelsesdato"));
        String bildeURL = ctx.formParam("bildeUrl");

        tvSerieRepository.oppdaterEpisode(tvserieNavn, nySesongNr, nyEpisodeNr, tittel, spilletid, LocalDate.parse(utgivelse), beskrivelse, bildeURL);

        ctx.redirect("/tvserie/" + tvserieNavn + "/sesong/" + nySesongNr + "/episode/" + nyEpisodeNr);

    }

    public void lagOgLeggTilEpisode(Context ctx) {
        String tvserieNavn = ctx.pathParam("tvserie-id");
        String tittel = ctx.formParam("tittel");
        int sesongNr = ctx.formParam("sesongNummer") == null ? 1 : Integer.parseInt(ctx.formParam("sesongNummer"));
        int episodeNr = ctx.formParam("episodeNummer") == null ? 1 : Integer.parseInt(ctx.formParam("episodeNummer"));
        //int episodeNr = Integer.parseInt(Objects.requireNonNull(ctx.formParam("episodeNummer")));
        String beskrivelse = ctx.formParam("beskrivelse");
        int spilletid = ctx.formParam("spilletid") == null ? 1 : Integer.parseInt(ctx.formParam("spilletid"));


        //int spilletid = Integer.parseInt(ctx.formParam("spilletid"));

        String tall = "25";
        int tallet = Integer.parseInt(tall);

        //LocalDate utgivelse = LocalDate.parse(ctx.formParam("utgivelsesdato"));
        String utgivelse = String.valueOf(ctx.formParam("utgivelsesdato"));
        String bildeURL = ctx.formParam("bildeUrl");

        tvSerieRepository.lagOgLeggTilEpisode(tvserieNavn,sesongNr, episodeNr,  tittel, spilletid, LocalDate.parse(utgivelse), beskrivelse, bildeURL);

        ctx.redirect("/tvserie/" + tvserieNavn + "/sesong/" + sesongNr);
    }
}
