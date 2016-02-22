/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

import org.junit.Test;
import static org.junit.Assert.*;
import streaming.Interfaces.Ensemble;
import streaming.Interfaces.Liste;
import streaming.animaux.Animal;
import streaming.animaux.Oiseau;
import streaming.animaux.Poisson;
import streaming.animaux.Serpent;
import streaming.animaux.Terminal;
import streaming.enumeration.TypeUtil;

/**
 *
 * @author admin
 */
public class ObjetTest {
    
    @Test
    public void testEnum(){
        
        TypeUtil tu = TypeUtil.MODERATEUR;
        if (tu == TypeUtil.MODERATEUR){
            System.out.println("streaming.ObjetTest.testEnum()");
        }
        
    }

    //@Test
    public void testTab() {
        Animal[] tab = new Animal[5];
        tab[0] = new Serpent();
        tab[1] = new Serpent();
        tab[2] = new Oiseau();
        tab[3] = new Oiseau();
        tab[4] = new Poisson();

        tab[0].avance();

        for (Animal a : tab) {
            a.avance();

            System.out.println(a);
        }
    }

    //@Test
    public void test2() {
        Terminal t = Terminal.creation();
        Terminal t1 = Terminal.creation();
        System.out.println(t + " " + t1);
    }

//    @Test
    public void testSerpent() {
        Serpent s = new Serpent();
        s.avance();
        System.out.println(s);
        s.avance();
        System.out.println(s);
        s.avance();
        System.out.println(s);
    }

//    @Test
    public void testEnsemble() {
        

        Ensemble e = new Ensemble();

        e.ajouter(10L);

        e.ajouter(15L);

        e.afficher();
    }
    
//    @Test
    public void testListe() {
        

        Liste l = new Liste();

        l.ajouter(17L);

        l.ajouter(45L);

        l.afficher();
    }

//     @Test
    public void testOiseau() {
        Oiseau o = new Oiseau();

        o.avance();

        System.out.println(o);
    }

    //@Test
    public void test1() {

//        Animal a = new Animal();
//
//        a.avance(2);
//        a.recule(2);
//        a.gauche(2);
//        a.droite(2);

//        System.out.print(a);
    }
}
