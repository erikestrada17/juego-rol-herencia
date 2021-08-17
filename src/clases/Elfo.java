package clases;

import habilidades.Ataque;
import habilidades.Hechizo;

public class Elfo extends Personaje {
	

    public Elfo() {
        super(2000, 5, 200, 100, 175);
        this.ataques[0] = new Ataque("Puñetazo", 1, 30);
        this.ataques[1] = new Ataque("Hada fantasma", 5, 10);
        this.ataques[2] = new Ataque("Flecha de hada", 2, 8);
        this.ataques[3] = new Ataque("Poder de la naturaleza", 6 ,12);
        this.ataques[4] = new Ataque("Alabanza de la flor", 2, 10);
        this.hechizos[0] = new Hechizo("Conjuro", 20, 200, 50);
        this.hechizos[1] = new Hechizo("Purificación", 100, 150, 50);
        this.hechizos[2] = new Hechizo("Proyección astral", 70, 150, 100);
        this.hechizos[3] = new Hechizo("Tormenta divina", 50, 100, 25);
        this.hechizos[4] = new Hechizo("Palabra sagrada", 30, 90, 40);
    }

}
