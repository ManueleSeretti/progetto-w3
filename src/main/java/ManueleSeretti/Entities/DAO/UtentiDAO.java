package ManueleSeretti.Entities.DAO;

import ManueleSeretti.Entities.Utenti;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtentiDAO {

    private final EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utenti u) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Nuovo utente salvato correttamente");
    }

    public Utenti findById(int id) {
        return em.find(Utenti.class, id);
    }

    public void findByIdAndDelete(int id) {

        Utenti found = em.find(Utenti.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L' Utente è stata cancellato correttamente");
        } else {
            System.err.println("L'Utente con l'id " + id + " non è stato trovato");
        }


    }
}
