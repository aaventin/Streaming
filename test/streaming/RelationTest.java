/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import streaming.entity.Film;
import streaming.entity.Genre;
import static streaming.entity.Genre_.nom;
import streaming.entity.Pays;
import streaming.entity.Realisateur;
import streaming.service.DbService;
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.PaysService;
import streaming.service.RealisateurService;

/**
 *
 * @author admin
 */
public class RelationTest {

    DbService dbserv = new DbService();
    GenreService gserv = new GenreService();
    PaysService pserv = new PaysService();
    RealisateurService rserv = new RealisateurService();
    FilmService fserv = new FilmService();

    public void listerTousGenre() {
        System.out.println(gserv.listerTous());
    }

    public void listerFilmsChrono() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> films = em.createQuery("SELECT f FROM Film f ORDER BY f.annee").getResultList();
        System.out.println(films);
    }

    public void NbGenreEgal6OK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
//       List<Genre> genres = em.createQuery("SELECT g FROM Genre g").getResultList();
        Long nbGenre = (Long) em.createQuery("SELECT COUNT(g) FROM Genre g").getSingleResult();
        Assert.assertTrue(nbGenre == 6L);

    }

    public void ListeFilmsFrancaisEgal1OK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> films = em.createQuery("SELECT f FROM Film f JOIN f.pays p WHERE p.nom='France'").getResultList();
        Assert.assertEquals(1, films.size());

    }

    public void ListerFilmsFantastiqueAlphabOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> films = em.createQuery("SELECT f FROM Film f JOIN f.genre g WHERE g.nom='Fantastique' ORDER BY f.titre").getResultList();
        System.out.println(films);

    }

    public void ListerFilmsFantastiqueAlphabSansJoinOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f WHERE f.genre.nom = 'Fantastique' ORDER BY f.titre").getResultList();
        for (Film f : l) {
            System.out.println(f.getTitre());
        }
    }

    public void ListerComediesCohenParAnneeOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f JOIN f.realisateurs r WHERE r.prenom='Ethan' AND r.nom='Cohen' AND f.genre.nom='Comedie' ORDER BY f.annee").getResultList();
        for (Film f : l) {
            System.out.println(f.getTitre());
        }
    }

    public void ListerTousFilmsSaufActionOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f WHERE f.genre.nom <> 'Action'").getResultList();
        for (Film f : l) {
            System.out.println(f.getTitre());
        }

    }

    public void ListerFilmNeoZelandaisNonFantastiqueOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f WHERE f.pays.nom = 'Nouvelle-Zélande'AND f.genre.nom <> 'Fantastique'").getResultList();
        System.out.println(l.size());

    }

    public void NbFilmNeozFantastiquePeterJOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        Long l = (Long) em.createQuery("SELECT COUNT(f) FROM Film f JOIN f.genre g JOIN f.pays p JOIN f.realisateurs r WHERE g.nom = 'Fantastique' AND p.nom = 'Nouvelle-Zélande' AND r.nom = 'Jackson'").getSingleResult();
        System.out.println(l);
    }

    public void FilmCohenOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f JOIN f.realisateurs r WHERE r.nom = 'Cohen'AND r.prenom='Ethan' INTERSECT SELECT f FROM Film f JOIN f.realisateurs r WHERE r.nom = 'Cohen'AND r.prenom='Joel'").getResultList();
        for (Film f : l) {
            System.out.println(f.getTitre());
        }
    }

    public void FilmCohenSansIntersectOK() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<Film> l = em.createQuery("SELECT f FROM Film f WHERE f.id "
                + "IN(SELECT f.id FROM Film f JOIN f.realisateurs r WHERE r.nom = 'Cohen' AND r.prenom='Ethan')"
                + "AND f.id IN (SELECT f.id FROM Film f JOIN f.realisateurs r WHERE r.nom = 'Cohen' AND r.prenom='Joel')").getResultList();

        for (Film f : l) {
            System.out.println(f.getTitre());
        }
    }

   
    public void FilmLePlusAncienPeterJackson() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        List<String> l = em.createQuery("SELECT f.titre FROM Film f WHERE f.annee "
                + "IN(SELECT MIN(f.annee)FROM Film f JOIN f.realisateurs r WHERE r.nom = 'Jackson')").getResultList();
        for (String titre : l) {
            System.out.println(titre);

        }
    }

   
    public void AfficherMoyenneAnneeProd() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        Double moyenne = (Double) em.createQuery("SELECT AVG(f.annee) FROM Film f").getSingleResult();
         System.out.println(moyenne);       

    }
    
    @Test
    public void NbFilmsRealisespourChaqueReal(){
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        Collection<Object[]> c = em.createQuery("SELECT COUNT(f), r FROM Realisateur r JOIN r.films f GROUP BY r").getResultList();
        
        for (Object[] r : c){
            long total = (Long) r[0];
            Realisateur real = (Realisateur) r[1];
            
            System.out.println(real.getNom()+" "+total);
        
        }
      
    }

