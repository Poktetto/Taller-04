package Dominio;

public class Supporter extends Carta {
	private int efectosPorTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}
	@Override
	public String toString() {
		return "---- "+nombre+"----;Tipo: "+tipo+";Rareza: "+ rareza +";Efectos Por Turno:  " + efectosPorTurno+";Poder: "+poder;
	}
	@Override
	public String getDatos() {
		return ""+efectosPorTurno;
	}
	
}
