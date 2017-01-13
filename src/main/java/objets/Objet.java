package objets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


/*
 * Objet Physique
 */
public abstract class Objet {
	protected Point position;
	protected Point vitesse;
	protected Rectangle volume;
	protected int zindex; // sur quel plan il se trouve
	
	public Objet(int x, int y, int largeur, int hauteur){
		this.position = new Point(x, y);
		this.vitesse = new Point(0,0);
		this.volume = new Rectangle(largeur, hauteur);
	}
	public void dessiner(Graphics g){
		g.setColor(Color.green);
		g.drawRect(position.x, position.y, volume.width, volume.height);
	}
	public boolean collisionAvec(Objet autre, Class classe){
		if(classe.isInstance(autre)){
			Rectangle autreVolume = new Rectangle(autre.getPosition().x, autre.getPosition().y, autre.getVolume().width, autre.getVolume().height);
			volume.setBounds(position.x,position.y, volume.width, volume.height);
			return volume.intersects(autreVolume);
		}
	    return false;
	}
	public Point getPosition() {
		return position;
	}
	public Rectangle getVolume() {
		return volume;
	}
	
	
}
