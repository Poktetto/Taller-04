package Strategy;

public class CalcularPoderSupporter implements EstrategiaCalcularPoder {
	@Override
	public int calcularPoder(String datos) {
		return Integer.parseInt(datos)*50;
	}
}
