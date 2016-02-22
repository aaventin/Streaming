/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {
    
    GenreDAO dao = new GenreDAO();
    
    public void modifier (Genre g){ 
       dao.modifier(g);
     }

    public void ajouter(Genre g) {
        dao.ajouter(g);
    }

    public Genre rechercherParId(Long id) {
        return dao.rechercherParId(id);
    }

    public List<Genre> listerTous() {
        return dao.listerTous();
    }
    
}
