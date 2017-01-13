package moteur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Moteur {
	private static int DELAI_BOUCLE = 10; // Temps entre chaque boucle en ms
	private BufferStrategy ecran; // Ecran sur lequel on va dessiner nos elements 
	private Jeu jeu;
	
	public Moteur(BufferStrategy ecran, Jeu jeu){
		this.ecran = ecran;
		this.jeu   = jeu;
		
		this.boucle();
	}
	public void boucle(){
		
		while(true){
			Graphics g = ecran.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,UI.LARGEUR_FENETRE, UI.HAUTEUR_FENETRE);
			////////////////////////////////////////////////
			jeu.dessiner(g);
		    ////////////////////////////////////////////////
			g.dispose();
			ecran.show();
			try {
				Thread.sleep(DELAI_BOUCLE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
