/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Genre;
import streaming.entity.Pays;
import streaming.entity.Realisateur;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        
        Query query = em.createQuery("SELECT r FROM Realisateur r WHERE r.prenom = 'Quentin'");
        List<Realisateur> l = query.getResultList();
        
        
        for (Realisateur r : l)  {
                   
            System.out.println (r.getPrenom() + " " + r.getNom());
            
          Query query1 = em.createQuery("SELECT g FROM Genre g WHERE g.nom <> 'Science Fiction'");
          List<Genre> lg = query1.getResultList();
          
          for (Genre g : lg)
            
              System.out.println(g.getNom());
        }
      
               
    
       
         
        
        
        // Ajoute un genre
        
//        em.getTransaction().begin();
//        
////        Pays pays = em.find(Pays.class, 1L);
////        
////        em.remove(pays);
////        
////        System.out.println(pays.getNom());
////        
////        pays.setNom("FRANCE");
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
//        r.setNom("Almodovar"); 
//        r.setPrenom("Pedro");
//        r.setId(3L);      
//        em.persist(r);
//        
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
//        em.getTransaction().commit();
//               }
    
    }}
