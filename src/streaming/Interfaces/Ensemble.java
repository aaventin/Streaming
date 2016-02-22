/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.Interfaces;

/**
 *
 * @author admin
 */
public class Ensemble implements Collection, Affichable {

    int nbElem = 0;
    Object[] tabOject = new Object[10];

    @Override
    public void ajouter(Object o) {

        boolean existe = false;
        int i = 0;

        while (existe == false && i < nbElem) {
            if (tabOject[i] == o) {
                existe = true;

            }
            i++;
        }

        if (existe == false) {
            tabOject[i] = o;
            nbElem++;
        }
    }

    @Override
    public int taille() {
        return nbElem;
    }

    @Override
    public Object getObject(int i) {
        return tabOject[i];
    }

    @Override
    public void afficher() {
       for(int i =0; i<nbElem; i++){            
            Object o = tabOject[i];
            System.out.println(o);
        }
    }
}
