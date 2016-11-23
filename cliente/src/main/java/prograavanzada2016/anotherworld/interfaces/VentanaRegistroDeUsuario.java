package prograavanzada2016.anotherworld.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.*;
import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.UsuarioNuevoMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistroDeUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField nombreUsuarioTextField;
	private JButton registroButton;
	private JButton cancelarButton;
	private Usuario usuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private UsuarioDAO usuarioDAO;
	private ClienteJugable clienteJugable;

	/**
	 * Launch the application.
	 */
	
	public VentanaRegistroDeUsuario(ClienteJugable clienteJugable) throws Exception{
		this.clienteJugable = clienteJugable;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistroDeUsuario.class.getResource("/prograavanzada2016/anotherworld/interfaces/IconoVentana.jpg")));
		setTitle("Registrar");
		initComponents();
		usuario = new Usuario();
	}
	/**
	 * Create the frame.
	 */
	public void initComponents() throws Exception{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(32, 27, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(32, 66, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre \r\nde \r\nUsuario");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setBounds(32, 95, 117, 49);
		contentPane.add(lblNombreDeUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(32, 157, 87, 16);
		contentPane.add(lblPassword);
		
		registroButton = new JButton("Registrarse");
		registroButton.setBackground(new Color(59, 89, 182));
	    registroButton.setForeground(Color.BLACK);
	    registroButton.setFocusPainted(false);
	    registroButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		registroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				registroButtonActionPerformed(evt);
			}
		});
		registroButton.setBounds(65, 202, 97, 25);
		contentPane.add(registroButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setBackground(new Color(59, 89, 182));
	    cancelarButton.setForeground(Color.BLACK);
	    cancelarButton.setFocusPainted(false);
	    cancelarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelarButtonActionPerformed(evt);
			}
		});
		cancelarButton.setBounds(230, 202, 97, 25);
		contentPane.add(cancelarButton);
		
		nombreTextField = new JTextField();
		nombreTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nombreTextFieldFocusLost(e);
			}
		});
		nombreTextField.setBounds(211, 24, 116, 22);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		apellidoTextField = new JTextField();
		apellidoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apellidoTextFieldFocusLost(e);
			}
		});
		apellidoTextField.setBounds(211, 63, 116, 22);
		contentPane.add(apellidoTextField);
		apellidoTextField.setColumns(10);
		
		nombreUsuarioTextField = new JTextField();
		nombreUsuarioTextField.setBounds(211, 108, 116, 22);
		contentPane.add(nombreUsuarioTextField);
		nombreUsuarioTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				passwordFieldFocusLost(evt);
			}
		});
		passwordField.setBounds(211, 155, 116, 20);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaRegistroDeUsuario.class.getResource("/prograavanzada2016/anotherworld/interfaces/VentanaPrincipal.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
	
	public void nombreTextFieldFocusLost(FocusEvent e){
		usuario.setNombre(nombreTextField.getText());
	}
	
	public void apellidoTextFieldFocusLost(FocusEvent e){
		usuario.setApellido(apellidoTextField.getText());
	}
	
	public void nombreUsuarioTextFieldFocusLost(FocusEvent e) throws Exception, DAOException{
		/*if(usuarioDAO.existeUsuario(nombreUsuarioTextField.getText()) == 1)
			JOptionPane.showMessageDialog(contentPane, "Usuario existen");
			else
			usuario.setNombreUsuario(nombreUsuarioTextField.getText());*/
	}
	
	public void passwordFieldFocusLost(FocusEvent evt){
		char[] pass = passwordField.getPassword();
		String passString = new String(pass);
		usuario.setPassword(passString);
	}
	
	public void registroButtonActionPerformed(ActionEvent evt){
		if("".equals(nombreTextField.getText()) || "".equals(apellidoTextField.getText()) || "".equals(nombreUsuarioTextField.getText())){
			JOptionPane.showMessageDialog(contentPane, "Debe ingresar todos los campos");
		}
		else{
			usuario.setNombre(nombreTextField.getText());
			usuario.setApellido(apellidoTextField.getText());
			usuario.setNombreUsuario(nombreUsuarioTextField.getText());
			usuario.setPassword(new String(passwordField.getPassword()));
			
			RawMessage rawMessageLogin = new RawMessage();
			rawMessageLogin.type = "usuarioNuevo";
			rawMessageLogin.message = new UsuarioNuevoMessage(new Gson().toJson(usuario));

			clienteJugable.getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
			this.setVisible(false);
		}
		
			
	}
	
	public void cancelarButtonActionPerformed(ActionEvent evt){
		dispose();
	}
}
