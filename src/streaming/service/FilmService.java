/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {

    FilmDAO dao = new FilmDAO();
    
    public void modifier (Film f){
        dao.modifier(f);
    }   

    public void ajouter(Film f) {
        dao.ajouter(f);
    }

    public Film rechercherParId(Long id) {
        return dao.rechercherParId(id);
    }

    public List<Film> listerTous() {
        return dao.listerTous();
    }

}
