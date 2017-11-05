package enemigo;

import java.util.concurrent.Future;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparo.DisparoEnemigo;
import main.GameObject;
import mapa.Celda;

/*
 * Clase NightKing.
 * Clase que especifica las caracteristicas y comportamiento del enemigo nightking.
 */

public class NightKing extends PerfilEnemigo {
	
	//Atributos locales.
	protected Enemigo enemigo;
	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	
	//Constructor.
	public NightKing() {
		puntaje=200;
		velocidad_enemigo=50;
		daño = 1;
		resistencia=6;
		graficos= new Icon[14];
		graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando00.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando01.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando02.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando03.png"));
		graficos[4]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando04.png"));
		graficos[5]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando05.png"));
		graficos[6]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando06.png"));
		graficos[7]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando07.png"));
		graficos[8]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando08.png"));
		graficos[9]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando09.png"));
		graficos[10]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando10.png"));
		graficos[11]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando11.png"));
		graficos[12]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando12.png"));
		graficos[13]=new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando13.png"));	
	}
	
	//Metodos locales.
	public Enemigo getEnemigo(){
		return enemigo;				
	}
	
	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}
	
	public void animarDisparo() {
		if(graph<4) {
			graph++;
		}
		setGrafico(graph);
		if(graph == 4){
			setGrafico(0);
		}
	}
	
	public void setGrafico(int i) {
		enemigo.getGrafico().setIcon(graficos[i]);
	}
	
	public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
	
	//Metodos heredados.
	public Future<?> atacar(){	
		if(disparos_en_ejecucion<disparos_simultaneos){
			enemigo.playSound();
			shot =new DisparoEnemigo(this,6).getTask();			
			disparos_en_ejecucion++;
    	}
		graph=0;
		return shot;
    }

	public void mover() {		
		Celda siguiente;
		boolean detener=false;
		int xCelda= enemigo.getCeldas()[0].getPosX();
		int yCelda= enemigo.getCeldas()[0].getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		siguiente=enemigo.getCeldas()[0].getCelda(xCelda-1,yCelda);
		for(int i=0;i<7;i++) {
			GameObject objeto =siguiente.getObjects()[i];
			if (objeto!=null && !objeto.accept(enemigo.getVisitor())){
				detener=true;
			}
		}
		if(!detener && xCelda!=0) {
			enemigo.getGrafico().setBounds(xGrafico-64, yGrafico, 64, 64);
			enemigo.intercambiar_celdas(siguiente);
		}
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando00.png"));
		graph=0;
		grafico.setIcon(imagen);
	}
	
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		
	}

    public void destruir(){
    	System.out.println("Destruir WhiteWalker");
    	this.enemigo.getCeldas()[0].getDirector().desactivar(this.enemigo);
	   
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;				
	}
	
	public PerfilEnemigo clone() {
		return new NightKing();
	}
	
	public void playSound() {
		enemigo.getBancoRecursos().playFlecha();
	}
	
	public int getDaño(){
		return daño;
	}
}
