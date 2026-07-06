package Logica;
//Alvaro Sebastian Orrego Ramírez RUT:22185824-7  Carrera: ITI
//Anita Constanza Rojas Urrutia RUT: 22286335-K  Carrera: ITI
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class App {
	private static Sistema sistema = SistemaImplementado.getInstance();
	public static void main(String[] args) throws IOException {
		cargarSobres();
		sistema.calcularPoder();
		cargarGUI();
	}

	private static void cargarGUI() {
		sistema.crearGUI();		
	}

	private static void cargarSobres() throws IOException {
		File arc = new File("txts/Sobres.txt");
		Scanner sArc = new Scanner(arc);
		while (sArc.hasNextLine()) {
			String linea = sArc.nextLine();
			sistema.crearSobres(linea);
		}
		sistema.agregarImagen();
		
		
	}

}
