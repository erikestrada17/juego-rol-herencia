package habilidades;

public class Hechizo extends Ataque{
	private int costo;

	public Hechizo(String nombre, int dañoMin, int dañoMax, int costo) {
		super(nombre, dañoMin, dañoMax);
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
}
