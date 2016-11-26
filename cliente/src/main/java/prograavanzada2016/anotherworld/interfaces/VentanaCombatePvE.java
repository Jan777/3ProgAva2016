package prograavanzada2016.anotherworld.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.Entidad;
import prograavanzada2016.anotherworld.resources.Propiedades;
import prograavanzada2016.anotherworld.utilities.SonidoManager;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaCombatePvE extends javax.swing.JFrame{

    // these are the components we need.
    private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom
    private final JPanel inputPanel;      // under the text a container for all the input elements
    private final JTextField textField;   // a textField for the text the user inputs
    private JLabel lblNewLabel;
    private JLabel lblJugador;
    private JLabel lblAAtacar;
    private JLabel lblEnergia;
    private JLabel lblVida;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    
    private BattleScreen battleScreen;

    public VentanaCombatePvE(Entidad personaje, Entidad enemigo) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);/*Personaje personaje, Enemigo enemigo*/
    	battleScreen = new BattleScreen();
    	SonidoManager sm = SonidoManager.getInstance();
    	Propiedades prop = Propiedades.getInstance();
    	sm.stop();
    	sm.setMusic(prop.getProperty("battleTheme"));
    	sm.play();
    	setTitle("Combate");
    	Image image = new ImageIcon(Propiedades.getInstance().getProperty("IconoVentana")).getImage();
		setIconImage(image);

        splitPane = new JSplitPane();

        topPanel = new JPanel();
        bottomPanel = new JPanel();

        inputPanel = new JPanel();
        textField = new JTextField();    // first the input field where the user can type his text

        setPreferredSize(new Dimension(800, 600));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);

        // let's configure our splitPane:
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(450);
        splitPane.setTopComponent(topPanel);
        topPanel.setLayout(null);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(0, 0, 782, 449);
        lblNewLabel_1.setIcon(new ImageIcon(Propiedades.getInstance().getProperty("BackgroundCombate")));
        //topPanel.add(lblNewLabel_1);
        topPanel.add(battleScreen);
        splitPane.setBottomComponent(bottomPanel);


        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(inputPanel);

        // let's set the maximum size of the inputPanel, so it doesn't get too big when the user resizes the window
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        inputPanel.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(20, 29, 144, 20);
        //comboBox.addItem(enemigo.getNombre());
        inputPanel.add(comboBox);
        
        JLabel lblNombrePj = new JLabel("Batalla");
        lblNombrePj.setBounds(224, 11, 109, 20);
        inputPanel.add(lblNombrePj);
        
        lblNewLabel = new JLabel("Jugador 1:" ); //+ personaje.getNombre()
        lblNewLabel.setBounds(224, 29, 96, 20);
        inputPanel.add(lblNewLabel);
        
        lblJugador = new JLabel("Mounstro:" ); //+ enemigo.getNombre()
        lblJugador.setBounds(224, 46, 96, 20);
        inputPanel.add(lblJugador);
        
        lblAAtacar = new JLabel("A atacar:");
        lblAAtacar.setBounds(20, 3, 109, 20);
        inputPanel.add(lblAAtacar);
        
        lblEnergia = new JLabel("Energia");
        lblEnergia.setBounds(350, 11, 109, 20);
        inputPanel.add(lblEnergia);
        
        lblVida = new JLabel("Salud ");
        lblVida.setBounds(450, 11, 109, 20);
        inputPanel.add(lblVida);
        
        JButton btnAtacar = new JButton("Atacar");
        btnAtacar.setBackground(new Color(59, 89, 182));
	    btnAtacar.setForeground(Color.BLACK);
	    btnAtacar.setFocusPainted(false);
	    btnAtacar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAtacar.setBounds(640, 10, 130, 23);
        inputPanel.add(btnAtacar);
        
        JButton btnLanzarHechizo = new JButton("Lanzar Hechizo");
        btnLanzarHechizo.setBackground(new Color(59, 89, 182));
	    btnLanzarHechizo.setForeground(Color.BLACK);
	    btnLanzarHechizo.setFocusPainted(false);
	    btnLanzarHechizo.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLanzarHechizo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
				VentanaLanzarHechizo ventanaHechizo = null;
				try {
					ventanaHechizo = new VentanaLanzarHechizo();
				} catch (Exception e) {
					System.out.print("No se puede inicializar ventana de Lanzar Hechizo");
				}
				ventanaHechizo.setVisible(true);
				ventanaHechizo.setResizable(false);
				ventanaHechizo.setSize(new Dimension(400,280));
				ventanaHechizo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				ventanaHechizo.setLocationRelativeTo(null);
				
        	}
        });
        btnLanzarHechizo.setBounds(640, 44, 130, 23);
        inputPanel.add(btnLanzarHechizo);
        
        lblNewLabel_2 = new JLabel("New label1" ); //personaje.getEnergia()
        lblNewLabel_2.setBounds(349, 25, 155, 29);
        inputPanel.add(lblNewLabel_2);
        
        label = new JLabel("New label2" ); //enemigo.getEnergia()
        label.setBounds(350, 46, 155, 20);
        inputPanel.add(label);
        
        label_1 = new JLabel("New label3" ); //personaje.getSalud()
        label_1.setBounds(431, 25, 155, 29);
        inputPanel.add(label_1);
        
        label_2 = new JLabel("New label4"); // enemigo.getSalud()
        label_2.setBounds(432, 46, 155, 20);
        inputPanel.add(label_2);
        this.setResizable(false);
        pack();   // calling pack() at the end, will ensure that every layout and size we just defined gets applied before the stuff becomes visible
    }

   public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
            	VentanaCombatePvE frame;
				try {
					frame = new VentanaCombatePvE(null,null);
					 frame.setVisible(true);
		                frame.setLocationRelativeTo(null);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
            }
        });
    }
}