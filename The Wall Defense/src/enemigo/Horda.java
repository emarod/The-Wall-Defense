package enemigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.JLabel;

import interfaz.Escenario;
import main.GameObject;
import mapa.Celda;
import mapa.Map;
import enemigo.Enemigo;

public class Horda {
	
	protected Enemigo horda[];
	protected Celda celda;
	protected Map mapa;
	protected Escenario stage;
	protected JLabel graf;
	protected int enemigos=0;
	
	public Horda(Escenario s){	
		stage=s;
		mapa=stage.getMapa();
		horda=new Enemigo[1];
		int t= (int) (Math.random()*1);
		try {
			inicializarHorda(t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void inicializarHorda(int t) throws FileNotFoundException, IOException {
	    String sCurrentLine="";
	    Random rnd=new Random();
	    int r=rnd.nextInt(1);
	    //Este es un random limitado entre 1 y 3, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	r = (int) (Math.random()*2);
	    InputStream fileHorda = getClass().getResourceAsStream("/resources/horda_"+r+".txt");
        InputStreamReader entradaHorda = new InputStreamReader(fileHorda);
        
	    BufferedReader bufferHorda = new BufferedReader(entradaHorda);
	    
	    int y;
	    while ((sCurrentLine = bufferHorda.readLine()) != null) {
	    	for (int x=0;x<sCurrentLine.length();x++){
	    		y= (int) (Math.random()*5);
	    		char tipo =sCurrentLine.charAt(x);
	    		Celda c = mapa.getCelda(15, y);
	    		GameObject[] objetos= c.getObjects();
	    		Celda[] celdas = new Celda[4];
	    		Enemigo e;
	    		switch(tipo){
		  	   		case 'a':
		    		case 'b':
		    		case 'c':
		    		case 'd':
		    		case 'e':
		    			celdas[0] = c;
		    			e = new Enemigo(celdas,2, new WhiteWalker());
		    			objetos[2] = e;
		    			mapa.crearEnemigo(e, x, y);
		    			enemigos++;
		    			break;
		    		case 'f':
		    		case 'g':
		    		case 'h':
		    		case 'i':
		    		case 'j':
		    		case 'k':
		    		case 'l':
		    		case 'm':
		    		case 'n':
		    			celdas[0] = c;
		    			e = new Enemigo(celdas,2, new NightKing());
		    			objetos[2] = e;
		    			mapa.crearEnemigo(e, x, y);
		    			enemigos++;
		    			break;
		    		case 'o':
		    		case 'p':
		    		case 'q':
		    		case 'r':
		    		case 's':
		    		case 't':
		    		case 'u':
		    		case 'v':
		    		case 'w':
		    		case 'x':
		    		case 'y':
		    		case 'z':
		    		case '1':
		    		case '2':
		    		case '3':
		    		case '4':
		    		case '5':
		    		case '6':
		    		case '7':
	    		}
    		}
	    }
	    	
	    bufferHorda.close();
    }
	
}