package prograavanzada2016.anotherworld.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class VentanaUnionAlianza extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUnionAlianza frame = new VentanaUnionAlianza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUnionAlianza() throws Exception{
		Image image = new ImageIcon("src/main/resources/IconoVentana.jpg").getImage();
		setIconImage(image);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUnionAlianza.class.getResource("src/main/resources/IconoVentana.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldeseaUnirseA = new JLabel("\u00BFDesea unirse a la alianza?");
		lbldeseaUnirseA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbldeseaUnirseA.setBounds(40, 24, 384, 52);
		contentPane.add(lbldeseaUnirseA);
		
		JLabel lbljugador = new JLabel("@Jugador");
		lbljugador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbljugador.setBounds(165, 87, 124, 27);
		contentPane.add(lbljugador);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(59, 89, 182));
	    btnAceptar.setForeground(Color.BLACK);
	    btnAceptar.setFocusPainted(false);
	    btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(96, 147, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBackground(new Color(59, 89, 182));
	    btnRechazar.setForeground(Color.BLACK);
	    btnRechazar.setFocusPainted(false);
	    btnRechazar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRechazar.setBounds(271, 147, 89, 23);
		contentPane.add(btnRechazar);
	}

}
