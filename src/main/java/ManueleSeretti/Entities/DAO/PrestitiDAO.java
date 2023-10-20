package ManueleSeretti.Entities.DAO;

import ManueleSeretti.Entities.Prestiti;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

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

    public Prestiti findById(int id) {
        return em.find(Prestiti.class, id);
    }

    public void findByIdAndDelete(int id) {

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

    public List<Prestiti> findAllNotReturn() {
        TypedQuery<Prestiti> lista = em.createQuery("SELECT p FROM Prestiti p WHERE p.data_restituzione IS null AND p.data_prevista< :now", Prestiti.class);
        LocalDate d = LocalDate.now();
        lista.setParameter("now", d);
        return lista.getResultList();
    }

    public List<Prestiti> findAllNotReturnByUtente(int id) {
        TypedQuery<Prestiti> lista = em.createQuery("SELECT p FROM Prestiti p WHERE p.data_restituzione IS null AND p.utente.id = :id", Prestiti.class);
        lista.setParameter("id", id);
        return lista.getResultList();
    }
}
