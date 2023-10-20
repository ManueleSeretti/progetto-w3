package ManueleSeretti.Entities.DAO;

import ManueleSeretti.Entities.Prestiti;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitiDAO {
    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestiti u) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Nuovo noleggio salvato correttamente");
    }

    public Prestiti findById(long id) {
        return em.find(Prestiti.class, id);
    }

    public void findByIdAndDelete(long id) {

        Prestiti found = em.find(Prestiti.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il noleggio è stato cancellato correttamente");
        } else {
            System.err.println("Il noleggio con l'id " + id + " non è stato trovato");
        }


    }
}
