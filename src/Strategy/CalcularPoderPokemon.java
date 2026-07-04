package Strategy;

public class CalcularPoderPokemon implements EstrategiaCalcularPoder {
	@Override
	public int calcularPoder(String datos) {
		String[] partes = datos.split(";");
		int danio = Integer.parseInt(partes[0]);
		int cantEnergia = Integer.parseInt(partes[1]);
		int poder = (danio/cantEnergia)*100;
		
		return poder;
	}

}
