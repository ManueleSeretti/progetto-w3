package ManueleSeretti.Entities.pubblicazioni;

import javax.persistence.Entity;

@Entity
public class Libri extends Pubblicazioni {
    private String autore;
    private String genere;

    public Libri() {
    }

    public Libri(String titolo, int anno, int nPag, String autore, String genere) {
        super(titolo, anno, nPag);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", cod_isbm=" + cod_isbm +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", nPag=" + nPag +
                '}';
    }
}
