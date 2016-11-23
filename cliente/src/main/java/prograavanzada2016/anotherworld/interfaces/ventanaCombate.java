package prograavanzada2016.anotherworld.interfaces;

import javax.swing.*;
import java.awt.BorderLayout;

public class ventanaCombate extends JFrame{
	JPanel upJPane = new JPanel();
	JPanel downJPane = new JPanel();
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(upJPane),new JScrollPane(downJPane));
	
	public ventanaCombate(){
		
		getContentPane().add(splitPane, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		ventanaCombate sp = new ventanaCombate();
		sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sp.setSize(800,600);
		sp.setVisible(true);
	}
}