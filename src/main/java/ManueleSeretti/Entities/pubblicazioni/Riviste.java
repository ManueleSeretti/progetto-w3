package ManueleSeretti.Entities.pubblicazioni;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Riviste extends Pubblicazioni {
    @Enumerated(EnumType.STRING)
    private Periodic periodicità;

    public Riviste() {

    }

    public Riviste(String titolo, int anno, int nPag, Periodic periodicità) {
        super(titolo, anno, nPag);
        this.periodicità = periodicità;
    }

    public Periodic getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodic periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicità=" + periodicità +
                ", cod_isbm=" + cod_isbm +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", nPag=" + nPag +
                '}';
    }
}
