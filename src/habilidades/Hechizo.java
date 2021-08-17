package habilidades;

public class Hechizo extends Ataque{
	private int costo;

	public Hechizo(String nombre, int da�oMin, int da�oMax, int costo) {
		super(nombre, da�oMin, da�oMax);
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
}
