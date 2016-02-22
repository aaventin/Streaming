/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienDAO {
    
    public void modifier (Lien l){        
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
        
    }
    
    public void ajouter(Lien l) {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }

    public Lien rechercherParId(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();        
        return em.find(Lien.class, id);        
    }

    public List<Lien> listerTous() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();        
        return em.createQuery("SELECT e FROM Lien l").getResultList();        
    }
    
}
