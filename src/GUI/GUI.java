package GUI;
import Dominio.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Logica.SistemaImplementado;
import Logica.Sistema;

public class GUI {
	private static Sistema sistema =SistemaImplementado.getInstance(); //no estoy muy seguro pero creo que es asi
	public GUI(){
		JFrame ventana = new JFrame("Administrador de Cartas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(500, 600);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().add(crearGui());
		ventana.setVisible(true);
	}

	private JPanel crearGui() {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JPanel botonera = new JPanel();
		JPanel texto = new JPanel();
		JLabel titulo = new JLabel("Administrador de cartas",SwingConstants.CENTER); // para el titulo
		
		texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
		JButton b1= agregarCarta(texto);
		JButton b2= eliminarCarta(texto);
		JButton b3= modificarCarta(texto);
				
		botonera.add(b1);
		botonera.add(b2);
		botonera.add(b3);
		panelPrincipal.add(titulo,BorderLayout.NORTH);
		panelPrincipal.add(botonera,BorderLayout.SOUTH);
		panelPrincipal.add(texto,BorderLayout.CENTER);
		return panelPrincipal;
	}

	private JButton modificarCarta(JPanel texto) {
		JButton b = new JButton("Modificar Carta");
		b.addActionListener(e->{
			
		
		});
		
		return b;
	}

	private JButton eliminarCarta(JPanel texto) {
		JButton b = new JButton("Eliminar Carta");
		b.addActionListener(e->{

			
		});
		
		return b;
	}

	private JButton agregarCarta(JPanel texto) {
		JButton b = new JButton("Agregar Carta");
		b.addActionListener(e->{
			
			
		});
		
		return b;
	}
}
