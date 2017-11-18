package interfaz.botones;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import comprables.Comprable;
import interfaz.Escenario;

/*
 * Clase abstracta BtnObstaculo.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un obstaculo.
 */

public abstract class BtnComprables extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario stage;
	protected Comprable comprable;
	protected Icon info;
	public int costo;

	// Constructor.
	public BtnComprables(Escenario e) {
		stage = e;
		this.setSize(32, 32);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

	}

	public void habilitar() {
		this.setEnabled(true);
	}

	// Metodos abstractos.
	public abstract void create();

	public abstract void oyente();
}
