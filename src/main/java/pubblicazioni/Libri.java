package pubblicazioni;

import javax.persistence.Entity;

@Entity
public class Libri extends Pubblicazioni {
    private String autore;
    private String genere;
}
