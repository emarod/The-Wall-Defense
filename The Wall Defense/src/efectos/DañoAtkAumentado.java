package efectos;

import javax.swing.ImageIcon;

import main.Unidad;
import mapa.Celda;

/*
 * Clase DañoAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta el daño de ataque.
 */

public class DañoAtkAumentado extends PowerUpTemporal {

	// Constructor.
	public DañoAtkAumentado(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
		tiempo = 10;

	}

	// Metodos heredados.

	@Override
	public void aplicar(Unidad u) {
		super.aplicar(u);
		unidad = u;
		unidad.setAtaque(unidad.getDaño() * 2);
		unidad.observar(this);
		crear();
		ejecutar();
	}

}
