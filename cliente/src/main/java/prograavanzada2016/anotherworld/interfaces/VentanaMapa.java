package prograavanzada2016.anotherworld.interfaces;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mapas.MapaViejoParaElRecuerdo;
import prograavanzada2016.anotherworld.modelos.*;
import prograavanzada2016.anotherworld.resources.Propiedades;
import prograavanzada2016.anotherworld.utilities.SonidoManager;

import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;

public class VentanaMapa extends JFrame {

	private JPanel jpPpal;
	private JPanel jpBarraEstado;
	private JLabel lblNivel;
	private JLabel lblPersonaje;
	private JLabel lblSalud;
	private JLabel lblEnergia;
	private JLabel lblMana;
	private JLabel lblFuerza;
	private JLabel lblDestreza;
	private JLabel lblInteligencia;
	private JLabel lblAlianza;
	private JButton btnCrearAlianza;
	private JButton btnMochila;
	private static Usuario user;
	public VentanaAlianza ventanaAlianza;
	public VentanaMochila ventanaMochila;
	private JInternalFrame internalFrame;
	private Canvas canvas;
	SonidoManager sm;
	
	public GameScreen game;

	public VentanaMapa(PersonajeModel personajeModel) throws Exception{
		Image image = new ImageIcon("src/main/resources/IconoVentana.jpg").getImage();
		Propiedades propiedades = Propiedades.getInstance();
		setIconImage(image);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMapa.class.getResource("src/main/resources/IconoVentana.jpg")));
		setTitle("AnotherWorld");
		setSize(900,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 554);
		jpPpal = new JPanel();
		jpPpal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpPpal);
		GridBagLayout gbl_jpPpal = new GridBagLayout();
		gbl_jpPpal.columnWidths = new int[]{324, 0};
		gbl_jpPpal.rowHeights = new int[]{75, 0, 0, 0};
		gbl_jpPpal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpPpal.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		jpPpal.setLayout(gbl_jpPpal);		
		setSize(900, 700);
		
		jpBarraEstado = new JPanel();
		GridBagConstraints gbc_jpBarraEstado = new GridBagConstraints();
		gbc_jpBarraEstado.fill = GridBagConstraints.BOTH;
		gbc_jpBarraEstado.insets = new Insets(0, 0, 5, 0);
		gbc_jpBarraEstado.gridx = 0;
		gbc_jpBarraEstado.gridy = 0;
		jpPpal.add(jpBarraEstado, gbc_jpBarraEstado);
		GridBagLayout gbl_jpBarraEstado = new GridBagLayout();
		gbl_jpBarraEstado.columnWidths = new int[]{0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 0};
		gbl_jpBarraEstado.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpBarraEstado.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpBarraEstado.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpBarraEstado.setLayout(gbl_jpBarraEstado);
		
		lblPersonaje = new JLabel("PJ: "+personajeModel.getNombre());
		GridBagConstraints gbc_lblPersonaje = new GridBagConstraints();
		gbc_lblPersonaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPersonaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonaje.gridx = 3;
		gbc_lblPersonaje.gridy = 0;
		jpBarraEstado.add(lblPersonaje, gbc_lblPersonaje);
		
		lblSalud = new JLabel("Salud: 100%");
		GridBagConstraints gbc_lblSalud = new GridBagConstraints();
		gbc_lblSalud.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSalud.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalud.gridx = 4;
		gbc_lblSalud.gridy = 0;
		jpBarraEstado.add(lblSalud, gbc_lblSalud);
		
		btnMochila = new JButton("Mochila");
		btnMochila.setBackground(new Color(59, 89, 182));
		btnMochila.setForeground(Color.BLACK);
		btnMochila.setFocusPainted(false);
		btnMochila.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMochila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ventanaMochila = new VentanaMochila();
				} catch (Exception e) {
					System.out.print("No se puede inicializar ventana de Mochila");
				}
				ventanaMochila.setVisible(true);
				ventanaMochila.setResizable(false);
				ventanaMochila.setSize(new Dimension(420,300));
				ventanaMochila.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Point p = MouseInfo.getPointerInfo().getLocation();
				int x = p.x;
				int y= p.y;
				ventanaMochila.setLocation(x,y);			
			}
		});
		
		lblFuerza = new JLabel("Fuerza:");
		GridBagConstraints gbc_lblFuerza = new GridBagConstraints();
		gbc_lblFuerza.anchor = GridBagConstraints.WEST;
		gbc_lblFuerza.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuerza.gridx = 19;
		gbc_lblFuerza.gridy = 0;
		jpBarraEstado.add(lblFuerza, gbc_lblFuerza);
		GridBagConstraints gbc_btnMochila = new GridBagConstraints();
		gbc_btnMochila.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMochila.insets = new Insets(0, 0, 5, 0);
		gbc_btnMochila.gridx = 45;
		gbc_btnMochila.gridy = 0;
		jpBarraEstado.add(btnMochila, gbc_btnMochila);
		
		lblNivel = new JLabel("Nivel 1");
		GridBagConstraints gbc_lblNivel = new GridBagConstraints();
		gbc_lblNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNivel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivel.gridx = 3;
		gbc_lblNivel.gridy = 1;
		jpBarraEstado.add(lblNivel, gbc_lblNivel);
		
		lblEnergia = new JLabel("Energ\u00EDa: 100%");
		GridBagConstraints gbc_lblEnergia = new GridBagConstraints();
		gbc_lblEnergia.anchor = GridBagConstraints.WEST;
		gbc_lblEnergia.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergia.gridx = 4;
		gbc_lblEnergia.gridy = 1;
		jpBarraEstado.add(lblEnergia, gbc_lblEnergia);
		
		lblDestreza = new JLabel("Destreza:");
		GridBagConstraints gbc_lblDestreza = new GridBagConstraints();
		gbc_lblDestreza.anchor = GridBagConstraints.WEST;
		gbc_lblDestreza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestreza.gridx = 19;
		gbc_lblDestreza.gridy = 1;
		jpBarraEstado.add(lblDestreza, gbc_lblDestreza);
		
		btnCrearAlianza = new JButton("Crear Alianza");
		btnCrearAlianza.setBackground(new Color(59, 89, 182));
		btnCrearAlianza.setForeground(Color.BLACK);
		btnCrearAlianza.setFocusPainted(false);
		btnCrearAlianza.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearAlianza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAlianza ventanaAlianza = null;
				try {
					ventanaAlianza = new VentanaAlianza();
				} catch (Exception e) {
					System.out.print("No se puede inicializar ventana de Alianza");
				}
				ventanaAlianza.setVisible(true);
				ventanaAlianza.setResizable(false);
				ventanaAlianza.setSize(new Dimension(400,280));
				ventanaAlianza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Point p = MouseInfo.getPointerInfo().getLocation();
				int x = p.x;
				int y= p.y;
				ventanaAlianza.setLocation(x,y);	
				
			}
		});
		GridBagConstraints gbc_btnCrearAlianza = new GridBagConstraints();
		gbc_btnCrearAlianza.anchor = GridBagConstraints.WEST;
		gbc_btnCrearAlianza.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearAlianza.gridx = 45;
		gbc_btnCrearAlianza.gridy = 1;
		jpBarraEstado.add(btnCrearAlianza, gbc_btnCrearAlianza);
		
		lblAlianza = new JLabel("(Alianza)");
		GridBagConstraints gbc_lblAlianza = new GridBagConstraints();
		gbc_lblAlianza.anchor = GridBagConstraints.WEST;
		gbc_lblAlianza.insets = new Insets(0, 0, 0, 5);
		gbc_lblAlianza.gridx = 3;
		gbc_lblAlianza.gridy = 2;
		jpBarraEstado.add(lblAlianza, gbc_lblAlianza);
		
		lblMana = new JLabel("Man\u00E1: 100%");
		GridBagConstraints gbc_lblMana = new GridBagConstraints();
		gbc_lblMana.anchor = GridBagConstraints.WEST;
		gbc_lblMana.insets = new Insets(0, 0, 0, 5);
		gbc_lblMana.gridx = 4;
		gbc_lblMana.gridy = 2;
		jpBarraEstado.add(lblMana, gbc_lblMana);
		
		lblInteligencia = new JLabel("Inteligencia:");
		GridBagConstraints gbc_lblInteligencia = new GridBagConstraints();
		gbc_lblInteligencia.anchor = GridBagConstraints.WEST;
		gbc_lblInteligencia.insets = new Insets(0, 0, 0, 5);
		gbc_lblInteligencia.gridx = 19;
		gbc_lblInteligencia.gridy = 2;
		jpBarraEstado.add(lblInteligencia, gbc_lblInteligencia);
		
		internalFrame = new JInternalFrame();
		internalFrame.setBorder(null);
		internalFrame.setFrameIcon(null);
		GridBagConstraints gbc_internalFrame = new GridBagConstraints();
		gbc_internalFrame.insets = new Insets(0, 0, 5, 0);
		gbc_internalFrame.gridx = 0;
		gbc_internalFrame.gridy = 1;
		jpPpal.add(internalFrame, gbc_internalFrame);
		
		game = new GameScreen("prueba", 800, 550);
		internalFrame.getContentPane().add(game.getCanvas());
		internalFrame.setVisible(true);
		
		//internalFrame.getContentPane().add(game.getCanvas(), BorderLayout.NORTH);
		//internalFrame.add(game.getCanvas());
		setVisible(true);
		sm = SonidoManager.getInstance();
		sm.stop();
		sm.setMusic(propiedades.getProperty("mapTheme"));
		sm.play();
	}

}