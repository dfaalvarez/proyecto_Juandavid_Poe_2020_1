package parcial_3_carreraRele;



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class DeIzquierda_P extends Thread  {
    String nombre1;
    JLabel label;
    IzDerecha h1;
    long tiempo;
    boolean x = true;

    public DeIzquierda_P(JLabel label, IzDerecha h1, String nombre1) {
        this.label = label;
        this.h1 = h1;
        this.nombre1=nombre1;
        
    }

    

    private synchronized void Verficar() throws InterruptedException {
        if (!h1.isAlive()) {
            while (label.getLocation().x < 765) {
                label.setLocation(label.getLocation().x + 10, label.getLocation().y);
             
                try {
                    System.out.println(nombre1+ "llego ");
                   Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DeIzquierda_P.class.getName()).log(Level.SEVERE, null, ex);
                     System.out.println(nombre1+ "llego ");
                }
             
            }
            x = false;
        }

    }

    @Override
    public void run() {

        if (h1 != null) {
            while (x) {
                try {
                    this.Verficar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(DeIzquierda_P.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            
            while (label.getLocation().x < 765) {
                //System.out.println(label.getLocation().x);
                label.setLocation(label.getLocation().x + 10, label.getLocation().y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DeIzquierda_P.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
