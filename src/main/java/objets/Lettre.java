package objets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import moteur.UI;

public class Lettre extends Objet implements KeyListener{

	private String lettre;
	private String alphabet = "123xyzaqklsjsoduoiuzerbkqsckqosia$*ù^^ù:!;,";
	private double gravite = 0.05;
	private Color color;
	
	public Lettre(int x, int y, int largeur, int hauteur) {
		super(x, y, largeur, hauteur);
		this.vitesse = new Point(10,3);
		Random r = new Random();
		this.lettre =  String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
		this.color = Color.GREEN;
	}

	public Lettre(int x, int y, int largeur, int hauteur, Color color) {
		super(x, y, largeur, hauteur);
		this.vitesse = new Point(10,3);
		Random r = new Random();
		this.lettre =  String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
		this.color = color;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		matrix();
		
	}
	
	@Override
	public void dessiner(Graphics g) {
		//réaction à la gravité
        position.y += (int) (Math.random() * 8 + 1);
	
		
        
		g.setColor(color);
		g.setFont(new Font("sans serif", Font.PLAIN, 9+position.y/50)); 
		g.drawString(lettre, position.x, position.y+volume.height);
		//g.drawRect(position.x, position.y, volume.width, volume.height);
		
		if(position.y > UI.HAUTEUR_FENETRE){
			position.y = 0;
		}
		//position.y += (int) (Math.random() * 99 + 1);
		Random r = new Random();
		this.lettre =  String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
		

	}

	private void matrix() {
		if(position.y > UI.HAUTEUR_FENETRE){
			position.y = 0;
		}
		position.y += (int) (Math.random() * 99 + 1);
		Random r = new Random();
		this.lettre =  String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
		

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
