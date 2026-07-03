package GUI;
import Dominio.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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
		ventana.getContentPane().add(crearGui(ventana));
		ventana.setVisible(true);
	}

	private JPanel crearGui(JFrame ventana) {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JPanel botonera = new JPanel();
		
		JLabel titulo = new JLabel("Desea administrar O ver la coleccion?",SwingConstants.CENTER); // para el titulo
		
		JButton administracion = botonAdmin(ventana);
		JButton coleccion = botonColec(ventana);
		
		botonera.add(administracion);
		botonera.add(coleccion);
		
		panelPrincipal.add(titulo,BorderLayout.NORTH);
		panelPrincipal.add(botonera,BorderLayout.SOUTH);
		return panelPrincipal;
	}

	private JButton botonColec(JFrame ventana) {
		JButton b = new JButton("Ver Coleccion");
		b.addActionListener(e->{
			ventana.getContentPane().removeAll();
			JPanel botonera = new JPanel();
			JPanel texto = new JPanel(); //para la impresion de las Cartas
			texto.setLayout(new BoxLayout(texto,BoxLayout.Y_AXIS));
			
			JButton b1= new JButton("HacerDespues");
			JButton b2= new JButton("HacerDespues");
			JButton b3= new JButton("HacerDespues");
			JButton b4 = volver(ventana);
			
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
			botonera.add(b4); //volver
			
			ventana.add(botonera, BorderLayout.SOUTH);
			ventana.add(texto, BorderLayout.CENTER);
			
			ventana.getContentPane().revalidate();
			ventana.getContentPane().repaint();
		});
		return b;
	}
	private JButton volver(JFrame ventana) {
		JButton b = new JButton("Volver ↩️");
		b.addActionListener(e->{
			//limpia y recrea el GUI
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(crearGui(ventana)); 
			ventana.getContentPane().revalidate(); 
			ventana.getContentPane().repaint();
		});
		return b;
	}
	private JButton botonAdmin(JFrame ventana) {
		
		JButton b = new JButton("Administrar");
		b.addActionListener(e->{
			ventana.getContentPane().removeAll();
			JPanel botonera = new JPanel();
			
			JButton b1= agregarCarta(ventana);
			JButton b2= eliminarCarta();
			JButton b3= modificarCarta();
			JButton b4 = volver(ventana);
			botonera.add(b1);
			botonera.add(b2);
			botonera.add(b3);
			botonera.add(b4);
			ventana.add(botonera, BorderLayout.SOUTH);
			
			ventana.getContentPane().revalidate();
			ventana.getContentPane().repaint();
		});
		
		return b;
	}
	private JButton modificarCarta() {
		JButton b = new JButton("Modificar Carta");
		b.addActionListener(e->{
			
		
		});
		
		return b;
	}

	private JButton eliminarCarta() {
		JButton b = new JButton("Eliminar Carta");
		b.addActionListener(e->{

			
		});
		
		return b;
	}

	private JButton agregarCarta(JFrame ventana) {
		JButton b = new JButton("Agregar Carta");
		b.addActionListener(e->{
			JDialog ventanaDialog = new JDialog(ventana, "Agregar Carta");
			ventanaDialog.setSize(200,300);
			
			JLabel titulo = new JLabel("Agregar de cartas",SwingConstants.CENTER); //para que este constantemente en el centro
			
			ventanaDialog.add(titulo,BorderLayout.NORTH);
			
			ventanaDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaDialog.setLocationRelativeTo(null); //para que salga en el centro

			ventanaDialog.setVisible(true);
			
		});
		
		return b;
	}
}
