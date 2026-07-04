package Strategy;

public interface EstrategiaCalcularPoder {
	/**
	 * calcula el Poder de la carta
	 * PRE:
	 * - el formato de datos corresponda al tipo
	 * POST:
	 * - da el poder Dependiendo del tipo y los datos 
	 * @param datos los datos de la carta correspondientes para el calculo como String
	 * @return un double que es el Poder de esa carta
	 */
	double calcularPoder(String datos);
}
