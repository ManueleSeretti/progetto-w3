package ManueleSeretti;

import ManueleSeretti.Entities.DAO.PrestitiDAO;
import ManueleSeretti.Entities.DAO.PubblicazioniDAO;
import ManueleSeretti.Entities.DAO.UtentiDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PubblicazioniDAO pDao = new PubblicazioniDAO(em);
        PrestitiDAO preDao = new PrestitiDAO(em);
        UtentiDAO uDao = new UtentiDAO(em);

        System.out.println("Hello World!");
    }
}
