package ManueleSeretti.Entities.DAO;

import ManueleSeretti.Entities.pubblicazioni.Pubblicazioni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

    public Pubblicazioni findById(long id) {
        return em.find(Pubblicazioni.class, id);
    }

    public void findByIdAndDelete(long id) {

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
}
