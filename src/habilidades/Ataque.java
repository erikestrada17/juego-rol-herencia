package habilidades;

public class Ataque {
    protected String nombre;
    protected int da�oMin;
    protected int da�oMax;

	public Ataque(String nombre, int da�oMin, int da�oMax) {
		this.nombre = nombre;
		this.da�oMin = da�oMin;
		this.da�oMax = da�oMax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDa�oMin() {
		return da�oMin;
	}

	public int getDa�oMax() {
		return da�oMax;
	}

}
