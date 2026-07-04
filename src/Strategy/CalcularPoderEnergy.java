package Strategy;

public class CalcularPoderEnergy implements EstrategiaCalcularPoder {

	@Override
	public int calcularPoder(String datos) {
		return  Integer.parseInt(datos);
	}

}
