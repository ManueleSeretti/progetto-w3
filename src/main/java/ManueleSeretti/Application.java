package ManueleSeretti;

import ManueleSeretti.Entities.DAO.PrestitiDAO;
import ManueleSeretti.Entities.DAO.PubblicazioniDAO;
import ManueleSeretti.Entities.DAO.UtentiDAO;
import ManueleSeretti.Entities.Utenti;
import ManueleSeretti.Entities.pubblicazioni.Libri;
import ManueleSeretti.Entities.pubblicazioni.Periodic;
import ManueleSeretti.Entities.pubblicazioni.Riviste;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PubblicazioniDAO pDao = new PubblicazioniDAO(em);
        PrestitiDAO preDao = new PrestitiDAO(em);
        UtentiDAO uDao = new UtentiDAO(em);
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        Supplier<Libri> libroSupplier = () -> new Libri(faker.book().title(), rndm.nextInt(1990, 2023), rndm.nextInt(20, 350), faker.book().author(), faker.book().genre());
        Supplier<Riviste> rivistaSupplier = () -> new Riviste(faker.book().title(), rndm.nextInt(1990, 2023), rndm.nextInt(20, 200), Periodic.randomPeriodic());
        Supplier<Utenti> utentiSupplier = () -> new Utenti(faker.name().firstName(), faker.name().lastName(), LocalDate.of(rndm.nextInt(1970, 2005), rndm.nextInt(1, 12), rndm.nextInt(1, 31)));
//CREAZIONE NUOVI LIBRI E RIVISTE

//        for (int i = 0; i < 40; i++) {
//            pDao.save(libroSupplier.get());
//            pDao.save(rivistaSupplier.get());
//        }
//        System.out.println("Hello World!");

        //CREAZIONE NUOVI UTENTI

//        for (int i = 0; i < 50; i++) {
//
//            uDao.save(utentiSupplier.get());
//
//        }

        //CREAZIONE NUOVI PRESTITI

//        for (int i = 0; i < 150; i++) {
//
//            Pubblicazioni p = pDao.findById(rndm.nextInt(1, 80));
//            Utenti u = uDao.findById(rndm.nextInt(81, 130));
//            Prestiti nol = new Prestiti(u, p, LocalDate.of(rndm.nextInt(2015, 2023), rndm.nextInt(1, 12), rndm.nextInt(1, 31)));
//            int x = rndm.nextInt(0, 100);
//            if (x % 2 == 0) {
//                nol.setData_restituzione(LocalDate.of(rndm.nextInt(2015, 2023), rndm.nextInt(1, 12), rndm.nextInt(1, 31)));
//            } else {
//                nol.setData_restituzione(null);
//            }
//            preDao.save(nol);
//        }

        // RICERCA DI UNA PUBBLICAZIONE TRAMITE ID

        //Pubblicazioni pub=pDao.findById(23);
        //System.out.println(pub);
        // ELIMINAZIONE DI UNA PUBBLICAZIONE TRAMITE ID

        // pDao.findByIdAndDelete(23);

        //RICERCA PER ANNO
//
//        List<Pubblicazioni> lista = pDao.findByYear(2000);
//        lista.forEach(System.out::println);

        //RICERCA PER AUTORE
//
//        List<Pubblicazioni> listaAut = pDao.findByAuthor("Max Galli");
//        listaAut.forEach(System.out::println);
    }
}
