package Strategy;

public class CalcularPoderEnergy implements EstrategiaCalcularPoder {

	@Override
	public double calcularPoder(String datos) {
		return (double) Integer.parseInt(datos);
	}

}
