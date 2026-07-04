package Strategy;

public class CalcularPoderPokemon implements EstrategiaCalcularPoder {
	@Override
	public double calcularPoder(String datos) {
		String[] partes = datos.split(";");
		int danio = Integer.parseInt(partes[0]);
		int cantEnergia = Integer.parseInt(partes[1]);
		double poder = (danio/cantEnergia)*100;
		
		return poder;
	}

}
