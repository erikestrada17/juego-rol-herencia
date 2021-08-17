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
		int curacionMin = this.hechizos[indHechizo].getDa�oMin();
		int curacionMax = this.hechizos[indHechizo].getDa�oMax();
		
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
			System.out.println(">Curaci�n: " + curacion + " puntos de vida");
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
			System.out.println(">Curaci�n: " + curacion + " puntos de vida");
		}
	}
	
	public void atacar(int indAtaque, int turno, Jugador jugador, Enemigo enemigo){
		
		int da�oMin = this.ataques[indAtaque].getDa�oMin();
		int da�oMax = this.ataques[indAtaque].getDa�oMax();
				
		int da�o = (Utiles.r.nextInt(da�oMax-da�oMin+1)+da�oMin)*this.getFuerza();	
		
		if(turno == 0) { // ataca el usuario
				System.out.println();
				if(enemigo.getRan() == 1){
					if( (da�o - enemigo.getMago().getDefensaFisica()) > 0){ 
						enemigo.getMago().restarVida(da�o - enemigo.getMago().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
						System.out.println(">Da�o final: " + (da�o - enemigo.getMago().getDefensaFisica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				}else if(enemigo.getRan() == 2){
					if( (da�o - enemigo.getGuerrero().getDefensaFisica()) > 0){ 
						enemigo.getGuerrero().restarVida(da�o - enemigo.getGuerrero().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
						System.out.println(">Da�o final: " + (da�o - enemigo.getGuerrero().getDefensaFisica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				}else{
					if( (da�o - enemigo.getElfo().getDefensaFisica()) > 0){ 
						enemigo.getElfo().restarVida(da�o - enemigo.getElfo().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
						System.out.println(">Da�o final: " + (da�o - enemigo.getElfo().getDefensaFisica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				} 
		}else { // ataca el enemigo
			System.out.println();
			if(jugador.getMago() != null){
				if( (da�o - jugador.getMago().getDefensaFisica()) > 0){ 
					jugador.getMago().restarVida(da�o - jugador.getMago().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
					System.out.println(">Da�o final: " + (da�o - jugador.getMago().getDefensaFisica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
				}
			}else if(jugador.getGuerrero() != null){
				if( (da�o - jugador.getGuerrero().getDefensaFisica()) > 0){ 
					jugador.getGuerrero().restarVida(da�o - jugador.getGuerrero().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
					System.out.println(">Da�o final: " + (da�o - jugador.getGuerrero().getDefensaFisica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
				}
			}else{
				if( (da�o - jugador.getMago().getDefensaFisica()) > 0){ 
					jugador.getElfo().restarVida(da�o - jugador.getElfo().getDefensaFisica()); // el da�o se ve reducido por la defensa f�sica
					System.out.println(">Da�o final: " + (da�o - jugador.getElfo().getDefensaFisica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
				}
			} 
 		}
	}
	
	public void hechizar(int indHechizo, int turno, Jugador jugador, Enemigo enemigo){
		int da�oMin = this.hechizos[indHechizo].getDa�oMin();
		int da�oMax = this.hechizos[indHechizo].getDa�oMax();
		
		int da�o = (Utiles.r.nextInt(da�oMax-da�oMin+1)+da�oMin);
		
		this.restarMagia(this.hechizos[indHechizo].getCosto());	
		
		if(turno == 0) { // hechiza el usuario
				System.out.println();
				if(enemigo.getRan() == 1){
					if( (da�o - enemigo.getMago().getDefensaMagica()) > 0){ 
						enemigo.getMago().restarVida(da�o - enemigo.getMago().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
						System.out.println(">Da�o final: " + (da�o - enemigo.getMago().getDefensaMagica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				}else if(enemigo.getRan() == 2){
					if( (da�o - enemigo.getGuerrero().getDefensaMagica()) > 0){ 
						enemigo.getGuerrero().restarVida(da�o - enemigo.getGuerrero().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
						System.out.println(">Da�o final: " + (da�o - enemigo.getGuerrero().getDefensaMagica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				}else{
					if( (da�o - enemigo.getElfo().getDefensaMagica()) > 0){ 
						enemigo.getElfo().restarVida(da�o - enemigo.getElfo().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
						System.out.println(">Da�o final: " + (da�o - enemigo.getElfo().getDefensaMagica()));
					}else{
						da�o = 0; // si el da�o es menor que la defensa
						System.out.println(">Da�o final: " + da�o);
					}
				} 
		}else { // hechiza el enemigo
			System.out.println();
			if(jugador.getMago() != null){
				if( (da�o - jugador.getMago().getDefensaMagica()) > 0){ 
					jugador.getMago().restarVida(da�o - jugador.getMago().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
					System.out.println(">Da�o final: " + (da�o - jugador.getMago().getDefensaMagica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
				}
			}else if(jugador.getGuerrero() != null){
				if( (da�o - jugador.getGuerrero().getDefensaMagica()) > 0){
					jugador.getGuerrero().restarVida(da�o - jugador.getGuerrero().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
					System.out.println(">Da�o final: " + (da�o - jugador.getGuerrero().getDefensaMagica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
				}
			}else{
				if( (da�o - jugador.getElfo().getDefensaMagica()) > 0){ 
					jugador.getElfo().restarVida(da�o - jugador.getElfo().getDefensaMagica()); // el da�o se ve reducido por la defensa m�gica
					System.out.println(">Da�o final: " + (da�o - jugador.getElfo().getDefensaMagica()));
				}else{
					da�o = 0; // si el da�o es menor que la defensa
					System.out.println(">Da�o final: " + da�o);
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
