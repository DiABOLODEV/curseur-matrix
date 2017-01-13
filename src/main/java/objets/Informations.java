package objets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Informations extends Objet{
	
	private String[] messages;
	private int fps;
	private long time;
	public Informations(int x, int y, int largeur, int hauteur, String message, String separateur) {
		super(x, y, largeur, hauteur);
		time = System.currentTimeMillis();
		setMessage(message, separateur);
		
	}
	public void dessiner(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("sans serif", Font.PLAIN, 10)); 
		for(int i = 0; i < messages.length; i++){
			g.drawString(messages[i], position.x+20, position.y+i*15+20);
		}
		g.drawRect(position.x, position.y, volume.width, messages.length*15+30);
	}
	
	public void dessinerFPS(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("sans serif", Font.PLAIN, 10)); 
		fps = (int) (1000 / (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		g.setColor(Color.cyan);
		g.setFont(new Font("sans serif", Font.PLAIN, 10)); 
		g.drawString("FPS : "+fps, position.x, position.y);
	}
	
	public void setMessage(String message, String separateur){
		messages = message.split(separateur);
	}

}
