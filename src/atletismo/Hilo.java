
package atletismo;

import java.awt.Toolkit;
import javax.swing.JLabel;










public class Hilo extends Thread {

 private int velocidad, hasta, intDec, intIncre;
    private JLabel label;
    private boolean incrementar, decrementar, bandera;

    public Hilo() {
        this.velocidad = 1000;
        this.hasta = 100;
        //intDec = hasta;
        intIncre = 0;
        incrementar=false;
        decrementar=false;
    }

    public Hilo(int velocidad, int hasta, JLabel label) {
        velocidad = velocidad * 1000;
        this.velocidad = velocidad;
        this.label = label;
        this.hasta = hasta;
        intDec = hasta;
        intIncre = 0;
        incrementar=false;
        decrementar=false;
    }

   
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Método que asigna la velocidad del Hilo
     *
     * @param velocidad La velocidad esta dada en segundos
     */
    public void setVelocidad(int velocidad) {
        velocidad = velocidad * 1000;
        this.velocidad = velocidad;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public boolean isIncrementar() {
        return incrementar;
    }

    public void setIncrementar(boolean incrementar) {
        this.incrementar = incrementar;
    }

    public boolean isDecrementar() {
        return decrementar;
    }

    public void setDecrementar(boolean decrementar) {
        this.decrementar = decrementar;
    }

   
    public boolean isBandera() {
        return bandera;
    }

   
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

   
    public int getIntDec() {
        return intDec;
    }

    private void setIntDec(int intDec) {
        this.intDec = intDec;
    }

  
    public int getIntIncre() {
        return intIncre;
    }

    private void setIntIncre(int intIncre) {
        this.intIncre = intIncre;
    }
   
    public void run() {
        intDec=hasta;
        while (bandera) {
            if (incrementar) {
                label.setText(" " + (intIncre++));
                if (intIncre == (hasta)) {
                    break;
                }
            } else if (decrementar) {
                label.setText(" " + (intDec--));
                if (intDec == 0) {
                    break;
                }
            }
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException e) {
            }
        }
        label.setText(" " + 0);
    }
}    