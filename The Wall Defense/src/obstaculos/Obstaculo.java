package obstaculos;

import javax.swing.Icon;
import javax.swing.JLabel;

import main.GameObject;
import mapa.Celda;

public abstract class Obstaculo extends GameObject {

	// Atributos locales.
	protected JLabel imagen;
	protected Icon[] graficos;
	protected int graph;

	// Constructor.
	public Obstaculo(Celda[] c, int prof) {
		profundidad = prof;
		celda = c;
		grafico = new JLabel();
	}

	// Metodos locales
	public void setGrafico() {
		setGrafico(grafico);
	}

	public abstract Obstaculo clone(Celda[] c);// profundidad 3
}