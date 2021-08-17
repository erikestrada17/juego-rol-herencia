package general;

import clases.Elfo;
import clases.Guerrero;
import clases.Item;
import clases.Mago;

public class Jugador {
    private String nombre;
    private int nroPers;
    private Mago mago;
	private Guerrero guerrero;
    private Elfo elfo;
    private Item[] inventario = new Item[20];
    private int cantItems = 0;
    private Item[] equipo = new Item[6];
    private int cantItemsE = 0;

	public Jugador(String nombre, int nroPers) {
        this.nombre = nombre;
        if(nroPers==1) {
        	mago = new Mago();
        }
        else if(nroPers==2) {
        	guerrero = new Guerrero();
        }
        else if(nroPers==3) {
        	elfo = new Elfo();
        }
        equipo[0] = new Item("Vestimenta de principiante", 0, true);
        cantItemsE++;
        
        this.nroPers = nroPers;
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

	public Item[] getInventario() {
		return inventario;
	}
	
	public int getNroPers() {
		return nroPers;
	}

	public int getCantItems() {
		return cantItems;
	}

	public void setCantItems(int cantItems) {
		this.cantItems = cantItems;
	}
	
	public int getCantItemsE() {
		return cantItemsE;
	}

	public void setCantItemsE(int cantItemsE) {
		this.cantItemsE = cantItemsE;
	}

	public Item[] getEquipo() {
		return equipo;
	}

}
