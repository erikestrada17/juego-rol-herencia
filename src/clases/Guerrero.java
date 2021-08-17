package clases;

import habilidades.Ataque;
import habilidades.Hechizo;

public class Guerrero extends Personaje {

    public Guerrero() {
        super(1200, 20, 200, 150, 100);
        this.ataques[0] = new Ataque("Puñetazo", 1, 30);
        this.ataques[1] = new Ataque("Terremoto", 5, 20);
        this.ataques[2] = new Ataque("Fuerza implacable", 1, 40);
        this.ataques[3] = new Ataque("Patada", 10, 15);
        this.ataques[4] = new Ataque("Estruendo de trueno", 30, 40);
        this.hechizos[0] = new Hechizo("Rayo", 50, 350, 50);
        this.hechizos[1] = new Hechizo("Curar heridas", 100, 250, 30);
        this.hechizos[2] = new Hechizo("Espada sagrada", 80, 160, 75);
        this.hechizos[3] = new Hechizo("Impulso de acero", 30, 70, 30);
        this.hechizos[4] = new Hechizo("Explosión de furia", 80, 150, 40);
    }

}
