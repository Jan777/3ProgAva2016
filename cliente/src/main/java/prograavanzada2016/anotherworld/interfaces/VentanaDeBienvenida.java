package prograavanzada2016.anotherworld.interfaces;
import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.resources.LogAnother;
import prograavanzada2016.anotherworld.resources.Propiedades;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JProgressBar;

public class VentanaDeBienvenida extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
    private ClienteJugable clienteJugable;
    private JButton jugarButton;
    static Properties propiedades;
    private Timer timer;
    private JProgressBar progressBar;
    private ActionListener al;

	public VentanaCrearPersonaje ventanaCrearPersonaje;
	
	JLabel lblBienvenido = new JLabel("New label");

	public VentanaDeBienvenida(ClienteJugable clienteJugable) throws Exception {
		this.clienteJugable=clienteJugable;
		Image image = new ImageIcon(Propiedades.getInstance().getProperty("IconoVentana")).getImage();
		setIconImage(image);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDeBienvenida.class.getResource("src/main/resources/IconoVentana.jpg")));
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
		Image image2 = new ImageIcon(Propiedades.getInstance().getProperty("VentanaPrincipal")).getImage();
		label.setIcon(new ImageIcon(image2));
		//label.setIcon(new ImageIcon(VentanaDeBienvenida.class.getResource("src/main/resources/VentanaPrincipal.jpg")));
		label.setBounds(0, 0, 359, 236);
		contentPane.add(label);
	}
	
	public void initComponents() throws Exception{
		al= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogAnother log = null;
				if(progressBar.getValue() < 100){
					progressBar.setValue(progressBar.getValue()+10);
				}else{
					timer.stop();
					RawMessage rawMessageLogin = new RawMessage();
					rawMessageLogin.type = "personajeConsulta";
					rawMessageLogin.message = new PersonajeConsultaMessage(new Gson().toJson(usuario));

					try {
						log=LogAnother.getInstance();
						clienteJugable.getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
					} catch (IOException e1) {
						log.logError(e1.getMessage());
					}
					setVisible(false);
				}
								
			}
		};
		timer = new Timer(100, al);
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
		
		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(27, 156, 293, 31);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		contentPane.add(progressBar);
		jugarButton.setBounds(136, 200, 97, 25);
		contentPane.add(jugarButton);
	}
	
	
	public void jugarButtonActionPerformed(ActionEvent evt){
		
		if(!timer.isRunning()){
			timer.start();
		}
		
	}
}
