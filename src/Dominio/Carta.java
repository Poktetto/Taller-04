package Dominio;

public abstract class Carta {
	protected String nombre;
	protected int rareza;
	protected String tipo;
	protected double poder;
	
	
	public Carta(String nombre, int rareza, String tipo) {
		this.tipo=tipo;
		this.nombre = nombre;
		this.rareza = rareza;
	}


	public String getNombre() {
		return nombre;
	}


	public int getRareza() {
		return rareza;
	}


	public String getTipo() {
		return tipo;
	}


	public double getPoder() {
		return poder;
	}


	public void setPoder(double poder) {
		this.poder = poder;
	}
	public String getDatos() {
		return ""+1;
	}
	
	
	
}
