package Dominio;
import Visitor.*;
public abstract class Carta {
	protected String nombre;
	protected int rareza;
	protected String tipo;
	protected int poder;
	protected String rutaImagen;
	
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


	public String getRutaImagen() {
		return rutaImagen;
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}


	public void setPoder(int poder) {
		this.poder = poder;
	}
	public String getDatos() {
		return ""+1;
	}
	
	public void aceptar(IVisitor visitante) {
		visitante.visitar(this);
	}
	
	
	
}
