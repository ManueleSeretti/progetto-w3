package ManueleSeretti.Entities;

import ManueleSeretti.Entities.pubblicazioni.Pubblicazioni;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestiti {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utenti utente;

    @ManyToOne
    @JoinColumn(name = "id_pubblicazione")
    private Pubblicazioni elemento;
    private LocalDate data_inizio;
    private LocalDate data_prevista;
    private LocalDate data_restituzione;


    public Prestiti() {
    }

    public Prestiti(Utenti utente, Pubblicazioni elemento, LocalDate data_inizio) {
        this.utente = utente;
        this.elemento = elemento;
        this.data_inizio = data_inizio;
    }

    public int getId() {
        return id;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public Pubblicazioni getElemento() {
        return elemento;
    }

    public void setElemento(Pubblicazioni elemento) {
        this.elemento = elemento;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(LocalDate data_prevista) {
        this.data_prevista = data_prevista;
    }

    public LocalDate getData_restituzione() {
        return data_restituzione;
    }

    public void setData_restituzione(LocalDate data_restituzione) {
        this.data_restituzione = data_restituzione;
    }

    @Override
    public String toString() {
        return "Prestiti{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento=" + elemento +
                ", data_inizio=" + data_inizio +
                ", data_prevista=" + data_prevista +
                ", data_restituzione=" + data_restituzione +
                '}';
    }
}
