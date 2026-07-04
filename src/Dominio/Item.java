package Dominio;

public class Item extends Carta {
	private int bonificacion;

	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}
	@Override
	public String toString() {
		return "---- "+nombre+"----;Tipo: "+tipo+";Rareza: "+ rareza+";Bonificacion: "+ bonificacion+";Poder: "+poder;
	}
	@Override
	public String getDatos() {
		return ""+bonificacion;
	}
	
}
