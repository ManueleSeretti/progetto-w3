package ManueleSeretti;

import ManueleSeretti.Entities.DAO.PrestitiDAO;
import ManueleSeretti.Entities.DAO.PubblicazioniDAO;
import ManueleSeretti.Entities.DAO.UtentiDAO;
import ManueleSeretti.Entities.Prestiti;
import ManueleSeretti.Entities.Utenti;
import ManueleSeretti.Entities.pubblicazioni.Libri;
import ManueleSeretti.Entities.pubblicazioni.Periodic;
import ManueleSeretti.Entities.pubblicazioni.Pubblicazioni;
import ManueleSeretti.Entities.pubblicazioni.Riviste;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
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
        Scanner input = new Scanner(System.in);

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
//               LocalDate d = nol.getData_inizio();
//               LocalDate d1 = d.plusDays(rndm.nextInt(0, 30));
//               nol.setData_restituzione(d1);
//
//            } else {
//                nol.setData_restituzione(null);
//            }
//            preDao.save(nol);
//        }


        while (true) {
            try {
                System.out.println("COSA VUOI CERCARE? PREMI 0 PER USCIRE DAL PROGRAMMA");
                System.out.println("1-PUBBLICAZIONE TRAMITE ID");
                System.out.println("2-PUBBLICAZIONE TRAMITE ANNO");
                System.out.println("3-PUBBLICAZIONE TRAMITE AUTORE");
                System.out.println("4-PUBBLICAZIONE TRAMITE TITOLO");
                System.out.println("5-PRESTITO DI UN UTENTE ");
                System.out.println("6-TUTTI I PRESTITI NON RITORNATI ");
                int scelta = Integer.parseInt(input.nextLine());
                if (scelta == 0) break;
                switch (scelta) {
                    case 1: {
                        System.out.println(" ");
                        System.out.println("INSERISCI L'ID DELLA PUBBLICAZIONE ");
                        int id_pub = Integer.parseInt(input.nextLine());
                        Pubblicazioni pub = pDao.findById(id_pub);
                        System.out.println(pub);
                        break;
                    }
                    case 2: {
                        System.out.println(" ");
                        System.out.println("INSERISCI L'ANNO DELLA PUBBLICAZIONE ");
                        int anno = Integer.parseInt(input.nextLine());
                        List<Pubblicazioni> lista = pDao.findByYear(anno);
                        if (!lista.isEmpty())
                            lista.forEach(System.out::println);
                        else System.out.println("nessuna pubblicazione trovata");
                        break;
                    }
                    case 3: {
                        System.out.println(" ");
                        System.out.println("INSERISCI L'AUTORE DEL LIBRO ");
                        String a = input.nextLine();
                        List<Pubblicazioni> listaAut = pDao.findByAuthor(a);
                        if (!listaAut.isEmpty())
                            listaAut.forEach(System.out::println);
                        else System.out.println("nessun libro trovato");
                        break;
                    }
                    case 4: {
                        System.out.println(" ");
                        System.out.println("INSERISCI TITOLO DELLA PUBBLICAZIONE ");
                        String title = input.nextLine();
                        List<Pubblicazioni> listaTit = pDao.findByTitle(title);
                        if (!listaTit.isEmpty())
                            listaTit.forEach(System.out::println);
                        else System.out.println("nessun libro trovato");
                        break;
                    }
                    case 5: {
                        System.out.println(" ");
                        System.out.println("INSERISCI L'ID DELL'UTENTE");
                        int id_utente = Integer.parseInt(input.nextLine());
                        List<Prestiti> listaPreUtente = preDao.findAllNotReturnByUtente(id_utente);
                        if (!listaPreUtente.isEmpty())
                            listaPreUtente.forEach(System.out::println);
                        else System.out.println("nessun libro non riconsegnato");
                        break;
                    }
                    case 6: {
                        System.out.println(" ");
                        System.out.println("TUTTI LE PUBBLICAZIONI CHE NON SONO STATE RICONSEGNATE");
                        List<Prestiti> listaPre = preDao.findAllNotReturn();
                        if (!listaPre.isEmpty())
                            listaPre.forEach(System.out::println);
                        else System.out.println("nessun libro non riconsegnato");
                        break;
                    }
                    default: {
                        System.out.println("scelta non valida....");
                        break;
                    }
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        emf.close();
        em.close();
        input.close();

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


        //RICERCA PER TITOLO
//        List<Pubblicazioni> listaTit = pDao.findByTitle("C");
//        if (listaTit.size() > 0)
//            listaTit.forEach(System.out::println);
//        else System.out.println("nessun libro trovato");

//RICERCA LIBRI IN NOLEGGIO DI UN UTENTE
//        List<Prestiti> listaPreUtente = preDao.findAllNotReturnByUtente(82);
//        if (!listaPreUtente.isEmpty())
//            listaPreUtente.forEach(System.out::println);
//        else System.out.println("nessun libro non riconsegnato");


        //RICERCA TUTTI QUELLI NON RICONSEGNATI

//        List<Prestiti> listaPre = preDao.findAllNotReturn();
//        if (!listaPre.isEmpty())
//            listaPre.forEach(System.out::println);
//        else System.out.println("nessun libro non riconsegnato");
//

    }
}
