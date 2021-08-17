package clases;

import utiles.Utiles;
import general.Enemigo;
import general.Jugador;
import habilidades.*;


public abstract class Personaje {
	protected int vida;
	protected int vidaMax;
	protected int fuerza;
	protected int magia;
	protected int magiaMax;
	protected int defensaFisica;
	protected int defensaMagica;
	protected Ataque[] ataques = new Ataque[5];
	protected Hechizo[] hechizos = new Hechizo[5];
	
	public Personaje(int vida, int fuerza, int magia, int defensaFisica, int defensaMagica) {
		this.vida = vida;
		this.vidaMax = vida;
		this.fuerza = fuerza;
		this.magia = magia;
		this.magiaMax = magia;
		this.defensaFisica = defensaFisica;
		this.defensaMagica = defensaMagica;
	}

	public void curar(int indHechizo, int turno, Jugador jugador, Enemigo enemigo) {
		int curacionMin = this.hechizos[indHechizo].getDañoMin();
		int curacionMax = this.hechizos[indHechizo].getDañoMax();
		
		int curacion = (Utiles.r.nextInt(curacionMax-curacionMin+1)+curacionMin);
		
		this.restarMagia(this.hechizos[indHechizo].getCosto()); // restar magia del hechizo
		
		if(turno == 0) { // se cura el usuario
			System.out.println();
			if(jugador.getMago() != null){
				if( (jugador.getMago().getVida()+curacion) >= jugador.getMago().getVidaMax()){ 
					jugador.getMago().setVida(jugador.getMago().getVidaMax());
				}else{
					jugador.getMago().sumarVida(curacion); // mago
				}
			}else if(jugador.getGuerrero() != null){
				if( (jugador.getGuerrero().getVida()+curacion) >= jugador.getGuerrero().getVidaMax() ){ 
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVidaMax());
				}else{
					jugador.getGuerrero().sumarVida(curacion); // guerrero
				}
			}else{
				if( (jugador.getElfo().getVida()+curacion) >= jugador.getElfo().getVidaMax() ){ 
					jugador.getElfo().setVida(jugador.getElfo().getVidaMax());
				}else{
					jugador.getElfo().sumarVida(curacion); // elfo
				}
			} 
			System.out.println(">Curación: " + curacion + " puntos de vida");
		}else { // se cura el enemigo
			System.out.println();
			if(enemigo.getRan() == 1){
				if( (enemigo.getMago().getVida()+curacion) >= enemigo.getMago().getVidaMax() ){ 
					enemigo.getMago().setVida(enemigo.getMago().getVidaMax());
				}else{
					enemigo.getMago().sumarVida(curacion); // mago
				}
			}else if(enemigo.getRan() == 2){
				if( (enemigo.getGuerrero().getVida()+curacion) >= enemigo.getGuerrero().getVidaMax() ){ 
					enemigo.getGuerrero().setVida(enemigo.getGuerrero().getVidaMax());
				}else{
					enemigo.getGuerrero().sumarVida(curacion); // guerrero
				}
			}else{
				if( (enemigo.getElfo().getVida()+curacion) >= enemigo.getElfo().getVidaMax() ){ 
					enemigo.getElfo().setVida(enemigo.getElfo().getVidaMax());
				}else{
					enemigo.getElfo().sumarVida(curacion); // elfo
				}
			} 
			System.out.println(">Curación: " + curacion + " puntos de vida");
		}
	}
	
	public void atacar(int indAtaque, int turno, Jugador jugador, Enemigo enemigo){
		
		int dañoMin = this.ataques[indAtaque].getDañoMin();
		int dañoMax = this.ataques[indAtaque].getDañoMax();
				
		int daño = (Utiles.r.nextInt(dañoMax-dañoMin+1)+dañoMin)*this.getFuerza();	
		
		if(turno == 0) { // ataca el usuario
				System.out.println();
				if(enemigo.getRan() == 1){
					if( (daño - enemigo.getMago().getDefensaFisica()) > 0){ 
						enemigo.getMago().restarVida(daño - enemigo.getMago().getDefensaFisica()); // el daño se ve reducido por la defensa física
						System.out.println(">Daño final: " + (daño - enemigo.getMago().getDefensaFisica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				}else if(enemigo.getRan() == 2){
					if( (daño - enemigo.getGuerrero().getDefensaFisica()) > 0){ 
						enemigo.getGuerrero().restarVida(daño - enemigo.getGuerrero().getDefensaFisica()); // el daño se ve reducido por la defensa física
						System.out.println(">Daño final: " + (daño - enemigo.getGuerrero().getDefensaFisica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				}else{
					if( (daño - enemigo.getElfo().getDefensaFisica()) > 0){ 
						enemigo.getElfo().restarVida(daño - enemigo.getElfo().getDefensaFisica()); // el daño se ve reducido por la defensa física
						System.out.println(">Daño final: " + (daño - enemigo.getElfo().getDefensaFisica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				} 
		}else { // ataca el enemigo
			System.out.println();
			if(jugador.getMago() != null){
				if( (daño - jugador.getMago().getDefensaFisica()) > 0){ 
					jugador.getMago().restarVida(daño - jugador.getMago().getDefensaFisica()); // el daño se ve reducido por la defensa física
					System.out.println(">Daño final: " + (daño - jugador.getMago().getDefensaFisica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			}else if(jugador.getGuerrero() != null){
				if( (daño - jugador.getGuerrero().getDefensaFisica()) > 0){ 
					jugador.getGuerrero().restarVida(daño - jugador.getGuerrero().getDefensaFisica()); // el daño se ve reducido por la defensa física
					System.out.println(">Daño final: " + (daño - jugador.getGuerrero().getDefensaFisica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			}else{
				if( (daño - jugador.getMago().getDefensaFisica()) > 0){ 
					jugador.getElfo().restarVida(daño - jugador.getElfo().getDefensaFisica()); // el daño se ve reducido por la defensa física
					System.out.println(">Daño final: " + (daño - jugador.getElfo().getDefensaFisica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			} 
 		}
	}
	
	public void hechizar(int indHechizo, int turno, Jugador jugador, Enemigo enemigo){
		int dañoMin = this.hechizos[indHechizo].getDañoMin();
		int dañoMax = this.hechizos[indHechizo].getDañoMax();
		
		int daño = (Utiles.r.nextInt(dañoMax-dañoMin+1)+dañoMin);
		
		this.restarMagia(this.hechizos[indHechizo].getCosto());	
		
		if(turno == 0) { // hechiza el usuario
				System.out.println();
				if(enemigo.getRan() == 1){
					if( (daño - enemigo.getMago().getDefensaMagica()) > 0){ 
						enemigo.getMago().restarVida(daño - enemigo.getMago().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
						System.out.println(">Daño final: " + (daño - enemigo.getMago().getDefensaMagica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				}else if(enemigo.getRan() == 2){
					if( (daño - enemigo.getGuerrero().getDefensaMagica()) > 0){ 
						enemigo.getGuerrero().restarVida(daño - enemigo.getGuerrero().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
						System.out.println(">Daño final: " + (daño - enemigo.getGuerrero().getDefensaMagica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				}else{
					if( (daño - enemigo.getElfo().getDefensaMagica()) > 0){ 
						enemigo.getElfo().restarVida(daño - enemigo.getElfo().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
						System.out.println(">Daño final: " + (daño - enemigo.getElfo().getDefensaMagica()));
					}else{
						daño = 0; // si el daño es menor que la defensa
						System.out.println(">Daño final: " + daño);
					}
				} 
		}else { // hechiza el enemigo
			System.out.println();
			if(jugador.getMago() != null){
				if( (daño - jugador.getMago().getDefensaMagica()) > 0){ 
					jugador.getMago().restarVida(daño - jugador.getMago().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
					System.out.println(">Daño final: " + (daño - jugador.getMago().getDefensaMagica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			}else if(jugador.getGuerrero() != null){
				if( (daño - jugador.getGuerrero().getDefensaMagica()) > 0){
					jugador.getGuerrero().restarVida(daño - jugador.getGuerrero().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
					System.out.println(">Daño final: " + (daño - jugador.getGuerrero().getDefensaMagica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			}else{
				if( (daño - jugador.getElfo().getDefensaMagica()) > 0){ 
					jugador.getElfo().restarVida(daño - jugador.getElfo().getDefensaMagica()); // el daño se ve reducido por la defensa mágica
					System.out.println(">Daño final: " + (daño - jugador.getElfo().getDefensaMagica()));
				}else{
					daño = 0; // si el daño es menor que la defensa
					System.out.println(">Daño final: " + daño);
				}
			} 
 		}
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getDefensaFisica() {
		return defensaFisica;
	}

	public void setDefensaFisica(int defensaFisica) {
		this.defensaFisica = defensaFisica;
	}

	public int getDefensaMagica() {
		return defensaMagica;
	}

	public void setDefensaMagica(int defensaMagica) {
		this.defensaMagica = defensaMagica;
	}

	public Ataque[] getAtaques() {
		return ataques;
	}

	public Hechizo[] getHechizos() {
		return hechizos;
	}

	public void restarVida(int vida){
		this.vida-=vida;
	}
	
	public void restarMagia(int magia){
		this.magia-=magia;
	}
	
	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vida) {
		this.vidaMax = vida;
	}
	
	public void sumarVida(int vida) {
		this.vida+=vida;
	}
	
	public int getMagiaMax() {
		return magiaMax;
	}
	
	public void setMagiaMax(int magiaMax) {
		this.magiaMax = magiaMax;
	}

	public void usarTrucoMagia() {
		this.magia += 200;
		this.magiaMax += 200;
	}

	public void usarTrucoVida() {
		this.vida += 200;
		this.vidaMax += 200;
	}

}
