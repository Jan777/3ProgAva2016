package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaMochila extends JFrame {

	public VentanaMochila() {
		setTitle("Mochila");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMochila.class.getResource("/interfaz/IconoVentana.jpg")));
		getContentPane().setLayout(null);
		
		JLabel lblMochila = new JLabel("Mochila");
		lblMochila.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMochila.setBounds(56, 28, 109, 24);
		getContentPane().add(lblMochila);
		
		
		String[] items = {"Casco","Maza","Armadura","Espada"}; 
		JList listaItems = new JList(items);
		listaItems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaItems.setBounds(56, 78, 249, 95);
		getContentPane().add(listaItems);
		
		JButton btnNewButton = new JButton("Equipar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(56, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tirar");
		btnNewButton_1.setBounds(178, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(299, 227, 89, 23);
		getContentPane().add(btnNewButton_2);
	}
}
