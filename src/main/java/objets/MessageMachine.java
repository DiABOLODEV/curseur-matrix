package objets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class MessageMachine extends Objet{

	private String message;
	private int tick;
	private int tickCurseur;
	private double delai = 0.2; // en seconde délai de tappage
	private double lastTime;
	private Random r = new Random();
	private String alphabet = "$£€*%§";
	
	public MessageMachine(int x, int y, int largeur, int hauteur, String message, String separateur) {
		super(x, y, largeur, hauteur);
		this.message = message;
		tick = 0;
		tickCurseur = 0;
		lastTime = 0;
		volume.width = message.length()*16;
	}
	
	@Override
	public void dessiner(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(position.x, position.y, volume.width, 30);
		g.setColor(Color.white);
		g.setFont(new Font("sans serif", Font.PLAIN, 10)); 
		int i;
		for(i = 0; i < tick; i++){
			g.drawString(String.valueOf(message.charAt(i)), position.x+20+i*13, position.y+18);
			
		}
		if(tickCurseur % 2 == 0){
			g.setColor(Color.green);
			g.drawString(String.valueOf(alphabet.charAt(r.nextInt(alphabet.length()))), position.x+20+i*13, position.y+18);
		}
		g.drawRect(position.x, position.y, volume.width, 30);
		
		//Le tick curseur va deux fois plus vite que l'affichage des lettres
		
		
		if((System.currentTimeMillis() - lastTime > (delai/2)*1000)){
			tickCurseur++;
		}
		if(tick != message.length() && (System.currentTimeMillis() - lastTime > delai*1000)){
			tick ++;
			lastTime = System.currentTimeMillis();
		}
		
		
	}

}
