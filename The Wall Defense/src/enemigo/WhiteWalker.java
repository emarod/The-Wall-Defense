package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameObject;
import mapa.Celda;

public class WhiteWalker extends StateEnemigo{
	
	protected ImageIcon imagen;
	protected JLabel graf;
	protected int tipo;
	
	public WhiteWalker() {
		puntaje=100;
		velocidad_enemigo=10;
		resistencia=3;
		imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/whitewalker_espadachin_atacando.gif"));
		graf=new JLabel();
		graf.setIcon(imagen);
	}

	@Override
	public void atacar() {
		
	}

	public void mover() {		
		Celda siguiente;
		boolean detener=false;
		int xCelda=this.enemigo.getCelda().getPosX();
		int yCelda=this.enemigo.getCelda().getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		siguiente=this.enemigo.getCelda().getCelda(xCelda-1,yCelda);
		for(int i=0;i<7;i++) {
			GameObject objeto =siguiente.getObjects()[i];
			if (objeto!=null && !objeto.Accept(enemigo.getVisitor())){
//				this.enemigo.getCelda().getDirector().desactivar(this.enemigo);
				detener=true;
			}
		}
		if(!detener && xCelda!=0) {
			enemigo.getGrafico().setBounds(xGrafico-64, yGrafico, 64, 64);
			enemigo.intercambiar_celdas(siguiente);					
		}		
	}
	
    public void destruir(){
    	System.out.println("Destruir WhiteWalker");
    	this.enemigo.getCelda().getDirector().desactivar(this.enemigo);
	   
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;				
	}
	
	public void setGrafico(JLabel grafico) {
		imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/whitewalker_espadachin_atacando.gif"));
		grafico.setIcon(imagen);
	}
	
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public JLabel getGrafico() {
		// TODO Auto-generated method stub
		return graf;
	}
	
	public int getTipo(){
		return tipo;
	}

}