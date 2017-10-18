package jugador;
import java.util.concurrent.Future;

import javax.swing.*;
public abstract class StateJugador {
	protected int velocidad_jugador;
	protected int resistencia;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	protected Jugador jugador;	
	
    public boolean impact(){
    	if(resistencia==1)
    		return true;
    	else{
    		resistencia--;
    		return false;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_jugador;
    }
    public abstract Future<?> atacar();
    public abstract void mover();
    public abstract void setJugador(Jugador jugador);
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    public abstract void setGraficos(Icon[] graficos, JLabel grafico);

    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }
	public abstract void setGrafico(JLabel grafico);
	public void destruir() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract StateJugador clone();
	public Jugador getJugador() {
		// TODO Auto-generated method stub
		return jugador;
	}

}