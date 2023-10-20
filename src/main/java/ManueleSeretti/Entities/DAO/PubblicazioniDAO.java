package ManueleSeretti.Entities.DAO;

import ManueleSeretti.Entities.pubblicazioni.Pubblicazioni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PubblicazioniDAO {

    private final EntityManager em;

    public PubblicazioniDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Pubblicazioni u) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Nuova pubblicazione salvata correttamente");
    }

    public Pubblicazioni findById(int id) {
        return em.find(Pubblicazioni.class, id);
    }

    public void findByIdAndDelete(int id) {

        Pubblicazioni found = em.find(Pubblicazioni.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La Pubblicazione è stata cancellato correttamente");
        } else {
            System.err.println("La Pubblicazione con l'id " + id + " non è stata trovata");
        }
    }

    public List<Pubblicazioni> findByYear(int y) {
        TypedQuery<Pubblicazioni> lista = em.createQuery("SELECT p FROM Pubblicazioni p WHERE p.anno = :year", Pubblicazioni.class);
        lista.setParameter("year", y);
        return lista.getResultList();
    }

    public List<Pubblicazioni> findByAuthor(String a) {
        TypedQuery<Pubblicazioni> lista = em.createQuery("SELECT p FROM Pubblicazioni p WHERE LOWER(p.autore) = LOWER(:autore)", Pubblicazioni.class);
        lista.setParameter("autore", a);
        return lista.getResultList();
    }

    public List<Pubblicazioni> findByTitle(String title) {
        TypedQuery<Pubblicazioni> getPubblicazioni = em.createQuery("SELECT p FROM Pubblicazioni p WHERE LOWER(p.titolo) LIKE LOWER(CONCAT(:title, '%'))", Pubblicazioni.class);
        getPubblicazioni.setParameter("title", title);
        return getPubblicazioni.getResultList();
    }
}
