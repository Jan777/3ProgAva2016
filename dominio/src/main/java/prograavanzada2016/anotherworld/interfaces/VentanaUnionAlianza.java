package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VentanaUnionAlianza extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public VentanaUnionAlianza() {
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
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(96, 147, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(271, 147, 89, 23);
		contentPane.add(btnRechazar);
	}

}
