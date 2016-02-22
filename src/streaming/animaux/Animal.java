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
abstract public class Animal {

    private static int nbInstance = 0;

    public static int getNbInstance() {
        return nbInstance;
    }

    public static void setNbInstance(int nbInstance) {
        Animal.nbInstance = nbInstance;
    }

    protected int x = 0, y = 0, z = 0;

    public Animal() {
        nbInstance = nbInstance + 1;
    }

    public static int testNbInstance() {
        return nbInstance;
    }

    abstract public void avance();

    public void avance(int n) {

        for (int i = 0; i < n; i++) {
            avance();
        }
    }

//   public void comentAvance (){
//       System.out.println("avance");
//   }
//   
//     public void recule(int p){
//        y = y-p;  
//     }
//     
//     public void gauche(int p){
//        x = x-p;  
//     }
//     
//     public void droite(int p){
//        x = x+p;  
//     }
    public String toString() {
        return position();
    }

    public String position() {
        return this.getClass() + " " + ("x = " + x + " y = " + y + " z = " + z);
    }

}