//    @Before
//    public void before() {
//        dbserv.supprierTout();
//    {
//        Genre g = new Genre();
//        g.setId(1L);
//        g.setNom("Action");
//        gserv.ajouter(g);
//
//    }
//
//    {
//        Genre g = new Genre();
//        g.setId(2L);
//        g.setNom("Fantastique");
//        gserv.ajouter(g);
//
//    }
//
//    {
//        Genre g = new Genre();
//        g.setId(3L);
//        g.setNom("Policier");
//        gserv.ajouter(g);
//    }
//
//    {
//        Genre g = new Genre();
//        g.setId(4L);
//        g.setNom("Romance");
//        gserv.ajouter(g);
//
//    }
//
//    {
//        Genre g = new Genre();
//        g.setId(5L);
//        g.setNom("Animation");
//        gserv.ajouter(g);
//    }
//
//    {
//        Genre g = new Genre();
//        g.setId(6L);
//        g.setNom("Comedie");
//        gserv.ajouter(g);
//
//    }
//
//    {
//        Pays p = new Pays();
//        p.setId(1L);
//        p.setNom("France");
//        pserv.ajouter(p);
//    }
//
//    {
//        Pays p = new Pays();
//        p.setId(2L);
//        p.setNom("USA");
//        pserv.ajouter(p);
//    }
//
//    {
//        Pays p = new Pays();
//        p.setId(3L);
//        p.setNom("UK");
//        pserv.ajouter(p);
//    }
//
//    {
//        Pays p = new Pays();
//        p.setId(4L);
//        p.setNom("Espagne");
//        pserv.ajouter(p);
//    }
//
//    {
//        Pays p = new Pays();
//        p.setId(5L);
//        p.setNom("Nouvelle-Zélande");
//        pserv.ajouter(p);
//    }
//
//    {
//        Realisateur r = new Realisateur();
//        r.setId(1L);
//        r.setPrenom("Joel");
//        r.setNom("Cohen");
//        rserv.ajouter(r);
//    }
//
//    {
//        Realisateur r = new Realisateur();
//        r.setId(2L);
//        r.setPrenom("Ethan");
//        r.setNom("Cohen");
//        rserv.ajouter(r);
//    }
//
//    {
//        Realisateur r = new Realisateur();
//        r.setId(3L);
//        r.setPrenom("Peter");
//        r.setNom("Jackson");
//        rserv.ajouter(r);
//    }
//
//    {
//        Realisateur r = new Realisateur();
//        r.setId(4L);
//        r.setPrenom("Quentin");
//        r.setNom("Tarantino");
//        rserv.ajouter(r);
//    }
//
//    {
//        Realisateur r = new Realisateur();
//        r.setId(5L);
//        r.setPrenom("Maîwenn");
//        r.setNom("");
//        rserv.ajouter(r);
//    }
//
//    {
//        Film f = new Film();
//        Genre g = gserv.rechercherParId(1L);
//        Pays p = pserv.rechercherParId(2L);
//        Realisateur r = rserv.rechercherParId(4L);
//
//        f.setId(1L);
//        f.setTitre("Django");
//        f.setAnnee(2012L);
//        f.setGenre(g);
//        f.setPays(p);
//        f.getRealisateurs().add(r);
//        fserv.ajouter(f);
//        g.getFilms().add(f);
//        p.getFilms().add(f);
//        r.getFilms().add(f);
//
//        fserv.modifier(f);
//        gserv.modifier(g);
//        pserv.modifier(p);
//        rserv.modifier(r);
//
//    }
//
//    {
//        Film f = new Film();
//        Genre g = gserv.rechercherParId(1L);
//        Pays p = pserv.rechercherParId(2L);
//        Realisateur r = rserv.rechercherParId(4L);
//
//        f.setId(2L);
//        f.setTitre("Kill Bill");
//        f.setAnnee(2003L);
//        f.setGenre(g);
//        f.setPays(p);
//        f.getRealisateurs().add(r);
//        fserv.ajouter(f);
//        g.getFilms().add(f);
//        p.getFilms().add(f);
//        r.getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(3L);
//        f.setTitre("Kill Bill 2");
//        f.setAnnee(2004L);
//        f.setGenre(gserv.rechercherParId(1L));
//        f.setPays(pserv.rechercherParId(2L));
//        f.getRealisateurs().add(rserv.rechercherParId(4L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(1L).getFilms().add(f);
//        pserv.rechercherParId(2L).getFilms().add(f);
//        rserv.rechercherParId(4L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(4L);
//        f.setTitre("Jackie Brown");
//        f.setAnnee(1997L);
//        f.setGenre(gserv.rechercherParId(1L));
//        f.setPays(pserv.rechercherParId(2L));
//        f.getRealisateurs().add(rserv.rechercherParId(4L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(1L).getFilms().add(f);
//        pserv.rechercherParId(2L).getFilms().add(f);
//        rserv.rechercherParId(4L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(5L);
//        f.setTitre("Sin City");
//        f.setAnnee(2005L);
//        f.setGenre(gserv.rechercherParId(2L));
//        f.setPays(pserv.rechercherParId(2L));
//        f.getRealisateurs().add(rserv.rechercherParId(4L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(2L).getFilms().add(f);
//        pserv.rechercherParId(2L).getFilms().add(f);
//        rserv.rechercherParId(4L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(6L);
//        f.setTitre("Bad Taste");
//        f.setAnnee(1987L);
//        f.setGenre(gserv.rechercherParId(2L));
//        f.setPays(pserv.rechercherParId(5L));
//        f.getRealisateurs().add(rserv.rechercherParId(3L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(2L).getFilms().add(f);
//        pserv.rechercherParId(5L).getFilms().add(f);
//        rserv.rechercherParId(3L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(7L);
//        f.setTitre("Braindead");
//        f.setAnnee(1992L);
//        f.setGenre(gserv.rechercherParId(2L));
//        f.setPays(pserv.rechercherParId(5L));
//        f.getRealisateurs().add(rserv.rechercherParId(3L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(2L).getFilms().add(f);
//        pserv.rechercherParId(5L).getFilms().add(f);
//        rserv.rechercherParId(3L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(8L);
//        f.setTitre("Le Hobbit");
//        f.setAnnee(2015L);
//        f.setGenre(gserv.rechercherParId(2L));
//        f.setPays(pserv.rechercherParId(5L));
//        f.getRealisateurs().add(rserv.rechercherParId(3L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(2L).getFilms().add(f);
//        pserv.rechercherParId(5L).getFilms().add(f);
//        rserv.rechercherParId(3L).getFilms().add(f);
//
//    }
//
//    {
//        Film f = new Film();
//        f.setId(9L);
//        f.setTitre("Polisse");
//        f.setAnnee(2011L);
//        f.setGenre(gserv.rechercherParId(3L));
//        f.setPays(pserv.rechercherParId(1L));
//        f.getRealisateurs().add(rserv.rechercherParId(5L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(3L).getFilms().add(f);
//        pserv.rechercherParId(1L).getFilms().add(f);
//        rserv.rechercherParId(5L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(10L);
//        f.setTitre("Big Lebowski");
//        f.setAnnee(1998L);
//        f.setGenre(gserv.rechercherParId(6L));
//        f.setPays(pserv.rechercherParId(2L));
//        f.getRealisateurs().add(rserv.rechercherParId(1L));
//        f.getRealisateurs().add(rserv.rechercherParId(2L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(6L).getFilms().add(f);
//        pserv.rechercherParId(2L).getFilms().add(f);
//        rserv.rechercherParId(1L).getFilms().add(f);
//        rserv.rechercherParId(2L).getFilms().add(f);
//    }
//
//    {
//        Film f = new Film();
//        f.setId(11L);
//        f.setTitre("Ave Cesar");
//        f.setAnnee(2016L);
//        f.setGenre(gserv.rechercherParId(6L));
//        f.setPays(pserv.rechercherParId(2L));
//        f.getRealisateurs().add(rserv.rechercherParId(1L));
//        f.getRealisateurs().add(rserv.rechercherParId(2L));
//        fserv.ajouter(f);
//        gserv.rechercherParId(6L).getFilms().add(f);
//        pserv.rechercherParId(2L).getFilms().add(f);
//        rserv.rechercherParId(1L).getFilms().add(f);
//        rserv.rechercherParId(2L).getFilms().add(f);
//    }
}

//    @Test
//    public void JPACreationTestOK() {
//        Persistence.createEntityManagerFactory("StreamingPU");
//        
//        System.out.println(gserv.rechercherParId(1L).getFilms().get(0).getTitre());
//
//    }

