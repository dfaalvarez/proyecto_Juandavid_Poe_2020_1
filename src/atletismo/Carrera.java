
package atletismo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;





public class Carrera extends JFrame implements ActionListener {

    private JPanel PSur, PEste, POeste, PCentro;
    private JButton Biniciar, BFinalizar, BPausar, B1, B2, B3, B4;
    private JTextArea Ejercicio;
    private JScrollPane Scroll;
    private JLabel Incrementa, Decrementa, Hasta;
    private JTextField JAsta;
    Hilo Hilo_1;
    Hilo Hilo_2;
    CompararHilos Comparador_Hilos;
    
    
    public Carrera(){
        
        Ventana();
        
        
        
        
    }
    
    
    
    private JPanel setPSur(){
        
        PSur= new JPanel();
           
        PSur.setName("PSur");
        PSur.setLayout(new FlowLayout());
        PSur.setBackground(new Color(234, 107, 0));
       
        Biniciar = new JButton("Inicio");
        BPausar = new JButton("Pausar");
        BFinalizar = new JButton("Terminar");
       
        BPausar.setVisible(false);
        BFinalizar.setVisible(false);
        //Le ponemos oidos
        Biniciar.addActionListener(this);
        BPausar.addActionListener(this);
        BFinalizar.addActionListener(this);
        //asignamos los botones
        PSur.add(Biniciar);
        PSur.add(BPausar);
        PSur.add(BFinalizar);
        add(PSur);
        return PSur;
    }

    private JPanel setPEste() {
        PEste = new JPanel();
        PEste.setName("Panel Este");
        PEste.setLayout(new BoxLayout(PEste, BoxLayout.Y_AXIS));
        PEste.setBackground(new Color(0, 154, 37));
        
        B1 = new JButton("1");
        B2 = new JButton("2");
        B3 = new JButton("3");
        B4 = new JButton("4");
        
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        
        PEste.add(B1);
        PEste.add(B2);
        PEste.add(B3);
        PEste.add(B4);
        add(PEste);
        return PEste;
    }

    private JPanel setPanelCentro() {
        PCentro = new JPanel();
        PCentro.setName("Panel Centro");
        PCentro.setLayout(new GridLayout(0, 2, 10, 10));
        PCentro.setBackground(new Color(244, 230, 107));
        Incrementa = new JLabel(" " + 0);
        Decrementa = new JLabel(" " + 0);
        Hasta = new JLabel("Hasta: ");
        JAsta = new JTextField();
        Incrementa.setFont(new java.awt.Font("Arial", 1, 100));//tipo de letra
        Decrementa.setFont(new java.awt.Font("Arial", 1, 100));//tipo de letra
        JAsta.setFont(new java.awt.Font("Arial", 1, 30));//tipo de letra
        JAsta.setFont(new java.awt.Font("Arial", 1, 30));//tipo de letra
        PCentro.add(Incrementa);
        PCentro.add(Decrementa);
        PCentro.add(Hasta);
        PCentro.add(Hasta);
        add(PCentro);
        return PCentro;
    }

    private void Ventana() {
        setName("Ventana Principal");
        setTitle("Incremento y Decremento");
        pack();
        setSize(new Dimension(800, 250));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(setPSur(), BorderLayout.SOUTH);
        getContentPane().add(setPEste(), BorderLayout.EAST);
        getContentPane().add(setPCentro(), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(Biniciar)) {
            Hilo_1 = new Hilo();
            Hilo_2 = new Hilo();
            Comparador_Hilos = new CompararHilos(Hilo_1, Hilo_2);
            Hilo_1.setHasta(Integer.parseInt(jthasta.getText()));
            Hilo_2.setHasta(Integer.parseInt(jthasta.getText()));
            Hilo_1.setLabel(Incrementa);
            Hilo_1.setIncrementa(true);
            Hilo_2.setLabel(Decrementa);
            Hilo_2.setDecrementa(true);
            Hilo_1.setBandera(true);
            Hilo_2.setBandera(true);
            Comparador_Hilos.setBandera(true);
            Hilo_1.start();
            Hilo_2.start();
            Comparador_Hilos.start();
            BPausar.setVisible(true);
            BFinalizar.setVisible(true);
            Biniciar.setVisible(false);
        }
        if (e.getSource().equals(BPausar)) {
            if (BPausar.getText().equals("Pausar")) {
                Hilo_1.suspend();
                Hilo_2.suspend();
                Comparador_Hilos.suspend();
                BPausar.setText("Reanudar");
            } else {
                Hilo_1.resume();
                Hilo_2.resume();
                Comparador_Hilos.resume();
                BPausar.setText("Pausar");
            }
        }
        if (e.getSource().equals(BFinalizar)) {
            Hilo_1.stop();
            Hilo_2.stop();
            Decrementa.setText(" " + 0);
            Incrementa.setText(" " + 0);
            Hilo_1.setBandera(false);
            Hilo_2.setBandera(false);
            Comparador_Hilos.setBandera(false);
            BPausar.setText("Pausar");
            BPausar.setVisible(false);
            BFinalizar.setVisible(false);
            Biniciar.setVisible(true);
        }
        if (e.getSource().equals(B1)) {
            Hilo_1.setVelocidad(1);
            Hilo_2.setVelocidad(1);
            Comparador_Hilos.setVelocidad(1);
        } else if (e.getSource().equals(B2)) {
            Hilo_1.setVelocidad(2);
            Hilo_2.setVelocidad(2);
            Comparador_Hilos.setVelocidad(2);
        } else if (e.getSource().equals(B3)) {
            Hilo_1.setVelocidad(3);
            Hilo_2.setVelocidad(3);
            Comparador_Hilos.setVelocidad(3);
        } else if (e.getSource().equals(B4)) {
            Hilo_1.setVelocidad(4);
            Hilo_2.setVelocidad(4);
            Comparador_Hilos.setVelocidad(4);
        }
    }

    private Component setPCentro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
    }
    
    
