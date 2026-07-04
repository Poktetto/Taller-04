package Strategy;

public class CalcularPoderItem implements EstrategiaCalcularPoder {

	@Override
	public double calcularPoder(String datos) {
		return (double) Integer.parseInt(datos)*20;
	}
	
}
