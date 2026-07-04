package Dominio;

public class Energy extends Carta {

	private String elemento;

	public Energy(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return "---- "+nombre+"----;Rareza: "+ rareza+";Elemento: "+ elemento;
	}
	
	
	
}
