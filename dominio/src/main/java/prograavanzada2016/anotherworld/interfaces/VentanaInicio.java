package interfaz;
import model.Usuario;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
	private JTextArea textArea;
	private boolean cancelar;
	private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private JButton jugarButton;
    static Properties propiedades;
	static PropertiesFile pf;

	public VentanaCrearPersonaje ventanaCrearPersonaje;

	public VentanaInicio(Usuario user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/interfaz/IconoVentana.jpg")));
		setTitle("Bienvenido!");
		initComponents();
		usuario = user;
		textArea.setText("Bienvenido "+usuario.getNombre());
	
				
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
		setSize(Integer.parseInt(propiedades.getProperty("w")),Integer.parseInt(propiedades.getProperty("h")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jugarButton = new JButton("Jugar");
		jugarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jugarButtonActionPerformed(evt);
			}
		});
		jugarButton.setBounds(347, 391, 97, 25);
		contentPane.add(jugarButton);
		
		textArea = new JTextArea();
		textArea.setBounds(232, 212, 309, 100);
		contentPane.add(textArea);
	}
	
	public void jugarButtonActionPerformed(ActionEvent evt){
	
		if(usuario.getPersonajeJugador() != null){
			VentanaMapa ventanaMapa = new VentanaMapa(usuario);
			ventanaMapa.setVisible(true);
			ventanaMapa.setLocationRelativeTo(null);
			dispose();
		}
		else{
			ventanaCrearPersonaje = new VentanaCrearPersonaje(usuario);
			ventanaCrearPersonaje.setVisible(true);
			ventanaCrearPersonaje.setLocationRelativeTo(null);
			dispose();
		}
	}
}
