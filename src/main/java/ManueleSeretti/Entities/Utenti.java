package ManueleSeretti.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Utenti {
    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cognome;
    private LocalDate data_nascita;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE)
    private Set<Prestiti> noleggi;

    public Utenti() {
    }

    public Utenti(String nome, String cognome, LocalDate data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    public int getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
