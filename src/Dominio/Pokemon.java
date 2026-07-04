package Dominio;

public class Pokemon extends Carta {
	private int danio;
	private int energia;
	public Pokemon(String nombre, int rareza, String tipo, int danio, int energia) {
		super(nombre, rareza, tipo);
		this.danio = danio;
		this.energia = energia;
	}
	@Override
	public String toString() {
		return "---- "+nombre+"----;Tipo:"+tipo+";Rareza: "+ rareza+";Daño: " +danio +";Cantidad de energias: " + energia+";Poder: "+poder;
	}
	@Override
	public String getDatos() {
		return danio+";"+energia;
	}
	
	
}
