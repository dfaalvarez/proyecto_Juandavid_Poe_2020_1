/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3_carreraRele;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Argenis Figueroa
 */
public class IzDerecha_P extends Thread {
    String nombre;
    JLabel label;
    DeIzquierda h1;
    boolean x = true;
    JTextArea oo;
   
    

    public IzDerecha_P(JLabel label, DeIzquierda h1, String nombre) {
        this.label = label;
        this.h1 = h1;
        this.nombre=nombre;
        
    }
    

    private synchronized void Verficar() throws InterruptedException {
        oo=new JTextArea();
        if (!h1.isAlive()) {
            long inicio = System.currentTimeMillis();
            while (label.getLocation().x > 5) {
                label.setLocation(label.getLocation().x - 10, label.getLocation().y);
               
                try {
                      System.out.println(nombre+ "llego ");
                    Thread.sleep(100);
                  
                } catch (InterruptedException ex) {
                    Logger.getLogger(DeIzquierda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            x = false;
         long fin = System.currentTimeMillis();
         
        long tiempo = (long) ((fin - inicio)/1000);
         
        System.out.println("nombre es: "+ nombre +" timepo es: " + tiempo +" segundos");
        }
    }

    @Override
    public void run() {
        
        while (x) {
            try {
                
                this.Verficar();
              
            } catch (InterruptedException ex) {
                Logger.getLogger(DeIzquierda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        

    }

   
     
     
             

}
