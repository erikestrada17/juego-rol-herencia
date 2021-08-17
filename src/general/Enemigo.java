package general;

import utiles.Utiles;
import clases.Elfo;
import clases.Guerrero;
import clases.Mago;

public class Enemigo {
	
	private String[] nombres = {"Bungee","Isley","Mhar","Bowen","Iced","Erudian"};
	private int indAleatorio = Utiles.r.nextInt(nombres.length)+1;
	private String nombre = nombres[indAleatorio-1];
	private Mago mago;
	private Guerrero guerrero;
	private Elfo elfo;
	private int ran;
	
    public Enemigo() {
        ran = Utiles.r.nextInt(3)+1;
        if(ran == 1) {
        	mago = new Mago();
        }else if(ran == 2){
        	guerrero = new Guerrero();
        }else{
        	elfo = new Elfo();
        }
    }

	public String getNombre() {
		return nombre;
	}

	public Mago getMago() {
		return mago;
	}

	public Guerrero getGuerrero() {
		return guerrero;
	}

	public Elfo getElfo() {
		return elfo;
	}
	
	public int getRan() {
		return ran;
	}

}
