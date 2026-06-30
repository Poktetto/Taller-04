package Logica;

import java.util.ArrayList;
import java.util.List;
import Dominio.*;

public class SistemaImplentado implements Sistema{
	//Creacion de variables estaticas
	private static Sistema instancia; //para el Singleton
	private static List<Carta> deck = new ArrayList<>();
	
	
	private void SistemaImplentado() {}
	public static Sistema getInstance() {
		if (instancia==null) {
			instancia= new SistemaImplentado();
		}
		return instancia;
	}
	@Override
	public void crearSobres(String linea) {
		CartasFactory factory = new CartasFactory();
		deck.add(factory.fabricarCarta(linea));
		
	}

}
