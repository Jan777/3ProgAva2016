package prograavanzada2016.anotherworld.interfaces;

import java.util.Properties;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;

public class VentanaCrearPersonaje extends JFrame {
	
	VentanaMapa ventanaMapaJuego;
	
	static Properties propiedades;
	static PropertiesFile pf;
	
	private String nombrePersonaje;
	private String razaPersonaje;
	private String castaPersonaje;
	private JPanel contentPane;
	private JTextField textField;
	private Usuario usuario;
	
	private JComboBox comboRaza;
	private JComboBox comboCasta;
	private JButton btnCrear;
	
	Personaje personaje;
	
	public VentanaCrearPersonaje(Usuario user){
		initComponents();   
		usuario = user;
		}

	public void initComponents() {
		pf = new PropertiesFile();
		propiedades = pf.getProperties();
		setSize(Integer.parseInt(propiedades.getProperty("w")),Integer.parseInt(propiedades.getProperty("h")));
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\src\\interfaz\\IconoVentana.jpg"));
		setTitle("Crear Personaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del personaje");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(131, 37, 145, 50);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				textFieldFocusLost(evt);
			}
		});
		textField.setBounds(313, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setForeground(new Color(255, 255, 255));
		lblRaza.setBounds(131, 98, 44, 14);
		contentPane.add(lblRaza);
		
		comboRaza = new JComboBox();
		comboRaza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				comboRazaFocusLost(e);
			}
		});
		comboRaza.setBounds(313, 95, 86, 20);
		
		comboRaza.addItem("Humano");
		comboRaza.addItem("Orco");
		
		contentPane.add(comboRaza);
		
		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setForeground(new Color(255, 255, 255));
		lblCasta.setBounds(131, 146, 44, 14);
		contentPane.add(lblCasta);
		
		comboCasta = new JComboBox();
		comboCasta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				comboCastaFocusLost(e);
			}
		});
		comboCasta.setBounds(313, 143, 86, 20);
		
		comboCasta.addItem("Guerrero");
		comboCasta.addItem("Mago");
		comboCasta.addItem("Curandero");
		
		contentPane.add(comboCasta);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBackground(new Color(59, 89, 182));
	    btnCrear.setForeground(Color.BLACK);
	    btnCrear.setFocusPainted(false);
	    btnCrear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCrearActionPerformed(evt);
			}
		});
		btnCrear.setBounds(313, 206, 89, 23);
		contentPane.add(btnCrear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaCrearPersonaje.class.getResource("/prograavanzada2016/anotherworld/interfaces/BackgroundCrearPersonaje.jpeg")));
		label.setBounds(0, 0, 784, 561);
		contentPane.add(label);
		
	}
	
	public void textFieldFocusLost(FocusEvent evt){
		//personaje.setNombrePersonaje(textField.getText());
	}
	
	public void comboRazaFocusLost(FocusEvent e){
		//Esto va a tener un switch
		//personaje.setRazaPersonaje((String)comboRaza.getSelectedItem());
	}
	
	public void comboCastaFocusLost(FocusEvent e){
		//Esto va a tener un switch
		//personaje.setCastaPersonaje((String)comboCasta.getSelectedItem());
	}
	
	public void btnCrearActionPerformed(ActionEvent evt){
		if("".equals(textField.getText()))
			JOptionPane.showMessageDialog(contentPane, "El personaje debe contener un nombre");
		else{
			try{
				
				//usuario.setPersonajeJugador(personaje);
				ventanaMapaJuego = new VentanaMapa(personaje);
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		ventanaMapaJuego.setSize(new Dimension(800,600));
		ventanaMapaJuego.setLocationRelativeTo(null);
		ventanaMapaJuego.setVisible(true);
		dispose();
		
	}
}
