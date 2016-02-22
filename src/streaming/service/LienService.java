/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.LienDAO;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienService {
    
    LienDAO dao = new LienDAO();

    public void ajouter(Lien l) {
        dao.ajouter(l);
    }

    public Lien rechercherParId(Long id) {
        return dao.rechercherParId(id);
    }

    public List<Lien> listerTous() {
        return dao.listerTous();
    }
    
}
