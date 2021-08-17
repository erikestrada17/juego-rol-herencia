
import clases.Item;
import general.Enemigo;
import general.Jugador;
import utiles.Utiles;

public class Principal {

	static Jugador jugador;
	static Enemigo enemigo;
	static int opc = 0;
	static int turno = 0;

	static String[][] items = { { "Vestimenta de principiante", "0", "true" }, { "Poción de vida", "1", "false" },
			{ "Poción de magia", "2", "false" }, { "Santo grial", "3", "false" }, { "Túnica de mago", "4", "true" },
			{ "Armadura de guerrero", "5", "true" }, { "Lanza de longinos", "6", "true" }, { "Bastón", "7", "true" },
			{ "Item misterioso", "8", "true" }, { "Vara de mago", "9", "true" },
			{ "Espada del guerrero", "10", "true" }, { "Bastón de elfo", "11", "true" },
			{ "Espada del poder", "12", "true" }, { "Arma Legendaria", "13", "true" } };

	public static void main(String[] args) {
		System.out.println("¡¡¡Bienvenido al juego de ROL!!!");
		Utiles.delay(2000);
		System.out.println("\nIngrese su nombre: ");
		String nombre = Utiles.s.nextLine();

		System.out.println("\nSeleccione un personaje (1-Mago/2-Guerrero/3-Elfo): ");
		int nroPers = Utiles.ingresarEntero(1, 3);
		jugador = new Jugador(nombre, nroPers);

		do {
			mostrarMenu();
			opc = Utiles.ingresarEntero(1, 6);
			if (opc == 0) {
				generarItem();
				Utiles.delay(1500);
			} else if (opc == -1) {
				if (jugador.getNroPers() == 1) {
					jugador.getMago().usarTrucoMagia();
				} else if (jugador.getNroPers() == 2) {
					jugador.getGuerrero().usarTrucoMagia();
				} else {
					jugador.getElfo().usarTrucoMagia();
				}
				Utiles.delay(1500);
			} else if (opc == -2) {
				if (jugador.getNroPers() == 1) {
					jugador.getMago().usarTrucoVida();
				} else if (jugador.getNroPers() == 2) {
					jugador.getGuerrero().usarTrucoVida();
				} else {
					jugador.getElfo().usarTrucoVida();
				}
				Utiles.delay(1500);
			}
			generarAccion(opc);
			Utiles.delay(1500);
		} while (opc != 6);

	}

	private static void mostrarYEjecutarAtaque() {
		boolean repite = false;
		do{
			repite = false;
			System.out.println("---------------------------------------");
			if (jugador.getNroPers() == 1) { // mago
				for (int i = 0; i < jugador.getMago().getAtaques().length; i++) {
					System.out.println("Ataque N°" + (i+1) + " Nombre: " + jugador.getMago().getAtaques()[i].getNombre() + ", daño entre " + (jugador.getMago().getAtaques()[i].getDañoMin()*jugador.getMago().getFuerza()) + " y " + (jugador.getMago().getAtaques()[i].getDañoMax()*jugador.getMago().getFuerza()) );
				}
				int ataque = Utiles.ingresarEntero(1, jugador.getMago().getAtaques().length)-1;
				jugador.getMago().atacar(ataque, turno, jugador, enemigo);
				System.out.println(">Has utilizado el ataque: " + jugador.getMago().getAtaques()[ataque].getNombre());
				Utiles.delay(3000);
			} else if(jugador.getNroPers() == 2) { // guerrero
				for (int i = 0; i < jugador.getGuerrero().getAtaques().length; i++) {
					System.out.println("Ataque N°" + (i+1) + " Nombre: " + jugador.getGuerrero().getAtaques()[i].getNombre() + ", daño entre " + (jugador.getGuerrero().getAtaques()[i].getDañoMin()*jugador.getGuerrero().getFuerza()) + " y " + (jugador.getGuerrero().getAtaques()[i].getDañoMax()*jugador.getGuerrero().getFuerza()) );
				}
				int ataque = Utiles.ingresarEntero(1, jugador.getGuerrero().getAtaques().length)-1;
				jugador.getGuerrero().atacar(ataque, turno, jugador, enemigo);
				System.out.println(">Has utilizado el ataque: " + jugador.getGuerrero().getAtaques()[ataque].getNombre());
				Utiles.delay(3000);
			} else{ // elfo
				for (int i = 0; i < jugador.getElfo().getAtaques().length; i++) {
					System.out.println("Ataque N°" + (i+1) + " Nombre: " + jugador.getElfo().getAtaques()[i].getNombre() + ", daño entre " + (jugador.getElfo().getAtaques()[i].getDañoMin()*jugador.getElfo().getFuerza()) + " y " + (jugador.getElfo().getAtaques()[i].getDañoMax()*jugador.getElfo().getFuerza()) );
				}
				int ataque = Utiles.ingresarEntero(1, jugador.getElfo().getAtaques().length)-1;
				jugador.getElfo().atacar(ataque, turno, jugador, enemigo);
				System.out.println(">Has utilizado el ataque: " + jugador.getElfo().getAtaques()[ataque].getNombre());
				Utiles.delay(3000);
			}
			System.out.println("---------------------------------------");
		}while(repite);
	}

