package prograavanzada2016.anotherworld.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.cliente.MensajeEnviable;
import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.observer.ILogin;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class VentanaPrincipal extends JFrame implements ILogin{

	private JPanel contentPane;
	private JTextField usuarioTextField;
	private JButton logInButton;
	private JButton registrarseButton;
	private Usuario usuario;
	private VentanaRegistro ventanaRegistro;
	private VentanaInicio ventanaInicio;
	
	private ClienteJugable clienteJugable;
	private MensajeEnviable mensajeEnviable;
	
    static Properties propiedades;
	static PropertiesFile pf;
    
    private Gson gson;
    private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	public VentanaPrincipal(ClienteJugable clienteJugable) throws IOException{
		this.clienteJugable = clienteJugable;
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("AnotherWorld");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/prograavanzada2016/anotherworld/interfaces/IconoVentana.jpg")));
		initComponents();
		usuario = new Usuario();
		ventanaRegistro = new VentanaRegistro();
		ventanaRegistro.setLocationRelativeTo(this);
		gson = new Gson();
		setVisible(true);
		setLocationRelativeTo(null);
		//clienteJugable = new ClienteJugable("localhost",444);
	}
	
	
	public void initComponents() {
		setTitle("AnotherWorld");
		setLocationRelativeTo(null);
		pf = new PropertiesFile();
		propiedades = pf.getProperties();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(375,275));
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
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(77, 46, 56, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 84, 56, 16);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(70, 84, 84, 16);
		contentPane.add(lblPassword);
		
		logInButton = new JButton("LogIn");
		logInButton.setBackground(new Color(59, 89, 182));
	    logInButton.setForeground(Color.BLACK);
	    logInButton.setFocusPainted(false);
	    logInButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ingresarButtonActionPerformed(evt);
			}
		});
		logInButton.setBounds(145, 142, 116, 25);
		contentPane.add(logInButton);
		
		registrarseButton = new JButton("Registrarse");
		registrarseButton.setBackground(new Color(59, 89, 182));
	    registrarseButton.setForeground(Color.BLACK);
	    registrarseButton.setFocusPainted(false);
	    registrarseButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		registrarseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				registrarseButtonActionPerformed(evt);
			}
		});
		registrarseButton.setBounds(145, 193, 116, 25);
		contentPane.add(registrarseButton);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				passwordTextFieldFocusLost(evt);
			}
		});
		passwordField.setBounds(145, 82, 116, 18);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/prograavanzada2016/anotherworld/interfaces/VentanaPrincipal.jpg")));
		lblNewLabel.setBounds(0, 0, 794, 571);
		contentPane.add(lblNewLabel);
	}
	
	public void usuarioTextFieldFocusLost(FocusEvent evt){
		usuario.setNombreUsuario(usuarioTextField.getText());
	}
	
	public void passwordTextFieldFocusLost(FocusEvent evt){
		char[] pass = passwordField.getPassword();
		String passString = new String(pass);
		usuario.setPassword(passString);
	}
	
	public void ingresarButtonActionPerformed(ActionEvent evt)
	{
		try {
			
			String nombreUsuario = usuarioTextField.getText().trim();
			String passwordUsuario = new String(passwordField.getPassword());
			
			if("".equals(passwordUsuario) || "".equals(nombreUsuario)){
				JOptionPane.showMessageDialog(contentPane, "Debe ingresar todos los campos");
            } 
            else{
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(nombreUsuario);
				usuario.setPassword(passwordUsuario);
				RawMessage rawMessageLogin = new RawMessage();
				rawMessageLogin.type = "login";
				rawMessageLogin.message = new LoginMessage(new Gson().toJson(usuario));

				clienteJugable.getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
				this.setVisible(false);
            }
        } catch (Exception ex) {
        	JOptionPane.showMessageDialog(contentPane, "Problema de conexion con la base de datos");
            ex.printStackTrace();
        }
	}
	
	public void registrarseButtonActionPerformed(ActionEvent evt){
		ventanaRegistro.setVisible(true);
	}

	@Override
	public void update(String response) {
		ventanaInicio = new VentanaInicio(clienteJugable);
    	ventanaInicio.setVisible(true);
    	ventanaInicio.setLocationRelativeTo(null);
    	dispose();
	}
}
