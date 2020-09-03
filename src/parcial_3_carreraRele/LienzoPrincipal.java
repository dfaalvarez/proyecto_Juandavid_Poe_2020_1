/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3_carreraRele;

//import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
//import javax.swing.BoxLayout;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//import jdk.nashorn.internal.ir.Labels;

/**
 *
 * @author home
 */
public class LienzoPrincipal implements ActionListener {

    //---------------------
    JFrame lienzo;
    JPanel[] panls;
//    JPanel panelPp;
    JLabel[] labls;
    JTextField[] textsF;
    JTextArea[] textsA;
//    JCalendar calendar;
    JComboBox[] combs;
    JRadioButton[] rads;
    TitledBorder[] bnombs;
    JButton[] buttons;
    Border[] bcolors;
    Boolean selec;

    //--------------------
    public JPanel paneltitle() {
        panls[2] = new JPanel();
        panls[2].setLayout(new FlowLayout());
        //-------------------------------------------
        labls[0] = new JLabel();
        labls[0].setText("¡Corramos!");
        labls[0].setFont(new java.awt.Font("Tahoma", 1, 20));//tipo de letra
        //-------------------------------------
        panls[2].add(labls[0]);
        return panls[2];
    }

    //--------------------
    public JPanel panelcontroles() {
//        lnombre.setFont(new java.awt.Font("Tahoma", 1, 20));//tipo de letra
//        lnombre.setForeground(new java.awt.Color(255, 255, 255));
        //-------------------
        panls[1] = new JPanel(); //instanciamos el JPanel
        panls[1].setName("pBotones");
//        panls[1].setLayout(new BoxLayout(panls[1], BoxLayout.X_AXIS));
        panls[1].setLayout(new FlowLayout());
        bnombs[0] = BorderFactory.createTitledBorder(bcolors[0], " Panel Botones", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        panls[1].setBorder(bnombs[0]);
        //--------------------
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            if (i == 0) {
                buttons[i].setText("iniciar");
            } else if (i == 1) {
                buttons[i].setText("pausar");
            } else if (i == 2) {
                buttons[i].setText("reiniciar");
            }
            buttons[i].addActionListener(this);
            panls[1].add(buttons[i]);
        }
        //--------------------

        //---------------
//        panls[1].setVisible(true);
        return panls[1];
    }

    public JPanel panelcarrera() {
//        lnombre.setFont(new java.awt.Font("Tahoma", 1, 20));//tipo de letra
//        lnombre.setForeground(new java.awt.Color(255, 255, 255));
        //-------------------
        panls[0] = new JPanel(); //instanciamos el JPanel
        panls[0].setName("pdatosParticipante");
        panls[0].setLayout(new BorderLayout());
        JPanel panlI[] = new JPanel[2];
        for (int i = 0; i < 2; i++) {
            panlI[i] = new JPanel();
        }
        panlI[0].setLayout(new GridLayout(4, 0));
        panlI[1].setLayout(new GridLayout(0, 1));
        bnombs[0] = BorderFactory.createTitledBorder(bcolors[0], "Panel Carrera", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        bnombs[1] = BorderFactory.createTitledBorder(bcolors[0], "Tiempo", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        bnombs[2] = BorderFactory.createTitledBorder(bcolors[0], "Puntos", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        panls[0].setBorder(bnombs[0]);
//        //--------------------
        for (int i = 1; i < 3; i++) {
            labls[i] = new JLabel(" " + 0);
            labls[i].setHorizontalAlignment(SwingConstants.CENTER);
            labls[i].setFont(new java.awt.Font("Arial", 1, 70));//tipo de letra
            if (i == 1) {
                labls[i].setBorder(bnombs[i]);
            } else {
                labls[i].setBorder(bnombs[i]);
            }

        }
        for (int i = 1; i < 3; i++) {
            panlI[1].add(labls[i]);
        }
        //-----------------------------
        ImageIcon corredor = new ImageIcon(getClass().getResource("/imagenes/runner.png"));
        ImageIcon coredorImg = new ImageIcon(corredor.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        ImageIcon black = new ImageIcon(getClass().getResource("/imagenes/black.png"));
        ImageIcon blackImg = new ImageIcon(black.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        for (int i = 3; i < 59; i++) {
            labls[i] = new JLabel();
            labls[i].setHorizontalAlignment(SwingConstants.CENTER);
            System.out.println("Entro");
            if (i == 4 || i == 18 || i == 32 || i == 46 || i == 15 || i == 29 || i == 43 || i == 57) {
                labls[i].setIcon(blackImg);
            } else {
                if (i != 16 && i != 30 && i != 44 && i != 58) {
                    labls[i].setVisible(false);
                }
                labls[i].setIcon(coredorImg);
            }
        }
        for (int i = 3; i < 59; i++) {
            panlI[0].add(labls[i]);
        }
        //------------------------------
        for (int i = 0;
                i < 2; i++) {
            if (i == 0) {
                panls[0].add(panlI[i], BorderLayout.CENTER);
            } else {
                panls[0].add(panlI[i], BorderLayout.EAST);
            }
        }
        //---------------

        //---------------
//        panls[0].setVisible(true);
        return panls[0];
    }

    public JPanel crearPprincipal() {
        JPanel panelPp = new JPanel(new BorderLayout());
        panls = new JPanel[4];
        bnombs = new TitledBorder[6];
        bcolors = new Border[2];
        combs = new JComboBox[2];
//        rads = new JRadioButton[4];
        bcolors[0] = BorderFactory.createLineBorder(Color.BLACK);
        bcolors[1] = BorderFactory.createLineBorder(Color.RED);
        labls = new JLabel[70];
        textsF = new JTextField[4];
        textsA = new JTextArea[2];
        buttons = new JButton[4];
        rads = new JRadioButton[2];
        panelPp.add(paneltitle(), BorderLayout.NORTH);
        panelPp.add(panelcontroles(), BorderLayout.SOUTH);
        panelPp.add(panelcarrera(), BorderLayout.CENTER);
        return panelPp;
    }

    public void inVentana() {
        lienzo = new JFrame("Parcial 3 poe");
//        lienzo.pack();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image miIcono = toolkit.getImage("src/imagenes/icono.png");//ruta icono
        lienzo.setIconImage(miIcono);
        lienzo.setLayout(new FlowLayout());
        lienzo.setTitle("Parcial 3 poe");
        lienzo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lienzo.setSize(new Dimension(1050, 550));
        lienzo.setLocationRelativeTo(null);
        lienzo.setContentPane(crearPprincipal());
        lienzo.setVisible(true);
    }

    public LienzoPrincipal() {
        inVentana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
