package Strategy;

public class CalcularPoderSupporter implements EstrategiaCalcularPoder {
	@Override
	public double calcularPoder(String datos) {
		return (double) Integer.parseInt(datos)*50;
	}
}
