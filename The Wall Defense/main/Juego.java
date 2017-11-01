package main;

import javax.swing.*;

import javax.swing.JFrame;

import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

import interfaz.GUI;
import interfaz.MenuInicio;

public class Juego {
	protected static GUI frame;
	protected final JFrame menu=new JFrame("The Wall Defense");


	public static void main(String[] args) {
		new Juego();

	}
	
	public Juego() {
		pantallaPrincipal();
	}
	
	public void pantallaPrincipal(){
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 525, 410);
		menu.setLocationRelativeTo(null);
		JLayeredPane contentPane=new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setContentPane(contentPane);
		Icon background=new ImageIcon(this.getClass().getResource("/resources/static/background/background.png"));
		
		//Creo menu de inicio
		MenuInicio opciones=new MenuInicio(this);
		
		
		menu.setContentPane(new JLabel(background));
		menu.pack();
		menu.add(opciones,new Integer(2));

	}
	
	public void crearGUI(){
		menu.dispose();
		frame=new GUI();
		frame.setVisible(true);
	}	

}