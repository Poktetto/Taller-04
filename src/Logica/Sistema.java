package Logica;

public interface Sistema {
	/**
	 * crea los objetos de carta y los almacena en una lista
	 * PRE:
	 * - El String debe estar separado por ";" y poseer el formato 
	 * POST:
	 * - Se guardan los objetos dependiendo su tipo
	 * @param linea que contiene la linea del txt "Sobres.txt"
	 */
	void crearSobres(String linea);
	/**
	 * Crea la GUI
	 * PRE:
	 * - que el SistemaImplementado tenga cargadas las cartas
	 * POST:
	 * - El GUI donde se realizan las ineracciones
	 */
	void crearGUI();
	/**
	 * retorna la cantidad de cartas en el SistemaImplementado
	 * 
	 * PRE:
	 * - que se hayan cargado las cartas en la lista
	 * POST:
	 * - la cantidad de cartas en la lista
	 * 
	 * @return cantidad de "Carta" almacenada en la lista
	 */
	int verCantCartas();
	/**
	 * retorna los datos de la carta dada en el indice "i" en forma de su ToString
	 * PRE:
	 * - debe existir la posicion "i" en la lista de cartas
	 * POST:
	 * - el ToString de la carta "i"
	 * @param i el indice de la carta en la lista
	 * @return el ToString de la carta del indice
	 */
	String verCarta(int i);
	/**
	 *  retorna el nombre de la carta dada en el indice "i"
	 * PRE:
	 * - debe existir la posicion "i" en la lista de cartas
	 * POST:
	 * - el nombre de la carta "i"
	 * @param el indice de la carta en la lista
	 * @return el nombre de la carta "i"
	 */
	String verNombreCarta(int i);
	/**
	 * ordena la lista de cartas por la rareza
	 * PRE:
	 * - la lista de cartas mo debe estar vacia
	 * POST:
	 * -ordena la lista de cartas por su rareza de mayor a menor
	 */
	void ordenarCartasRareza();
	/**
	 * ordena la lista de cartas por el poder y calcula el poder de las cartas
	 * PRE:
	 * - la lista de cartas mo debe estar vacia
	 * POST:
	 * - las cartas quedan con un poder guardado y se ordenan dependiendo de esto
	 */
	void odenarCartasPoder();
	
	void eliminarCarta();
	void ordenarCartasNombre();
	void calcularPoder();

}
