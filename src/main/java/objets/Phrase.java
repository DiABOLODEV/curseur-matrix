package objets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import moteur.UI;

public class Phrase extends Objet implements KeyListener{

	private String phrase;

	public Phrase(int x, int y, int largeur, int hauteur, String phrase) {
		super(x, y, largeur, hauteur);
		this.phrase = phrase;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void dessiner(Graphics g) {
		g.setColor(Color.GREEN);
		g.setFont(new Font("sans serif", Font.PLAIN, 30));
		int gap = UI.LARGEUR_FENETRE / phrase.length();
		for(int i = 0; i < phrase.length(); i++){
			g.drawString(String.valueOf(phrase.charAt(i)), (i+1)*gap-20, UI.HAUTEUR_FENETRE/2-(int) (Math.random() * 20 + 1));
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		phrase += e.getKeyChar();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
