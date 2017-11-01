package mapa;

import java.util.LinkedList;

import javax.swing.JLabel;

import Controladores.Director;
import enemigo.Enemigo;
import interfaz.Escenario;

import main.GameObject;
import obstaculo.*;
import terreno.*;

public class Celda {
	   protected GameObject[] listaObjetosLogicos;
	   protected Map Map;
	   protected int posX;
	   protected int posY;
	   protected boolean hayDisparo;
	   protected boolean estaOcupada;
	   protected LinkedList<GameObject> disparos;

	   public Celda(char tipo, Map Mapa,int posX, int posY,int sprite){
		   hayDisparo=false;
		   this.posX=posX;
		   this.posY=posY;
		   Map=Mapa;
	  	   listaObjetosLogicos=new GameObject[7];
	  	   disparos = new LinkedList<GameObject>();
	  	   switch(tipo){
	  	   		case  'a' : 
	    			listaObjetosLogicos[0]=null;
	    			break;
	    		case 'b':
	    			//listaObjetosLogicos[0]=new Rock(this,0,sprite);
	    			
	    			break;
	    		case 'c':
	    			//Centro lago.
	    			listaObjetosLogicos[0]=new Water(this,'c',0,1);
	    			break;
	    		case 'd':
	    		case 'e':
	    		case 'f':
	    		case 'g':
	    		case 'h':
	    		case 'i':
	    		case 'j':
	    		case 'k':
	    		case 'l':
	    		case 'm':
	    			listaObjetosLogicos[0]=new Muro(this);
	    			break;
	    		case 'n':
	    			//No necesita el 'sprite' por parametros porque crea un suelo ramdom.
	    			listaObjetosLogicos[0]=new Nieve(this);
	    			break;
	    		case 'o':
	    			//listaObjetosLogicos[0]=new Water(this,tipo,0,sprite);
	    			break;
	    		case 'p':
	    		case 'q':
	    		case 'r':
	    			//Piedra.
	    			listaObjetosLogicos[0]=new Nieve(this);
	    			listaObjetosLogicos[3]=new Rock(this,3,1);
	    			JLabel roca = listaObjetosLogicos[3].getGrafico();
	    			roca.setBounds(posX*64, posY*64, 64, 64);
	    			getEscenario().agregar(roca,new Integer(3));	    			
	    			break;
	    		case 's':
	    			//Lateral vertical sup.
	    			listaObjetosLogicos[0]=new Water(this,'s',0,1);
	    			break;
	    		case 't':
	    			//Lateral vertical inf.
	    			listaObjetosLogicos[0]=new Water(this,'t',0,1);
	    			break;
	    		case 'u':
	    			//Lateral horizontal derecho.
	    			listaObjetosLogicos[0]=new Water(this,'u',0,1);
	    			break;
	    		case 'v':
	    			//Lateral horizontal izquierdo.
	    			listaObjetosLogicos[0]=new Water(this,'v',0,1);
	    			break;
	    		case 'w':
	    			//Esquina superior izquierda.
	    			listaObjetosLogicos[0]=new Water(this,'w',0,1);
	    			break;
	    		case 'x':
	    			//Esquina inferior izquierda.
	    			listaObjetosLogicos[0]=new Water(this,'x',0,1);
	    			break;
	    		case 'y':
	    			//Esquina superior derecha.
	    			listaObjetosLogicos[0]=new Water(this,'y',0,1);
	    			break;
	    		case 'z':
	    			//Esquina inferior derecha.
	    			listaObjetosLogicos[0]=new Water(this,'z',0,1);
	    			break;
	    		case '1':
	    		case '2':
	    		case '3':
	    		case '4':
	    		case '5':
	    			//listaObjetosLogicos[2]=new Grass(this,tipo,2,sprite);
	    			break;
	    		case '6':
	    			//listaObjetosLogicos[0]=new Pared(this);
	    		break;
	    		case '7':
	    			//listaObjetosLogicos[0]=new Acero(this,0);
	    			
		    			
	   }
	   
	}
	
	public GameObject[] getObjects(){
		refresh();
		return listaObjetosLogicos;
	}
	
	public void addDisparo(GameObject d) {
		if(hayDisparo) {
			disparos.addFirst(d);
			refresh();
		}
		else {
			listaObjetosLogicos[6]=d;
			hayDisparo=true;
		}		
	}
	
	public void refresh() {
		if(listaObjetosLogicos[6]==null) {
			if(hayDisparo) {
				GameObject recarga = disparos.pollLast();
				if(recarga!=null) {
					listaObjetosLogicos[6]=recarga;
				}
				else {
					hayDisparo=false;
				}
			}
		}
	}
	
	public GameObject hayDisparo() {
		return listaObjetosLogicos[6];
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	public Celda getCelda(int x, int y){
		return Map.getCelda(x, y);
	}
	public Escenario getEscenario(){
		return Map.getEscenario();
	}
	    
    public Director getDirector() {
    	return Map.getDirector();
    }
    
    public void destruirEnemigo(Enemigo e){
 	   Map.destruirEnemigo(e);
    }
    
//  Si la celda contiene un enemigo, aliado, o obstaculo lo retorna cc null
    public GameObject estaOcupada() {
    	int i=1;
    	while (!estaOcupada && i<3) {
    		if(listaObjetosLogicos[i]!=null) {
    			estaOcupada=true;
    		}
    	}
    	return listaObjetosLogicos[i];
	}
    
}