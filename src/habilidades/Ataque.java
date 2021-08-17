package habilidades;

public class Ataque {
    protected String nombre;
    protected int dañoMin;
    protected int dañoMax;

	public Ataque(String nombre, int dañoMin, int dañoMax) {
		this.nombre = nombre;
		this.dañoMin = dañoMin;
		this.dañoMax = dañoMax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDañoMin() {
		return dañoMin;
	}

	public int getDañoMax() {
		return dañoMax;
	}

}
