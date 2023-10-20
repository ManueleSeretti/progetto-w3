package ManueleSeretti.Entities.pubblicazioni;

import ManueleSeretti.Entities.Prestiti;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pubblicazioni {
    @Id
    @GeneratedValue
    protected int cod_isbm;
    protected String titolo;
    protected int anno;
    protected int nPag;
    @OneToMany(mappedBy = "elemento", cascade = CascadeType.REMOVE)
    Set<Prestiti> noleggi;

    protected Pubblicazioni() {
    }

    public Pubblicazioni(String titolo, int anno, int nPag) {
        this.titolo = titolo;
        this.anno = anno;
        this.nPag = nPag;
    }

    public int getCod_isbm() {
        return cod_isbm;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getnPag() {
        return nPag;
    }

    public void setnPag(int nPag) {
        this.nPag = nPag;
    }
}
