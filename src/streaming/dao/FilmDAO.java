/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmDAO {
    
    public void modifier (Film f){        
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
        
    }
    public void ajouter(Film f) {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }

    public Film rechercherParId(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();        
        return em.find(Film.class, id);        
    }

    public List<Film> listerTous() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();        
        return em.createQuery("SELECT e FROM Film f").getResultList();        
    }
    
}
