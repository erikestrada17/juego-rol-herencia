package utiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public final class Utiles {
	
	public static Random r = new Random();
	public static Scanner s = new Scanner(System.in);
	
	
	public static java.awt.Robot robot = null;

	public static void presionarEnter() {
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ENTER); // Simula presionar la tecla

		} catch (AWTException e) {
			throw new RuntimeException("Error");
		}
	}

	public static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int ingresarEntero(int min, int max) {
        boolean error = false;
        int valor = 0;
        do {
            error = false;
            try {
                valor = s.nextInt();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
			} catch (InputMismatchException e) {
				String buffer = s.nextLine();
				if (buffer.equalsIgnoreCase("newItem")) {
					System.out.println("Truco activado, se ha generado un ítem aleatorio");
					valor = 0;
					presionarEnter();
					delay(1000);
				} else if (buffer.equalsIgnoreCase("moreMagic")) {
					System.out.println("Truco activado, se ha sumado 200 de magia");
					valor = -1;
					presionarEnter();
					delay(1000);
				} else if (buffer.equals("morelife")){
                    System.out.println("Truco activado, se ha sumado 200 puntos de vida");
                    valor = -2;
                    presionarEnter();
                    delay(1000);
				} else {
					System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
					error = true;
				}
			} catch (Exception e) {
				System.out.println("Error desconocido");
				error = true;
				s.nextLine();
			}
		} while (error);
        s.nextLine();
        return valor;
    }
	
	public static float ingresarDecimal(float min, float max) {
        boolean error = false;
        float valor = 0;
        do {
            error = false;
            try {
                valor = s.nextFloat();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
            }catch(InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
                error = true;
                s.nextLine();
            }catch(Exception e) {
                System.out.println("Error desconocido");
                error = true;
                s.nextLine();
            }
        }while(error);
        s.nextLine();
        return valor;
    }
	

}
