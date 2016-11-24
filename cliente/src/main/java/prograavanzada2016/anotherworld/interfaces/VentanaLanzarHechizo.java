package prograavanzada2016.anotherworld.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class VentanaLanzarHechizo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLanzarHechizo frame = new VentanaLanzarHechizo();
					frame.setVisible(true);
					frame.setSize(new Dimension(300,300));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLanzarHechizo() {
		setTitle("Lanzar Hechizo");
		setResizable(false);
		Image image = new ImageIcon("src/main/resources/IconoVentana.jpg").getImage();
		setIconImage(image);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMochila.class.getResource("src/main/resources/IconoVentana.jpg")));
		getContentPane().setLayout(null);
		
		JLabel lblHechizos = new JLabel("Hechizos");
		lblHechizos.setForeground(Color.WHITE);
		lblHechizos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblHechizos.setBounds(56, 10, 109, 24);
		getContentPane().add(lblHechizos);
		
		
		String[] items = {"Hechizo1","Hechizo2","Hechizo3","Hechizo4"}; 
		JList listaItems = new JList(items);
		listaItems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaItems.setBounds(56, 78, 249, 95);
		getContentPane().add(listaItems);
		
		JButton btnEquipar = new JButton("Lanzar");
		btnEquipar.setBackground(new Color(59, 89, 182));
	    btnEquipar.setForeground(Color.BLACK);
	    btnEquipar.setFocusPainted(false);
	    btnEquipar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEquipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEquipar.setBounds(56, 227, 89, 23);
		getContentPane().add(btnEquipar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(59, 89, 182));
	    btnCancelar.setForeground(Color.BLACK);
	    btnCancelar.setFocusPainted(false);
	    btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(299, 227, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(VentanaMochila.class.getResource("src/main/resources/BackgroundMochilaYAlianza.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 271);
		getContentPane().add(lblNewLabel);
	}

}
