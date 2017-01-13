package moteur;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	public static int LARGEUR_FENETRE = 800;
	public static int HAUTEUR_FENETRE = 600;
	
	private JFrame fenetre;
	private Canvas canvas;
	private BufferStrategy strategy;

	public UI(String titre){
		
		fenetre = new JFrame(titre);
		JPanel panel = (JPanel) fenetre.getContentPane();
		panel.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE));
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0,0,LARGEUR_FENETRE,HAUTEUR_FENETRE);
		panel.add(canvas);
		

		
		// finally make the window visible 
		fenetre.pack();
		fenetre.setResizable(false); 
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// request the focus so key events come to us
		canvas.requestFocus();
		// create the buffering strategy which will allow AWT
		// to manage our accelerated graphics
		canvas.createBufferStrategy(2);
		strategy = canvas.getBufferStrategy();
		// Tell AWT not to bother repainting our canvas since we're
		// going to do that our self in accelerated mode
		canvas.setIgnoreRepaint(true);
	}

	public JFrame getFenetre() {
		return fenetre;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public BufferStrategy getStrategy() {
		return strategy;
	}
	
	
}
