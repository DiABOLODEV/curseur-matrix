package objets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import moteur.Jeu;
import moteur.UI;

public class Dot extends Objet implements KeyListener, MouseMotionListener{
	private Jeu jeu;
	private Point mouse;
	
	public Dot(int x, int y, int largeur, int hauteur) {
		super(x, y, largeur, hauteur);
		mouse = new Point(0,0);
	}
	
	public void dessiner(Graphics g){
		//Point mouse = MouseInfo.getPointerInfo().getLocation();
		if(mouse.x >= UI.LARGEUR_FENETRE){
			mouse.x = UI.LARGEUR_FENETRE-volume.width;
		}
		if(mouse.x < 0){
			mouse.x = volume.width;
		}
		if(mouse.y >= UI.HAUTEUR_FENETRE){
			mouse.y = UI.HAUTEUR_FENETRE-volume.height;
		}
		if(mouse.y < 0){
			mouse.y = volume.height;
		}
		position = mouse;
		//c'est le pointeur de la souris !
		/*g.setColor(Color.green);
		g.setFont(new Font("sans serif", Font.PLAIN, 10)); 
		g.drawString("néo", position.x, position.y+volume.height*2/3);
		g.drawRect(position.x, position.y, volume.width, volume.height);*/
		//g.fillOval(position.x, position.y, volume.width, volume.height);
	}




	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
					
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_UP){
			
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN){
			
		}
				
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouse = new Point(arg0.getX(), arg0.getY());
		
	}
}
