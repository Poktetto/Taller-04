package Visitor;

import Dominio.Carta;

public interface IVisitor {
	
	/**
	 * Busca en el disco la existencia de la imagen de la carta.
	 *PRE:
	 *-La lista cartas no debe estar vacia.
	 *POST:
	 *-Se guarda en cada carta la ruta de su imagen.
	 * @param carta
	 */
//asi se escribe?
	void visitar(Carta carta);

}
