package prograavanzada2016.anotherworld.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import prograavanzada2016.anotherworld.user.*;
import java.awt.Toolkit;

public class VentanaMapa extends JFrame {

	private JPanel jpPpal;
	private JPanel jpBarraEstado;
	private JPanel jpMapa;
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

	public VentanaMapa(Usuario s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMapa.class.getResource("/interfaz/IconoVentana.jpg")));
		setTitle("AnotherWorld");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 554);
		jpPpal = new JPanel();
		jpPpal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpPpal);
		GridBagLayout gbl_jpPpal = new GridBagLayout();
		gbl_jpPpal.columnWidths = new int[]{324, 0};
		gbl_jpPpal.rowHeights = new int[]{75, 0, 0};
		gbl_jpPpal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpPpal.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		jpPpal.setLayout(gbl_jpPpal);
		
		jpBarraEstado = new JPanel();
		GridBagConstraints gbc_jpBarraEstado = new GridBagConstraints();
		gbc_jpBarraEstado.fill = GridBagConstraints.BOTH;
		gbc_jpBarraEstado.insets = new Insets(0, 0, 5, 0);
		gbc_jpBarraEstado.gridx = 0;
		gbc_jpBarraEstado.gridy = 0;
		jpPpal.add(jpBarraEstado, gbc_jpBarraEstado);
		GridBagLayout gbl_jpBarraEstado = new GridBagLayout();
		gbl_jpBarraEstado.columnWidths = new int[]{0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 0};
		gbl_jpBarraEstado.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpBarraEstado.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpBarraEstado.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpBarraEstado.setLayout(gbl_jpBarraEstado);
		
		lblPersonaje = new JLabel("(Nombre Pj)");
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
		btnMochila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMochila ventanaMochila = new VentanaMochila();
				ventanaMochila.setVisible(true);
				ventanaMochila.setSize(new Dimension(500,300));
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
		gbc_lblFuerza.gridx = 7;
		gbc_lblFuerza.gridy = 0;
		jpBarraEstado.add(lblFuerza, gbc_lblFuerza);
		
		JButton btnCombate = new JButton("Combatir");
		GridBagConstraints gbc_btnCombate = new GridBagConstraints();
		gbc_btnCombate.fill = GridBagConstraints.BOTH;
		gbc_btnCombate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCombate.gridx = 14;
		gbc_btnCombate.gridy = 0;
		jpBarraEstado.add(btnCombate, gbc_btnCombate);
		GridBagConstraints gbc_btnMochila = new GridBagConstraints();
		gbc_btnMochila.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMochila.insets = new Insets(0, 0, 5, 5);
		gbc_btnMochila.gridx = 15;
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
		
		btnCrearAlianza = new JButton("Crear Alianza");
		btnCrearAlianza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAlianza ventanaAlianza = new VentanaAlianza();
				ventanaAlianza.setVisible(true);
				ventanaAlianza.setSize(new Dimension(500,300));
				Point p = MouseInfo.getPointerInfo().getLocation();
				int x = p.x;
				int y= p.y;
				ventanaAlianza.setLocation(x,y);	
				
			}
		});
		
		lblDestreza = new JLabel("Destreza:");
		GridBagConstraints gbc_lblDestreza = new GridBagConstraints();
		gbc_lblDestreza.anchor = GridBagConstraints.WEST;
		gbc_lblDestreza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestreza.gridx = 7;
		gbc_lblDestreza.gridy = 1;
		jpBarraEstado.add(lblDestreza, gbc_lblDestreza);
		GridBagConstraints gbc_btnCrearAlianza = new GridBagConstraints();
		gbc_btnCrearAlianza.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrearAlianza.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearAlianza.gridx = 14;
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
		gbc_lblInteligencia.gridx = 7;
		gbc_lblInteligencia.gridy = 2;
		jpBarraEstado.add(lblInteligencia, gbc_lblInteligencia);
		
		jpMapa = new JPanel();
		jpMapa.setBackground(Color.BLACK);
		GridBagConstraints gbc_jpMapa = new GridBagConstraints();
		gbc_jpMapa.fill = GridBagConstraints.BOTH;
		gbc_jpMapa.gridx = 0;
		gbc_jpMapa.gridy = 1;
		//jpMapa.setSize(1000, 1000);
		jpPpal.add(jpMapa, gbc_jpMapa);
	}
}