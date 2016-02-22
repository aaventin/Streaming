/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.animaux;

/**
 *
 * @author admin
 */
public class Oiseau extends Animal {

    @Override
    public void avance() {
         //System.out.println(" vole ");
        y++;
        z++;
    }

}
