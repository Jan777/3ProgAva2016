package prograavanzada2016.anotherworld.mapas;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Ventana extends JFrame {

	//private JPanel contentPane;
	BufferedImage sprite;
	MapaViejoParaElRecuerdo mapa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Ventana() throws Exception {
		setTitle("Prueba de mapa another world");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0, 0, 320, 160);
		setSize(800,600);
		setBackground(Color.BLACK);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setLayout(null);
		//contentPane.setSize(new Dimension(100, 100));
		//contentPane.setBackground(Color.BLACK);
		//contentPane.setVisible(true);
		//setContentPane(contentPane);
		mapa = new MapaViejoParaElRecuerdo();
		add(mapa);
		LogAnother.getInstance().logSentence("ventana principal:"+this.getWidth()+" "+this.getHeight());
	}
	
}
