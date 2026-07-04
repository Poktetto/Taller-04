package Strategy;

public class CalcularPoderItem implements EstrategiaCalcularPoder {

	@Override
	public int calcularPoder(String datos) {
		return  Integer.parseInt(datos)*20;
	}
	
}
