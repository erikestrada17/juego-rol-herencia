package clases;

import habilidades.*;

public class Mago extends Personaje {

    public Mago() {
        super(1000, 10, 350, 50, 50);
        this.ataques[0] = new Ataque("Puñetazo", 1, 30);
        this.ataques[1] = new Ataque("Bastonazo", 5, 20);
        this.ataques[2] = new Ataque("Palabra de elementos", 4, 10);
        this.ataques[3] = new Ataque("Vuelo helado", 2, 8);
        this.ataques[4] = new Ataque("Parpadeo", 5, 8);
        this.hechizos[0] = new Hechizo("Magia negra", 100, 400, 100);
        this.hechizos[1] = new Hechizo("Magia blanca", 100, 300, 75); // recupera vida
        this.hechizos[2] = new Hechizo("Bola de poder", 50, 200, 50);
        this.hechizos[3] = new Hechizo("Desintegrar", 150, 500, 150);
        this.hechizos[4] = new Hechizo("Llamarada", 50, 100 ,75);
    }
}
