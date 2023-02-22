package oblig2_TVserier;
import java.time.LocalDate;

public class Film extends Produksjon{

    public Film(String title, int spilletid, LocalDate utgivelse, String beskrivelse) {
        super(title, spilletid, utgivelse, beskrivelse);
    }

    @Override
    public String toString() {
        return getTitle() + " is a movie made in " + getUtgivelse() + "." + "\nDescription: " + getBeskrivelse() +
                "\nIt runs for " + getSpilletid() + " min, and was directed by " + getRegissor() + "."
                + "\nThese were also a part of this production:\n" + getRoller();
    }
}
