package prograavanzada2016.anotherworld.interfaces;

import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.resources.LogAnother;
import prograavanzada2016.anotherworld.resources.Propiedades;

import java.awt.*;

public class VentanaCrearPersonaje extends JFrame {
	
	VentanaMapa ventanaMapaJuego;
	
	static Properties propiedades;
	//static PropertiesFile pf;
	
	private String nombrePersonaje;
	private String razaPersonaje;
	private String castaPersonaje;
	private JPanel contentPane;
	private JTextField textField;
	private Usuario usuario;
	
	private JComboBox comboRaza;
	private JComboBox comboCasta;
	private JButton btnCrear;
	private ClienteJugable clienteJugable;
	private Personaje personaje;
	private JLabel labelMuestraPersonaje;
	
	public VentanaCrearPersonaje(ClienteJugable clienteJugable) throws Exception{
		initComponents();   
		this.usuario = clienteJugable.getUsuario();
		this.clienteJugable=clienteJugable;
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void initComponents() throws Exception {
		Propiedades propiedades = Propiedades.getInstance();
		setSize(Integer.parseInt(propiedades.getProperty("w")),Integer.parseInt(propiedades.getProperty("h")));
		Image image = new ImageIcon(Propiedades.getInstance().getProperty("IconoVentana")).getImage();
		setIconImage(image);
		//setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/IconoVentana.jpg"));
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
				try {
					comboRazaFocusLost(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
				LogAnother log = null;
				try {
					log=LogAnother.getInstance();
					btnCrearActionPerformed(evt);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage()+"Ocurri� un error, no se puede crear el personaje, "
							+ "para m�s informaci�n"+System.getProperty("line.separator") 
					+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
					log.logError(e.getMessage());
				}
			}
		});
		btnCrear.setBounds(313, 206, 89, 23);
		contentPane.add(btnCrear);
		
		Image image2 = new ImageIcon(Propiedades.getInstance().getProperty("HumanoCreate")).getImage();
		labelMuestraPersonaje = new JLabel("");
		labelMuestraPersonaje.setIcon(new ImageIcon(image2));
		labelMuestraPersonaje.setBounds(545, 37, 210, 237);
		contentPane.add(labelMuestraPersonaje);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(propiedades.getProperty("createCharacterJPG")));
		label.setBounds(0, 0, 784, 561);
		contentPane.add(label);
		
	}
	
	public void textFieldFocusLost(FocusEvent evt){
		//personaje.setNombrePersonaje(textField.getText());
	}
	
	public void comboRazaFocusLost(FocusEvent e) throws IOException{
		if(comboRaza.getSelectedItem().equals("Humano")){
			Image image2 = new ImageIcon(Propiedades.getInstance().getProperty("HumanoCreate")).getImage();
			labelMuestraPersonaje.setIcon(new ImageIcon(image2));
		}
		else{
			Image image2 = new ImageIcon(Propiedades.getInstance().getProperty("TrollCreate")).getImage();
			labelMuestraPersonaje.setIcon(new ImageIcon(image2));
		}
		
		//Esto va a tener un switch
		//personaje.setRazaPersonaje((String)comboRaza.getSelectedItem());
	}
	
	public void comboCastaFocusLost(FocusEvent e){
		//Esto va a tener un switch
		//personaje.setCastaPersonaje((String)comboCasta.getSelectedItem());
	}
	
	public void btnCrearActionPerformed(ActionEvent evt) throws Exception{
		if("".equals(textField.getText()))
			JOptionPane.showMessageDialog(contentPane, "El personaje debe contener un nombre");
		else{
			//juego de mati esto no va a ir mas aca... hay que crear un servicio que lanze la nueva ventana
				String razaString = comboRaza.getSelectedItem().toString();
				String castaString = comboCasta.getSelectedItem().toString();
				String nombreString = textField.getText();
				
				
				PersonajeModel pm = new PersonajeModel(nombreString,castaString,razaString,this.usuario.getId());
				
				RawMessage rawMessageLogin = new RawMessage();
				rawMessageLogin.type = "crearPersonaje";
				rawMessageLogin.message = new PersonajeConsultaMessage(new Gson().toJson(pm));

				clienteJugable.getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
				this.setVisible(false);
				
				//usuario.setPersonaje(pm);
				//Game game = new Game("Another World", 800, 600, clienteJugable);
				//game.start();
				
				VentanaLogin ven = new VentanaLogin(clienteJugable);
				
				//usuario.setPersonajeJugador(personaje);
				//ventanaMapaJuego = new VentanaMapa(personaje);

		}
		dispose();
		
	}
}
