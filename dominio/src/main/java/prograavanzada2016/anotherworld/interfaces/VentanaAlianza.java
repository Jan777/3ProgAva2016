package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaAlianza extends JFrame {

	private JPanel contentPane;

	public VentanaAlianza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAlianza.class.getResource("/interfaz/IconoVentana.jpg")));
		setTitle("Alianzas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlianza = new JLabel("Alianza");
		lblAlianza.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAlianza.setBounds(142, 24, 103, 34);
		contentPane.add(lblAlianza);
		
		JLabel lblSeleccione = new JLabel("Seleccione");
		lblSeleccione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccione.setBounds(50, 77, 97, 14);
		contentPane.add(lblSeleccione);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 102, 103, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(50, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(196, 168, 89, 23);
		contentPane.add(btnCancelar);
	}
}
