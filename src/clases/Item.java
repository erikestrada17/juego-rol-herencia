package clases;

public class Item {
	private String nombre;
	private int tipoEfecto;
	private boolean equipable; // 0- No equipable (consumible) 1- equipable
	// Tipo de Efecto de los items:
	// 0: a�ade 100 vida, 4 de fuerza y 25 de magia
	// 1: recupera 200 vida
	// 2: recupera 50 magia
	// 3: a�ade 200 vida, muy poca posibilidad de salir item
	// 4: a�ade 200 magia y 100 vida, solo para mago
	// 5: a�ade 300 vida, solo para guerrero
	// 6: a�ade 8 fuerza, solo para guerrero
	// 7: a�ade 5 fuerza, solo para elfo
	// 8: perder 400 vida o recuperar 400 vida
	// 9: a�ade 200 magia, solo para mago
	// 10: a�ade 7 fuerza, solo para guerrero
	// 11: a�ade 150 vida, solo para elfo
	// 12: a�ade 250 vida, 150 magia y 4 vida
	// Otros efectos para generarEvento:
	// ...(ninguno por ahora).

	public Item(String nombre, int tipoEfecto, boolean equipable) {
		this.nombre = nombre;
		this.tipoEfecto = tipoEfecto;
		this.equipable = equipable;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTipoEfecto() {
		return tipoEfecto;
	}

	public boolean isEquipable() {
		return equipable;
	}

}
