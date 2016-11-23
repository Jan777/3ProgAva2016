package prograavanzada2016.anotherworld.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

	public VentanaMochila() throws Exception{
		setTitle("Mochila");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMochila.class.getResource("/prograavanzada2016/anotherworld/interfaces/IconoVentana.jpg")));
		getContentPane().setLayout(null);
		
		JLabel lblMochila = new JLabel("Mochila");
		lblMochila.setForeground(Color.WHITE);
		lblMochila.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMochila.setBounds(56, 10, 109, 24);
		getContentPane().add(lblMochila);
		
		
		String[] items = {"Casco","Maza","Armadura","Espada"}; 
		JList listaItems = new JList(items);
		listaItems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaItems.setBounds(56, 78, 249, 95);
		getContentPane().add(listaItems);
		
		JButton btnEquipar = new JButton("Equipar");
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
		
		JButton btnTirar = new JButton("Tirar");
		btnTirar.setBackground(new Color(59, 89, 182));
	    btnTirar.setForeground(Color.BLACK);
	    btnTirar.setFocusPainted(false);
	    btnTirar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTirar.setBounds(178, 227, 89, 23);
		getContentPane().add(btnTirar);
		
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
		lblNewLabel.setIcon(new ImageIcon(VentanaMochila.class.getResource("/prograavanzada2016/anotherworld/interfaces/BackgroundMochilaYAlianza.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 271);
		getContentPane().add(lblNewLabel);
	}
}
