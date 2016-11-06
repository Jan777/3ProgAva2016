package prograavanzada2016.anotherworld.interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.Cliente;
import prograavanzada2016.anotherworld.cliente.MensajeEnviable;
import prograavanzada2016.anotherworld.user.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField usuarioTextField;
	private JTextField passwordTextField;
	private JButton logInButton;
	private JButton registrarseButton;
	private JTextArea mensajeTextField;
	private Usuario usuario;
	private VentanaRegistro ventanaRegistro;
	private VentanaInicio ventanaInicio;
    
	private Cliente cliente;
	private MensajeEnviable mensajeEnviable;
	
    static Properties propiedades;
	static PropertiesFile pf;
    
    private Gson gson;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() throws IOException{
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("AnotherWorld");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/interfaz/IconoVentana.jpg")));
		initComponents();
		usuario = new Usuario();
		ventanaRegistro = new VentanaRegistro();
		ventanaRegistro.setLocationRelativeTo(this);
		gson = new Gson();
		cliente = new Cliente();
	}
	
	
	public void initComponents() {
		setTitle("AnotherWorld");
		setLocationRelativeTo(null);
		pf = new PropertiesFile();
		propiedades = pf.getProperties();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Integer.parseInt(propiedades.getProperty("w")),Integer.parseInt(propiedades.getProperty("h")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuarioTextField = new JTextField();
		usuarioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				usuarioTextFieldFocusLost(evt);
			}
		});
		usuarioTextField.setBounds(145, 43, 116, 22);
		contentPane.add(usuarioTextField);
		usuarioTextField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(77, 46, 56, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 84, 56, 16);
		contentPane.add(lblPassword);
		
		passwordTextField = new JTextField();
		passwordTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				passwordTextFieldFocusLost(e); 
			}
		});
		passwordTextField.setBounds(145, 81, 116, 22);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		logInButton = new JButton("LogIn");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ingresarButtonActionPerformed(evt);
			}
		});
		logInButton.setBounds(145, 142, 116, 25);
		contentPane.add(logInButton);
		
		registrarseButton = new JButton("Registrarse");
		registrarseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				registrarseButtonActionPerformed(evt);
			}
		});
		registrarseButton.setBounds(145, 193, 116, 25);
		contentPane.add(registrarseButton);
		
		mensajeTextField = new JTextArea();
		mensajeTextField.setBounds(77, 231, 261, 58);
		contentPane.add(mensajeTextField);
	}
	
	public void usuarioTextFieldFocusLost(FocusEvent evt){
		usuario.setNombreUsuario(usuarioTextField.getText());
	}
	
	public void passwordTextFieldFocusLost(FocusEvent e){
		usuario.setPassword(passwordTextField.getText());
	}
	
	public void ingresarButtonActionPerformed(ActionEvent evt)
	{
		try {
            if("".equals(usuarioTextField.getText()) || "".equals(passwordTextField.getText()))
            {
                mensajeTextField.setText("Debe ingresar todos los campos");
            } 
            else{
            	
            	cliente.enviarMensaje(2, gson.toJson(usuario));//envio la pregunta
            	
            	MensajeEnviable respuesta = gson.fromJson(cliente.recibirMensaje(), MensajeEnviable.class);//leo la respuesta y la transformo en mensaje enviable
            	///usuario = gson.fromJson((String) entrada.readObject(), Usuario.class);
                if(respuesta.getCodigo() == 2){ ///usuarioDAO.buscar(usuario) == 1
                	usuario = gson.fromJson(respuesta.getMensaje(), Usuario.class);//actualizo el usuario
                	mensajeTextField.setText("Todo ok");
                	ventanaInicio = new VentanaInicio(usuario);
                	ventanaInicio.setVisible(true);
                	ventanaInicio.setLocationRelativeTo(null);
                	dispose();
                }
                else{
                	mensajeTextField.setText("Fallo");
                }
            }
        } catch (Exception ex) {
            mensajeTextField.setText("Fallo exception");
            ex.printStackTrace();
        }
	}
	
	public void registrarseButtonActionPerformed(ActionEvent evt){
		ventanaRegistro.setVisible(true);
	}
}
