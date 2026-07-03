package Dominio;

public abstract class Carta {
	protected String nombre;
	protected int rareza;
	protected String tipo;
	
	
	public Carta(String nombre, int rareza, String tipo) {
		this.tipo=tipo;
		this.nombre = nombre;
		this.rareza = rareza;
	}
	
	
}
