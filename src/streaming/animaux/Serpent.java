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
public class Serpent extends Animal{
    
    private int r = 0;

    @Override
    public void avance() {
//        System.out.println(" rampe ");   
       z++;
       if (r==0){
        x++;
        r++;  
       }        
       else{
           x--;   r=0;
       }
     
        
       
      
       
               
    }
    
}
