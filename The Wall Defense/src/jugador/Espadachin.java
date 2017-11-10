package jugador;

import java.util.concurrent.Future;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Clase Espadachin.
 * Clase que especifica las caracteristicas y comportamiento del jugador espadachin.
 */

public class Espadachin extends PerfilJugador{
	
	//Constructor.
	public Espadachin() {
		resistencia=8;
		costo=30;
	}
	
	//Metodos heredados.
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
    public Future<?> atacar(){
		return null;
    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/jon_snow.gif"));
		grafico.setIcon(imagen);
    }

	public PerfilJugador clone() {
		return new Espadachin();
	}
	
	public void playSound() {
		
	}
	
	public void destruir(){
		jugador.getCeldas()[0].getEscenario().remove(jugador.getGrafico());
		jugador.getCeldas()[0].getDirector().desactivar(this.getJugador());
	}
	
	public int getDaño(){
		return daño;
	}
}