	private static void mostrarYEjecutarHechizo() {
		boolean repite = false;
		do{
			repite = false;
			System.out.println("---------------------------------------");
			if (jugador.getNroPers() == 1) { // hechizos del mago
				for (int i = 0; i < jugador.getMago().getHechizos().length; i++) {
					if(jugador.getMago().getHechizos()[i].getNombre().equals("Magia blanca")){
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getMago().getHechizos()[i].getNombre() + ", curación entre " + jugador.getMago().getHechizos()[i].getDañoMin() + " y " + jugador.getMago().getHechizos()[i].getDañoMax());
					}else{
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getMago().getHechizos()[i].getNombre() + ", daño entre " + jugador.getMago().getHechizos()[i].getDañoMin() + " y " + jugador.getMago().getHechizos()[i].getDañoMax());
					}
				}
				int hechizo = Utiles.ingresarEntero(1, jugador.getMago().getHechizos().length)-1; // selecciona hechizo
				if (jugador.getMago().getMagia() >= jugador.getMago().getHechizos()[hechizo].getCosto()) {
					if(hechizo == 1){ // magia blanca cura al personaje
						jugador.getMago().curar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo magia blanca");
						Utiles.delay(3000);
					}else{
						jugador.getMago().hechizar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo: " + jugador.getMago().getHechizos()[hechizo].getNombre());
						Utiles.delay(3000);
					}
				} else{
					System.out.println(">No tiene magia para utilizar el hechizo " + jugador.getMago().getHechizos()[hechizo].getNombre());
					Utiles.delay(3000);
					System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
					int rta = Utiles.ingresarEntero(1, 2);
					if(rta == 1){
						mostrarYEjecutarAtaque();
					}else{
						mostrarYEjecutarHechizo();
					}
				}
			} else if (jugador.getNroPers() == 2) { // hechizos del guerrero
				for (int i = 0; i < jugador.getGuerrero().getHechizos().length; i++) {
					if(jugador.getGuerrero().getHechizos()[i].getNombre().equals("Curar heridas")){
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getGuerrero().getHechizos()[i].getNombre() + ", curación entre " + jugador.getGuerrero().getHechizos()[i].getDañoMin() + " y " + jugador.getGuerrero().getHechizos()[i].getDañoMax());
					}else{
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getGuerrero().getHechizos()[i].getNombre() + ", daño entre " + jugador.getGuerrero().getHechizos()[i].getDañoMin() + " y " + jugador.getGuerrero().getHechizos()[i].getDañoMax());
					}
				}
				int hechizo = Utiles.ingresarEntero(1, jugador.getGuerrero().getHechizos().length)-1; // selecciona hechizo
				if (jugador.getGuerrero().getMagia() >= jugador.getGuerrero().getHechizos()[hechizo].getCosto()) {
					if(hechizo == 1){ // curar heridas para sanar al personaje
						jugador.getGuerrero().curar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo curar heridas");
						Utiles.delay(3000);
					}else{
						jugador.getGuerrero().hechizar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo: " + jugador.getGuerrero().getHechizos()[hechizo].getNombre());
						Utiles.delay(3000);
					}
				} else {
					System.out.println(">No tiene magia para utilizar el hechizo " + jugador.getGuerrero().getHechizos()[hechizo].getNombre());
					Utiles.delay(3000);
					System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
					int rta = Utiles.ingresarEntero(1, 2);
					if(rta == 1){
						mostrarYEjecutarAtaque();
					}else{
						mostrarYEjecutarHechizo();
					}
				}
			} else{ // hechizos del elfo
				for (int i = 0; i < jugador.getElfo().getHechizos().length; i++) {
					if(jugador.getElfo().getHechizos()[i].getNombre().equals("Purificación")){
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getElfo().getHechizos()[i].getNombre() + ", curación entre " + jugador.getElfo().getHechizos()[i].getDañoMin() + " y " + jugador.getElfo().getHechizos()[i].getDañoMax());
					}else{
						System.out.println("Hechizo N°" + (i+1) + " Nombre: " + jugador.getElfo().getHechizos()[i].getNombre() + ", daño entre " + jugador.getElfo().getHechizos()[i].getDañoMin() + " y " + jugador.getElfo().getHechizos()[i].getDañoMax());
					}
				}
				
				int hechizo = Utiles.ingresarEntero(1, jugador.getElfo().getHechizos().length)-1; // selecciona hechizo
				if (jugador.getElfo().getMagia() >= jugador.getElfo().getHechizos()[hechizo].getCosto()) {
					if(hechizo == 1){ // purificación para curar al personaje
						jugador.getElfo().curar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo purificación");
						Utiles.delay(3000);
					}else{
						jugador.getElfo().hechizar(hechizo, turno, jugador, enemigo);
						System.out.println(">Has utilizado el hechizo: " + jugador.getElfo().getHechizos()[hechizo].getNombre());
						Utiles.delay(3000);
					}
				} else {
					System.out.println(">No tiene magia para utilizar el hechizo " + jugador.getElfo().getHechizos()[hechizo].getNombre());
					Utiles.delay(3000);
					System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
					int rta = Utiles.ingresarEntero(1, 2);
					if(rta == 1){
						mostrarYEjecutarAtaque();
					}else{
						mostrarYEjecutarHechizo();
					}
				}
			}
			System.out.println("---------------------------------------");
		}while(repite);
	}

	private static void generarAccion(int opc) {
		int ran;
		switch (opc) {
		case 1:
			ran = Utiles.r.nextInt(2);
			if (ran == 0) {
				generarEvento();
				
			} else {
				System.out.println(">Has avanzado");
				System.out.println(">No has encontrado nada");
			}
			break;
		case 2:
			ran = Utiles.r.nextInt(2);
			if (ran == 0) {
				generarEvento();
			} else {
				System.out.println(">Has girado a la derecha");
				System.out.println(">No has encontrado nada");
			}
			break;
		case 3:
			ran = Utiles.r.nextInt(2);
			if (ran == 0) {
				generarEvento();
			} else {
				System.out.println(">Has girado a la izquierda");
				System.out.println(">No has encontrado nada");
			}
			break;
		case 4:
			accederInventario();
			break;
		case 5:
			accederEquipo();
			break;
		case 6:
			System.out.println("/>[Fin del juego]");
			break;
		}

	}
	
	private static void generarEvento() { //TODO generarEvento
		int cantEventos = 0; //cantEventos++;
		int evento = Utiles.r.nextInt(111) + 1;
		if (evento >= 1 && evento <= 25) {
			System.out.println(">Se encontró una Poción de vida");
			System.out.println("1) Consumir");
			System.out.println("2) Guardar");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1) {
				generarEfecto(1);
			} else if (res == 2) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("poción de vida")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">" + nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">" + nombre + " arrojado");
				}
			} else {
				System.out.println(">Has arrojado la Poción de vida.");
			}
		} else if (evento > 25 && evento <= 40) {
			System.out.println(">Se encontró un Ítem misterioso");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("item misterioso")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				System.out.println(">Has arrojado el Ítem misterioso.");
			}
		} else if (evento > 40 && evento <= 55) {
			System.out.println(">Se encontró una vara de mago");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1 && jugador.getNroPers() == 1) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("vara de mago")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				if (jugador.getNroPers() != 1 && res == 1) {
					System.out.println(">No puedes tomar un item solo para mago");
				}
				System.out.println(">Has arrojado la vara de mago.");
			}
		} else if (evento > 55 && evento <= 65) {
			System.out.println(">Se encontró una espada del guerrero");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1 && jugador.getNroPers() == 2) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("espada del guerrero")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				if (jugador.getNroPers() != 2 && res == 1) {
					System.out.println(">No puedes tomar un item solo para guerrero");
				}
				System.out.println(">Has arrojado la espada del guerrero.");
			}
		} else if (evento > 65 && evento <= 75) {
			System.out.println(">Se encontró un bastón de elfo");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1 && jugador.getNroPers() == 3) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("bastón de elfo")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				if (jugador.getNroPers() != 3 && res == 1) {
					System.out.println(">No puedes tomar un item solo para elfo");
				}
				System.out.println(">Has arrojado el bastón de elfo.");
			}
			
		} else if (evento > 75 && evento <= 80) { // TODO poco probable
			System.out.println(">Se encontró una Espada del Poder");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("espada del poder")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				System.out.println(">Has arrojado la Espada del Poder.");
			}
			
		} else if (evento > 80 && evento <= 95) {
			System.out.println(">Has caído en un pozo poco profundo");
			System.out.println(">Has perdido 300 puntos de vida");
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() - 300);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 300);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() - 300);
			}
			
		} else if (evento > 95 && evento < 105) {
			System.out.println(">Se encontró con un enemigo");
			generarBatalla();
		} else if (evento == 105){ // Arma Legendaria --- muy poco probable
			System.out.println(">Se ha encontrado el Arma Legendaria");
			System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
			int res = Utiles.ingresarEntero(1, 2);
			if (res == 1) {
				int ind = 0;
				for (int i = 0; i < items.length; i++) {
					if (items[i][0].equalsIgnoreCase("arma legendaria")) {
						ind = i;
					}
				}
				String nombre = items[ind][0];
				int tipoEfecto = Integer.parseInt(items[ind][1]);
				boolean equipable = Boolean.parseBoolean(items[ind][2]);
				if (jugador.getCantItems() < jugador.getInventario().length) {
					jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
					System.out.println(">"+ nombre + " guardado");
				} else {
					System.out.println(">No puedes guardar por tener inventario lleno");
					System.out.println(">"+ nombre + " arrojado");
				}
			} else {
				System.out.println(">Has arrojado el Arma Legendaria");
			}
		}else if (evento > 105 && evento <= 107) { // muy poco probable
			System.out.println(">Has caído en una trampa mortal");
			System.out.println(">Pierdes todos tus puntos de vida...");
			opc = 6;
		} else if (evento > 107 && evento <= (108 + cantEventos)) { // muy poco probable, pero crece con cada evento
			System.out.println(">Has encontrado la puerta al castillo");
			System.out.println(">Felicidades, has ganado el juego!!!");
			opc = 6;
		}
		cantEventos++;
	}

	private static void accederInventario() {
		System.out.println("\nLista de Items <seleccione alguno>:");
		for (int i = 0; i < jugador.getCantItems(); i++) {
			System.out.println((i + 1) + ") Nombre: " + jugador.getInventario()[i].getNombre() + " |"
					+ ((jugador.getInventario()[i].isEquipable()) ? "Equipable" : "Consumible") + "|");
		}
		System.out.println((jugador.getCantItems() + 1) + ") Volver al menú");
		int elegido = Utiles.ingresarEntero(1, jugador.getCantItems() + 1);
		if (elegido != jugador.getCantItems() + 1) {
			elegirOpcion(elegido);
		}
	}

	private static void elegirOpcion(int elegido) {
		String nombre = jugador.getInventario()[elegido - 1].getNombre();
		int tipoEfecto = jugador.getInventario()[elegido - 1].getTipoEfecto();
		boolean equipable = jugador.getInventario()[elegido - 1].isEquipable();
		
		System.out.println("1) " + ((equipable) ? "Equipar" : "Consumir") + " item");
		System.out.println("2) Arrojar item");
		System.out.println("3) Volver");
		int opcElegida = Utiles.ingresarEntero(1, 3);
		
		switch (opcElegida) {
		case 1:
			// Equipar o consumir item:
			if (equipable) {
				boolean repetido = false;
				if (jugador.getCantItemsE() > 0) {
					for (int i = 0; i < jugador.getEquipo().length; i++) {
						// se verifica la repetición items con el tipoEfecto como identificador
						// ya que se lo creo como unico tipoEfecto para cada item.
						if (jugador.getEquipo()[i].getTipoEfecto() == tipoEfecto) {
							repetido = true;
						}
					}
				} // sino repetido seguirá valiendo false
				if (jugador.getCantItemsE() < jugador.getEquipo().length && !repetido) { //TODO Contemplar equipo repetido(hecha)
					generarEfecto(jugador.getInventario()[elegido - 1].getTipoEfecto());
					arrojarItem(elegido, jugador.getInventario());
					// (se reutiliza método para quita del inventario el item equipado)
					jugador.setCantItems(jugador.getCantItems()-1);
					jugador.getEquipo()[jugador.getCantItemsE()] = new Item(nombre, tipoEfecto, equipable);
					jugador.setCantItemsE(jugador.getCantItems() + 1); // cantItemsE++
					System.out.println(">" + nombre + " equipado");
				} else {
					System.out.println(">No puedes equiparte " + nombre + ".");
				}

			} else {
				System.out.println(">" + nombre + " consumido");
				generarEfecto(jugador.getInventario()[elegido - 1].getTipoEfecto());
				arrojarItem(elegido, jugador.getInventario()); // quitar item consumido
				jugador.setCantItems(jugador.getCantItems()-1);
			}
			accederInventario();
			break;
		case 2:
			System.out.println(jugador.getInventario()[elegido - 1].getNombre() + " arrojado");
			arrojarItem(elegido, jugador.getInventario());
			jugador.setCantItems(jugador.getCantItems()-1);
			accederInventario();
			break;
		case 3:
			// se puede volver al inventario sin arrojar, equipar o consumir el item.
			accederInventario();
			break;
		}
	}
	
	private static void arrojarItem(int elegido, Item vector[]) {
		// borrar item y ordenar el espacio nulo que causa
		vector[elegido - 1] = null;
		for (int i = 0; i < vector.length - 1; i++) {
			if (vector[i] == null && vector[i + 1] != null) {
				vector[i] = vector[i + 1];
				vector[i + 1] = null;
			}
		}
	}

	private static void accederEquipo() {
		System.out.println("\nItems Equipados <seleccione alguno>:");
		int i;
		for (i = 0; i < jugador.getCantItemsE(); i++) {
			System.out.println((i + 1) + ") Nombre: " + jugador.getEquipo()[i].getNombre());
		}
		System.out.println((jugador.getCantItemsE() + 1) + ") Volver al menú");
		int elegido = Utiles.ingresarEntero(1, jugador.getCantItemsE() + 1);
		if (elegido != jugador.getCantItemsE() + 1) {
			elegirOpcionE(elegido);
		}
	}

	private static void elegirOpcionE(int elegido) {
		System.out.println("1) Desequipar"); // al desequipar, se quita de Equipo y se guarda en Inventario.
		System.out.println("2) Arrojar Item"); // puede arrojar el item.
		System.out.println("3) Volver"); // para q pueda volver a seleccionar otro item.
		int opcElegida = Utiles.ingresarEntero(1, 2);
		switch (opcElegida) {
		case 1:
			String nombre = jugador.getEquipo()[elegido - 1].getNombre();
			int tipoEfecto = jugador.getEquipo()[elegido - 1].getTipoEfecto();
			boolean equipable = jugador.getEquipo()[elegido - 1].isEquipable();
			if (jugador.getCantItems() < jugador.getInventario().length) {
				quitarEfecto(jugador.getEquipo()[elegido - 1].getTipoEfecto());
				arrojarItem(elegido, jugador.getEquipo());
				jugador.setCantItemsE(jugador.getCantItemsE() - 1);// "cantItems--" a Equipo
				jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
				jugador.setCantItems(jugador.getCantItems() + 1);// "cantItems++" a inventario
				System.out.println(">" + nombre + " desequipado");
			} else {
				System.out.println(">No puedes desequiparte " + nombre + "por tener inventario lleno.");
			}
			accederEquipo();
			break;
		case 2:
			System.out.println(jugador.getEquipo()[elegido - 1].getNombre() + " arrojado");
			arrojarItem(elegido, jugador.getEquipo());
			jugador.setCantItemsE(jugador.getCantItemsE() - 1);
			accederEquipo();
			break;
		case 3:
			accederEquipo();
			break;
		}
	}

	private static void quitarEfecto(int tipoEfecto) {
		if (tipoEfecto == 0) { // 0:resta 100 vida, 4 de fuerza y 25 de magia
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() - 100);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 100);
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 4);
				jugador.getMago().setMagia(jugador.getMago().getMagia() - 25);

			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 100);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 100);
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 4);
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() - 25);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() - 100);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 100);
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 4);
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() - 25);
			}
		} else if (tipoEfecto == 3) { // 3: resta 200 vida, muy poca posibilidad de salir item(en evento)
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() - 200);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 200);

			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 200);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 200);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() - 200);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 200);
			}
		} else if (tipoEfecto == 4) { // 4: resta 200 magia y 100 vida, solo para mago
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setMagia(jugador.getMago().getMagia() - 200);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() - 200);
				jugador.getMago().setVida(jugador.getMago().getVida() - 100);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 100);

			}
		} else if (tipoEfecto == 5) { // 5: resta 300 vida, solo para guerrero
			if (jugador.getNroPers() == 2) {
				if (jugador.getGuerrero().getVida() - 300 < jugador.getGuerrero().getVidaMax()) {
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 300);
					jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 300);
				}else {
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVidaMax());
				}
			} else if (jugador.getNroPers() == 1) {
				if (jugador.getMago().getVida() - 300 < jugador.getMago().getVidaMax()) {
					jugador.getMago().setVida(jugador.getMago().getVida() - 300);
					jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 300);
				}else {
					jugador.getMago().setVida(jugador.getMago().getVidaMax());
				}
			} else if (jugador.getNroPers() == 3) {
				if (jugador.getElfo().getVida() - 300 < jugador.getElfo().getVidaMax()) {
					jugador.getElfo().setVida(jugador.getElfo().getVida() - 300);
					jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 300);
				}else {
					jugador.getElfo().setVida(jugador.getElfo().getVidaMax());
				}
			}
		} else if (tipoEfecto == 6) { // 6: resta 8 fuerza, solo para guerrero
			if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 8);
			} if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 8);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 8);
			}
		} else if (tipoEfecto == 7) { // 7: resta 5 fuerza, solo para elfo
			if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 5);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 5);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 5);
			}
		} else if (tipoEfecto == 9) { // 9: resta 200 magia, solo para mago
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setMagia(jugador.getMago().getMagia() - 200);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() - 200);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() - 200);
				jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() - 200);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() - 200);
				jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() - 200);
			}
		} else if (tipoEfecto == 10) { // 10: resta 7 fuerza, solo para guerrero
			if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 7);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 7);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 7);
			}
		} else if (tipoEfecto == 11) { // 11: resta 150 vida, solo para elfo
			if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() - 150);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 150);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() - 150);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 150);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 150);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 150);
			}
		} else if (tipoEfecto == 12) { // 12: resta 250 vida, 150 magia y 4 vida
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() - 250);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 250);
				jugador.getMago().setMagia(jugador.getMago().getMagia() - 150);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() - 150);
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 4);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 250);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 250);
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() - 150);
				jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() - 150);
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 4);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() - 250);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 250);
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() - 150);
				jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() - 150);
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 4);
			}
		} else if (tipoEfecto == 13) { // 13: resta 500 vida, 30 de fuerza y 500 de magia
            if (jugador.getNroPers() == 1) {
                jugador.getMago().setVida(jugador.getMago().getVida() - 500);
                jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() - 500);
                jugador.getMago().setFuerza(jugador.getMago().getFuerza() - 30);
                jugador.getMago().setMagia(jugador.getMago().getMagia() - 500);
                jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() - 500);
            } else if (jugador.getNroPers() == 2) {
                jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 500);
                jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() - 500);
                jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() - 30);
                jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() - 500);
                jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() - 500);
            } else if (jugador.getNroPers() == 3) {
                jugador.getElfo().setVida(jugador.getElfo().getVida() - 500);
                jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() - 500);
                jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() - 30);
                jugador.getElfo().setMagia(jugador.getElfo().getMagia() - 500);
                jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() - 500);
            }
		}
	}

	public static void generarItem() {
		//Para truco. Permite al personaje agarrar/guardar caulquier item en su inventario.
		int ind = Utiles.r.nextInt(items.length) + 1;
		String nombre = items[ind][0];
		int tipoEfecto = Integer.parseInt(items[ind][1]);
		boolean equipable = Boolean.parseBoolean(items[ind][2]);
		System.out.println(">Se generó el item: " + nombre);
		System.out.println(">¿Desea guardarlo en inventario? (1-Si/2-No)");
		int res = Utiles.ingresarEntero(1, 2);
		if (res == 1) {
			if (jugador.getCantItems() < jugador.getInventario().length) {
				jugador.getInventario()[jugador.getCantItems()] = new Item(nombre, tipoEfecto, equipable);
				jugador.setCantItems(jugador.getCantItems() + 1); // cantItems++
				System.out.println(">"+ nombre + " guardado.");
			} else {
				System.out.println(">No puedes guardar por tener inventario lleno");
				System.out.println(">"+ nombre + " arrojado.");
			}
		} else {
			System.out.println(">Has arrojado " + nombre + ".");
		}
		// Vuelve a ejecutarse el menú
	}

	// Tipo de Efecto de los items:
		// 0: añade 100 vida, 4 de fuerza y 25 de magia
		// 1: recupera 200 vida
		// 2: recupera 50 magia
		// 3: añade 200 vida, muy poca posibilidad de salir item
		// 4: añade 200 magia y 100 vida, solo para mago
		// 5: añade 300 vida, solo para guerrero
		// 6: añade 8 fuerza, solo para guerrero
		// 7: añade 5 fuerza, solo para elfo
		// 8: perder 400 vida o recuperar 400 vida
		// 9: añade 200 magia, solo para mago
		// 10: añade 7 fuerza, solo para guerrero
		// 11: añade 150 vida, solo para elfo
		// 12: añade 250 vida, 150 magia y 4 vida
		// Otros efectos para generarEvento:
		// ...(ninguno por ahora).
	public static void generarEfecto(int tipoEfecto) { //TODO generarEfecto()
		if (tipoEfecto == 0) { // 0:añade 100 vida, 4 de fuerza y 25 de magia
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() + 100);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 100);
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 4);
				jugador.getMago().setMagia(jugador.getMago().getMagia() + 25);

			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 100);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 100);
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() + 4);
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 25);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() + 100);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 100);
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 4);
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 25);
			}
		} else if (tipoEfecto == 1) { // 1:recupera 200 vida si no tiene el maximo de vida
			if (jugador.getNroPers() == 1) {
				if (jugador.getMago().getVida() + 200 < jugador.getMago().getVidaMax()) {
					jugador.getMago().setVida(jugador.getMago().getVida() + 200);
					System.out.println(">Recuperaste 200 puntos de vida");
				} else {
					System.out.println(">Tienes la vida completa");
					jugador.getMago().setVida(jugador.getMago().getVidaMax());
				}
			} else if (jugador.getNroPers() == 2) {
				if (jugador.getGuerrero().getVida() + 200 < jugador.getGuerrero().getVidaMax()) {
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 200);
					System.out.println(">Recuperaste 200 puntos de vida");
				} else {
					System.out.println(">Tienes la vida completa");
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVidaMax());
				}
			} else if (jugador.getNroPers() == 3) {
				if (jugador.getElfo().getVida() + 200 < jugador.getElfo().getVidaMax()) {
					jugador.getElfo().setVida(jugador.getElfo().getVida() + 200);
					System.out.println(">Recuperaste 200 puntos de vida");
				} else {
					System.out.println(">Tienes la vida completa");
					jugador.getElfo().setVida(jugador.getElfo().getVidaMax());
				}
			}
		} else if (tipoEfecto == 2) {// 2: recupera 50 magia
			if (jugador.getNroPers() == 1) {
				if (jugador.getMago().getMagia() + 50 < jugador.getMago().getMagiaMax()) {
					jugador.getMago().setMagia(jugador.getMago().getMagia() + 50);
					System.out.println(">Sumaste 50 puntos de magia");
				} else {
					System.out.println(">Tienes la magia completa");
					jugador.getMago().setMagia(jugador.getMago().getMagiaMax());
				}
			} else if (jugador.getNroPers() == 2) {
				if (jugador.getGuerrero().getMagia() + 50 < jugador.getGuerrero().getMagiaMax()) {
					jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 50);
					System.out.println(">Sumaste 50 puntos de magia");
				} else {
					System.out.println(">Tienes la magia completa");
					jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagiaMax());
				}
			} else if (jugador.getNroPers() == 3) {
				if (jugador.getElfo().getMagia() + 50 < jugador.getElfo().getMagiaMax()) {
					jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 50);
					System.out.println(">Sumaste 50 puntos de magia");
				} else {
					System.out.println(">Tienes la magia completa");
					jugador.getElfo().setMagia(jugador.getElfo().getMagiaMax());
				}
			}
		} else if (tipoEfecto == 3) { // 3: añade 200 vida, muy poca posibilidad de salir item
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() + 200);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 200);

			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 200);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 200);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() + 200);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 200);
			}
		} else if (tipoEfecto == 4) { // 4: añade 200 magia y 100 vida, solo para mago
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setMagia(jugador.getMago().getMagia() + 200);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() + 200);
				jugador.getMago().setVida(jugador.getMago().getVida() + 100);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 100);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 200);
				jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() + 200);
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 100);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 100);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 200);
				jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() + 200);
				jugador.getElfo().setVida(jugador.getElfo().getVida() + 100);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 100);
			}
		} else if (tipoEfecto == 5) { // 5: añade 300 vida, solo para guerrero
			if (jugador.getNroPers() == 2) {
				if (jugador.getGuerrero().getVida() + 300 < jugador.getGuerrero().getVidaMax()) {
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 300);
					jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 300);
					System.out.println(">Sumaste 300 puntos de vida");
				}else {
					System.out.println(">Tienes la vida completa");
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVidaMax());
				}
			} else if (jugador.getNroPers() == 1) {
				if (jugador.getMago().getVida() + 300 < jugador.getMago().getVidaMax()) {
					jugador.getMago().setVida(jugador.getMago().getVida() + 300);
					jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 300);
					System.out.println(">Sumaste 300 puntos de vida");
				}else {
					System.out.println(">Tienes la vida completa");
					jugador.getMago().setVida(jugador.getMago().getVidaMax());
				}
			} else if (jugador.getNroPers() == 3) {
				if (jugador.getElfo().getVida() + 300 < jugador.getElfo().getVidaMax()) {
					jugador.getElfo().setVida(jugador.getElfo().getVida() + 300);
					jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 300);
					System.out.println(">Sumaste 300 puntos de vida");
				}else {
					System.out.println(">Tienes la vida completa");
					jugador.getElfo().setVida(jugador.getElfo().getVidaMax());
				}
			}
		} else if (tipoEfecto == 6) { // 6: añade 8 fuerza, solo para guerrero
			if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() + 8);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 8);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 8);
				
			}
			System.out.println(">Sumaste 8 puntos de fuerza");
		} else if (tipoEfecto == 7) { // 7: añade 5 fuerza, solo para elfo
			if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 5);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 5);
			} else if (jugador.getNroPers() == 2) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 5);
			}
			System.out.println(">Sumaste 5 puntos de fuerza");
		} else if (tipoEfecto == 8) { // 8: perder 400 vida o recuperar 400 vida
			int itemR = Utiles.r.nextInt(2);
			if (itemR == 0) {
				if (jugador.getNroPers() == 1) {
					if (jugador.getMago().getVida() + 400 < jugador.getMago().getVidaMax()) {
						jugador.getMago().setVida(jugador.getMago().getVida() + 400);
						System.out.println(">Recuperaste 400 puntos de vida");
					} else {
						System.out.println(">Tienes la vida completa");
						jugador.getMago().setVida(jugador.getMago().getVidaMax());
					}
				} else if (jugador.getNroPers() == 2) {
					if (jugador.getGuerrero().getVida() + 400 < jugador.getGuerrero().getVidaMax()) {
						jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 400);
						System.out.println(">Recuperaste 400 puntos de vida");
					} else {
						System.out.println(">Tienes la vida completa");
						jugador.getGuerrero().setVida(jugador.getGuerrero().getVidaMax());
					}
				} else if (jugador.getNroPers() == 3) {
					if (jugador.getElfo().getVida() + 400 < jugador.getElfo().getVidaMax()) {
						jugador.getElfo().setVida(jugador.getElfo().getVida() + 400);
						System.out.println(">Recuperaste 400 puntos de vida");
					} else {
						System.out.println(">Tienes la vida completa");
						jugador.getElfo().setVida(jugador.getElfo().getVidaMax());
					}
				}
			} else {
				if (jugador.getNroPers() == 1) {
					jugador.getMago().setVida(jugador.getMago().getVida() - 400);
				} else if (jugador.getNroPers() == 2) {
					jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() - 400);
				} else if (jugador.getNroPers() == 3) {
					jugador.getElfo().setVida(jugador.getElfo().getVida() - 400);
				}
				System.out.println(">Has perdido 400 puntos de vida");
			}
		} else if (tipoEfecto == 9) { // 9: añade 200 magia, solo para mago
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setMagia(jugador.getMago().getMagia() + 200);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() + 200);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 200);
				jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() + 200);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 200);
				jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() + 200);
			}
			System.out.println(">Sumaste 200 puntos de magia");
		} else if (tipoEfecto == 10) { // 10: añade 7 fuerza, solo para guerrero
			if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() + 7);
			}
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 7);
			}
			if (jugador.getNroPers() == 3) {
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 7);
			}
			System.out.println(">Sumaste 7 puntos de fuerza");
		} else if (tipoEfecto == 11) { // 11: añade 150 vida, solo para elfo
			if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() + 150);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 150);
			} else if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() + 150);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 150);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 150);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 150);
			}
			System.out.println(">Sumaste 150 puntos de vida");
		} else if (tipoEfecto == 12) { // 12: añade 250 vida, 150 magia y 4 vida
			if (jugador.getNroPers() == 1) {
				jugador.getMago().setVida(jugador.getMago().getVida() + 250);
				jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 250);
				jugador.getMago().setMagia(jugador.getMago().getMagia() + 150);
				jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() + 150);
				jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 4);
			} else if (jugador.getNroPers() == 2) {
				jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 250);
				jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 250);
				jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 150);
				jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() + 150);
				jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() + 4);
			} else if (jugador.getNroPers() == 3) {
				jugador.getElfo().setVida(jugador.getElfo().getVida() + 250);
				jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 250);
				jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 150);
				jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() + 150);
				jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 4);
			}
			System.out.println(">Sumaste 250 de vida, 150 de magia y 4 de fuerza");
		} else if (tipoEfecto == 13) { // 13: añade 500 vida, 30 de fuerza y 500 de magia
            if (jugador.getNroPers() == 1) {
                jugador.getMago().setVida(jugador.getMago().getVida() + 500);
                jugador.getMago().setVidaMax(jugador.getMago().getVidaMax() + 500);
                jugador.getMago().setFuerza(jugador.getMago().getFuerza() + 30);
                jugador.getMago().setMagia(jugador.getMago().getMagia() + 500);
                jugador.getMago().setMagiaMax(jugador.getMago().getMagiaMax() + 500);
            } else if (jugador.getNroPers() == 2) {
                jugador.getGuerrero().setVida(jugador.getGuerrero().getVida() + 500);
                jugador.getGuerrero().setVidaMax(jugador.getGuerrero().getVidaMax() + 500);
                jugador.getGuerrero().setFuerza(jugador.getGuerrero().getFuerza() + 30);
                jugador.getGuerrero().setMagia(jugador.getGuerrero().getMagia() + 500);
                jugador.getGuerrero().setMagiaMax(jugador.getGuerrero().getMagiaMax() + 500);
            } else if (jugador.getNroPers() == 3) {
                jugador.getElfo().setVida(jugador.getElfo().getVida() + 500);
                jugador.getElfo().setVidaMax(jugador.getElfo().getVidaMax() + 500);
                jugador.getElfo().setFuerza(jugador.getElfo().getFuerza() + 30);
                jugador.getElfo().setMagia(jugador.getElfo().getMagia() + 500);
                jugador.getElfo().setMagiaMax(jugador.getElfo().getMagiaMax() + 500);
            }
            System.out.println(">Se han sumado 500 de vida, 30 de fuerza y 500 de magia");
        }
	}
	
	private static void mostrarMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("\t\tMenú");
		System.out.println("---------------------------------------");
		System.out.println("Seleccione una opción: ");
		System.out.println("1) Avanzar");
		System.out.println("2) Girar a la derecha");
		System.out.println("3) Girar a la izquierda");
		System.out.println("4) Acceder al inventario");
		System.out.println("5) Acceder al equipo");
		System.out.println("6) Salir");
		System.out.println("---------------------------------------");
	}

	private static void mostrarInformacion() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Jugador: " + jugador.getNombre());
		System.out.println("Personaje: " + ((jugador.getNroPers() == 1) ? "Mago" : (jugador.getNroPers() == 2) ? "Guerrero" : "Elfo"));
		if (jugador.getNroPers() == 1) {
			System.out.println("Vida: " + jugador.getMago().getVida() + " | " + "Fuerza: " + jugador.getMago().getFuerza() + " | " + "Magia: " + jugador.getMago().getMagia());
			System.out.println("Defensa fisica: " + jugador.getMago().getDefensaFisica() + " | " + "Defensa magica: " + jugador.getMago().getDefensaMagica());
		} else if (jugador.getNroPers() == 2) {
			System.out.println("Vida: " + jugador.getGuerrero().getVida() + " | " + "Fuerza: " + jugador.getGuerrero().getFuerza() + " | " + "Magia: " + jugador.getGuerrero().getMagia());
			System.out.println("Defensa fisica: " + jugador.getGuerrero().getDefensaFisica() + " | " + "Defensa magica: " + jugador.getGuerrero().getDefensaMagica());
		} else {
			System.out.println("Vida: " + jugador.getElfo().getVida() + " | " + "Fuerza: " + jugador.getElfo().getFuerza() + " | " + "Magia: " + jugador.getElfo().getMagia());
			System.out.println("Defensa fisica: " + jugador.getElfo().getDefensaFisica() + " | " + "Defensa magica: " + jugador.getElfo().getDefensaMagica());
		}
		System.out.println();
		System.out.println("Enemigo: " + enemigo.getNombre());
		System.out.println("Personaje: " + ((enemigo.getRan() == 1)?"Mago": (enemigo.getRan() == 2)?"Guerrero":"Elfo"));
		if(enemigo.getRan() == 1) {
			System.out.println("Vida: " + enemigo.getMago().getVida() + " | " + "Fuerza: " + enemigo.getMago().getFuerza() + " | " + "Magia: " + enemigo.getMago().getMagia());
			System.out.println("Defensa fisica: " + enemigo.getMago().getDefensaFisica() + " | " + "Defensa magica: " + enemigo.getMago().getDefensaMagica());
		}
		else if(enemigo.getRan() == 2) {
			System.out.println("Vida: " + enemigo.getGuerrero().getVida() + " | " + "Fuerza: " + enemigo.getGuerrero().getFuerza() + " | " + "Magia: " + enemigo.getGuerrero().getMagia());
			System.out.println("Defensa fisica: " + enemigo.getGuerrero().getDefensaFisica() + " | " + "Defensa magica: " + enemigo.getGuerrero().getDefensaMagica());
		} 
		else {
			System.out.println("Vida: " + enemigo.getElfo().getVida() + " | " + "Fuerza: " + enemigo.getElfo().getFuerza() + " | " + "Magia: " + enemigo.getElfo().getMagia());
			System.out.println("Defensa fisica: " + enemigo.getElfo().getDefensaFisica() + " | " + "Defensa magica: " + enemigo.getElfo().getDefensaMagica());
		}
		
		System.out.println("---------------------------------------");
		System.out.println();
	}

	public static void generarBatalla() { //TODO generarBatalla
		enemigo = new Enemigo();
		System.out.println("\nCargando la batalla...\n");
		Utiles.delay(2000);
		turno = Utiles.r.nextInt(2);
		boolean finDelJuego = false;
		System.out.println(">Empieza el " + ((turno == 0) ? "jugador" : "enemigo")); // comienzo del turno
		System.out.println();
		Utiles.delay(2200);

		do {
			if (turno == 0) { // turno del jugador
				if (jugador.getNroPers() == 1) {
					if (jugador.getMago().getVida() > 0) { // jugador con mago
						mostrarInformacion();
						System.out.println(">Turno del jugador");
						Utiles.delay(3000);
						System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
						int rta = Utiles.ingresarEntero(1, 2);
						if (rta == 1) {
							mostrarYEjecutarAtaque();
						} else {
							mostrarYEjecutarHechizo();
						}
					} else {
						System.out.println("\n>Tu personaje no tiene vida. Has perdido...");
						finDelJuego = true;
						opc = 5;
					}
				} else if (jugador.getNroPers() == 2) {
					if (jugador.getGuerrero().getVida() > 0) { // jugador con guerrero
						mostrarInformacion();
						System.out.println(">Turno del jugador");
						Utiles.delay(3000);
						System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
						int rta = Utiles.ingresarEntero(1, 2);
						if (rta == 1) {
							mostrarYEjecutarAtaque();
						} else {
							mostrarYEjecutarHechizo();
						}
					} else {
						System.out.println(">Tu personaje no tiene vida. Has perdido...");
						finDelJuego = true;
						opc = 5;
					}
				} else {
					if (jugador.getElfo().getVida() > 0) { // jugador con elfo
						mostrarInformacion();
						System.out.println(">Turno del jugador");
						Utiles.delay(3000);
						System.out.println("\nSeleccione (1-Ataques/2-Hechizos): ");
						int rta = Utiles.ingresarEntero(1, 2);
						if (rta == 1) {
							mostrarYEjecutarAtaque();
						} else {
							mostrarYEjecutarHechizo();
						}
					} else {
						System.out.println(">Tu personaje no tiene vida. Has perdido...");
						finDelJuego = true;
						opc = 5;
					}
				}

				turno = 1;
			} else { // turno del enemigo
				if (enemigo.getRan() == 1) { // enemigo con mago
					if (enemigo.getMago().getVida() > 0) {
						mostrarInformacion();
						System.out.println(">Turno del enemigo");
						Utiles.delay(3000);
						boolean repite = false;
						do {
							repite = false;
							int ataqueran = Utiles.r.nextInt(2);
							if (ataqueran == 0) { // ataques del mago
								int ataque = Utiles.r.nextInt(5);
								enemigo.getMago().atacar(ataque, turno, jugador, enemigo);
								System.out.println(">Ha utilizado el ataque: "
										+ enemigo.getMago().getAtaques()[ataque].getNombre());
								Utiles.delay(3000);
							} else { // hechizos del mago
								int hechizo = Utiles.r.nextInt(5);
								if (enemigo.getMago().getMagia() >= enemigo.getMago().getHechizos()[hechizo]
										.getCosto()) {
									if (hechizo == 1) { // magia blanca cura al personaje
										enemigo.getMago().curar(hechizo, turno, jugador, enemigo);
										System.out.println(">Utilizó el hechizo magia blanca");
										Utiles.delay(3000);
									} else {
										enemigo.getMago().hechizar(hechizo, turno, jugador, enemigo);
										System.out.println(">Ha utilizado el hechizo: "
												+ enemigo.getMago().getHechizos()[hechizo].getNombre());
										Utiles.delay(3000);
									}
								} else {
									repite = true;
								}
							}
						} while (repite);
					} else {
						System.out.println(">El enemigo no tiene vida. Has ganado!!!");
						finDelJuego = true;
						enemigo = null; // para que no ocupe espacio en memoria
					}
				} else if (enemigo.getRan() == 2) { // enemigo con guerrero
					if (enemigo.getGuerrero().getVida() > 0) {
						mostrarInformacion();
						System.out.println(">Turno del enemigo");
						Utiles.delay(3000);
						boolean repite = false;
						do {
							repite = false;
							int ataqueran = Utiles.r.nextInt(2);
							if (ataqueran == 0) { // ataques del guerrero
								int ataque = Utiles.r.nextInt(5);
								enemigo.getGuerrero().atacar(ataque, turno, jugador, enemigo);
								System.out.println(">Ha utilizado el ataque: "
										+ enemigo.getGuerrero().getAtaques()[ataque].getNombre());
								Utiles.delay(3000);
							} else { // hechizos del guerrero
								int hechizo = Utiles.r.nextInt(5);
								if (enemigo.getGuerrero().getMagia() >= enemigo.getGuerrero().getHechizos()[hechizo]
										.getCosto()) {
									if (hechizo == 1) { // magia blanca cura al personaje
										enemigo.getGuerrero().curar(hechizo, turno, jugador, enemigo);
										System.out.println(">Utilizó el hechizo curar heridas");
										Utiles.delay(3000);
									} else {
										enemigo.getGuerrero().hechizar(hechizo, turno, jugador, enemigo);
										System.out.println(">Ha utilizado el hechizo: "
												+ enemigo.getGuerrero().getHechizos()[hechizo].getNombre());
										Utiles.delay(3000);
									}

								} else {
									repite = true;
								}
							}
						} while (repite);
					} else {
						System.out.println(">El enemigo no tiene vida. Has ganado!!!");
						finDelJuego = true;
						enemigo = null; // para que no ocupe espacio en memoria
					}
				} else {
					if (enemigo.getElfo().getVida() > 0) { // enemigo con elfo
						mostrarInformacion();
						System.out.println(">Turno del enemigo");
						Utiles.delay(3000);
						boolean repite = false;
						do {
							repite = false;
							int ataqueran = Utiles.r.nextInt(2);
							if (ataqueran == 0) { // ataques del elfo
								int ataque = Utiles.r.nextInt(5);
								enemigo.getElfo().atacar(ataque, turno, jugador, enemigo);
								System.out.println(">Ha utilizado el ataque: "
										+ enemigo.getElfo().getAtaques()[ataque].getNombre());
								Utiles.delay(3000);
							} else { // hechizos del elfo
								int hechizo = Utiles.r.nextInt(5);
								if (enemigo.getElfo().getMagia() >= enemigo.getElfo().getHechizos()[hechizo].getCosto()) {
									if (hechizo == 1) { // magia blanca cura al personaje
										enemigo.getElfo().curar(hechizo, turno, jugador, enemigo);
										System.out.println(">Utilizó el hechizo purificación");
										Utiles.delay(3000);
									} else {
										enemigo.getElfo().hechizar(hechizo, turno, jugador, enemigo);
										System.out.println(">Ha utilizado el hechizo: " + enemigo.getElfo().getHechizos()[hechizo].getNombre());
										Utiles.delay(3000);
									}

								} else {
									repite = true;
								}
							}
						} while (repite);
					} else {
						System.out.println(">El enemigo no tiene vida. Has ganado!!!");
						finDelJuego = true;
						enemigo = null; // para que no ocupe espacio en memoria
					}
				}
				turno = 0;
			}
			
		} while (!finDelJuego);
	}

}


