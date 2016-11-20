package prograavanzada2016.anotherworld.interfaces;
import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VentanaDeBienvenida extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
	private boolean cancelar;
	private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private ClienteJugable clienteJugable;
    private JButton jugarButton;
    static Properties propiedades;
	static PropertiesFile pf;

	public VentanaCrearPersonaje ventanaCrearPersonaje;
	
	JLabel lblBienvenido = new JLabel("New label");

	public VentanaDeBienvenida(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDeBienvenida.class.getResource("/prograavanzada2016/anotherworld/interfaces/IconoVentana.jpg")));
		setTitle("Bienvenido!");
		initComponents();
		usuario = clienteJugable.getUsuario();
		
		setVisible(true);
    	setLocationRelativeTo(null);
		lblBienvenido.setVerticalAlignment(SwingConstants.TOP);
		
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblBienvenido.setBounds(27, 91, 322, 52);
		contentPane.add(lblBienvenido);
		lblBienvenido.setText("Bienvenido "+usuario.getNombre());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaDeBienvenida.class.getResource("/prograavanzada2016/anotherworld/interfaces/VentanaPrincipal.jpg")));
		label.setBounds(0, 0, 359, 236);
		contentPane.add(label);
	
				
		/*try {
            Socket socket = new Socket("localhost", 4444);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
	}
	
	public void initComponents(){
		pf = new PropertiesFile();
		propiedades = pf.getProperties();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(375,275));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jugarButton = new JButton("Jugar");
		jugarButton.setBackground(new Color(59, 89, 182));
	    jugarButton.setForeground(Color.BLACK);
	    jugarButton.setFocusPainted(false);
	    jugarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		jugarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jugarButtonActionPerformed(evt);
			}
		});
		jugarButton.setBounds(136, 200, 97, 25);
		contentPane.add(jugarButton);
	}
	
	public void jugarButtonActionPerformed(ActionEvent evt){
		//Usuario usuario = new Usuario();
		//usuario.setNombreUsuario(nombreUsuario);
		//usuario.setPassword(passwordUsuario);
		RawMessage rawMessageLogin = new RawMessage();
		rawMessageLogin.type = "personajeConsulta";
		rawMessageLogin.message = new PersonajeConsultaMessage(new Gson().toJson(usuario));

		clienteJugable.getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
		this.setVisible(false);
		
		
	}
}
