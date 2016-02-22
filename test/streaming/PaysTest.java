/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import streaming.entity.Client;
import streaming.entity.Genre;
import streaming.entity.Pays;
import streaming.entity.Realisateur;

/**
 *
 * @author admin
 */
public class PaysTest {

    /**
     *
     */
//    @BeforeClass 
//    public static void avantClasse() {
// @Before
// public void avantChaqueTest() {
//EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
//
//    em.getTransaction().begin();
//        
//    // Vide toutes les tables
//    
//    em.createQuery("DELETE FROM Genre g").executeUpdate();
//    em.createQuery("DELETE FROM Pays p").executeUpdate();
//    em.createQuery("DELETE FROM Realisateur r").executeUpdate();
//             
//        Genre g  = new Genre();
//        g.setNom("Animé");        
//        g.setId(1L);        
//        em.persist(g);
//        
//        g  = new Genre();
//        g.setNom("Action");        
//        g.setId(2L);        
//        em.persist(g);
//        
//        g  = new Genre();
//        g.setNom("Science Fiction");        
//        g.setId(3L);        
//        em.persist(g);
//        
//        Pays p = new Pays();
//        p.setNom("France");        
//        p.setId(1L);      
//        em.persist(p);
//        
//        p = new Pays();
//        p.setNom("USA");        
//        p.setId(2L);      
//        em.persist(p);
//        
//        p = new Pays();
//        p.setNom("Espagne");        
//        p.setId(3L);      
//        em.persist(p);
//        
//        Realisateur r = new Realisateur();     
//        r = new Realisateur();
//        r.setNom("Tarantino"); 
//        r.setPrenom("Quentin");
//        r.setId(1L);      
//        em.persist(r);
//        
//        r = new Realisateur();
//        r.setNom("Lucas"); 
//        r.setPrenom("George");
//        r.setId(2L);      
//        em.persist(r);
//        
//        r.setNom("Almodovar"); 
//        r.setPrenom("Pedro");
//        r.setId(3L);      
//        em.persist(r);
//        
//        em.getTransaction().commit();
// }
// @Test        
//public void verifNbTotalPaysEgala3() {
//
//EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
//        
//      int n = em.createQuery("SELECT p FROM Pays p").getResultList().size();
//      
//              Assert.assertTrue("blabla",n==3);
//  }            
    @Test
    public void testTab() {
        int[] nomTab = new int[10];

        int i = nomTab.length;

        for (i = 0; i < nomTab.length; i++) {

            nomTab[i] = i * 2;

        }
        for (int a : nomTab) {
            System.out.print(a+ " ");
        }
        
    }

//@Test
    public void testClient() {

        Client c = new Client("Aventin", "Agathe", 1550L, "24");

        System.out.println(c.toString());

    }

//@Test
//public void TarantinoIDEgala1() {
// EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
// Object l =  em.createQuery("SELECT r.id FROM Realisateur r WHERE r.nom = 'Tarantino'").getSingleResult();
// 
// 
// Assert.assertEquals(1L,l);
//}
}
