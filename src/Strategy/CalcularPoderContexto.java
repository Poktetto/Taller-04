package Strategy;

public class CalcularPoderContexto {
	private static EstrategiaCalcularPoder strategy;
	
	public void setStrategy(String tipo) {
		if (tipo.equals("Pokemon")) {
			strategy = new CalcularPoderPokemon();
		} else if (tipo.equals("Item")) {
			strategy = new CalcularPoderItem();
		} else if (tipo.equals("Supporter")) {
			strategy = new CalcularPoderSupporter();
		} else if (tipo.equals("Energy")) {
			strategy = new CalcularPoderEnergy();
		}
	}

	public int ejecutar(String datos) {
		return strategy.calcularPoder(datos);
	}
}
