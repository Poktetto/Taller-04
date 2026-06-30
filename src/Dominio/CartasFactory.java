package Dominio;

public class CartasFactory {

	public Carta fabricarCarta(String linea) {
		String[] partes = linea.split(";");
		if (partes[2].equals("Pokemon")) {
			return new Pokemon(partes[0],Integer.parseInt(partes[1]),partes[2],Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
		}  
		else if (partes[2].equals("Item")) {
			return new Item(partes[0],Integer.parseInt(partes[1]),partes[2],Integer.parseInt(partes[3]));
		} 
		else if (partes[2].equals("Supporter")) {
			return new Supporter(partes[0],Integer.parseInt(partes[1]),partes[2],Integer.parseInt(partes[3]));
		} 
		else if (partes[2].equals("Energy")) {
			return new Energy(partes[0],Integer.parseInt(partes[1]),partes[2],partes[3]);
		}
		return null;
	}

}
