package moteur;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import objets.Dot;
import objets.Informations;
import objets.Lettre;
import objets.MessageMachine;
import objets.Objet;
import objets.Phrase;

public class Jeu implements KeyListener{
	private Canvas canvas;
	private ArrayList<Objet> objets;
	private Dot dot;
	private Informations infos;
	private MessageMachine message;
	private Boolean jeuFini = false;
	private int timer = 0;
	private int best = 0;
	
	public Jeu(Canvas canvas){
		this.canvas = canvas;
		canvas.requestFocus();
		canvas.addKeyListener(this);
		objets = new ArrayList<Objet>();
		
		
		initObjets();
	}
	private void initObjets() {
		objets.clear();
		for(int i = 0; i < 40 ; i++){
			Lettre lettre = new Lettre(i*UI.LARGEUR_FENETRE/40, (int) (Math.random() * UI.HAUTEUR_FENETRE + 1), 8,8);
			//canvas.addKeyListener(lettre);
			objets.add(lettre);
		}
		dot = new Dot(0,0,16,16);
		canvas.addMouseMotionListener(dot);
		infos = new Informations(UI.LARGEUR_FENETRE/2-150, UI.HAUTEUR_FENETRE/2-100, 300, 300, "", "-");
		String m = "MATRIX CURSEUR";
		message = new MessageMachine(UI.LARGEUR_FENETRE/2-110, UI.HAUTEUR_FENETRE/2-100, 0, 0,m,"-");

	}
	/*
	 * Appeler à chaque boucle
	 */
	public void dessiner(Graphics g) {
		
		
		if(jeuFini){
			if(timer > best){
				best = timer;
			}
			message.dessiner(g);
			infos.setMessage("---Aïe ton curseur est rentré dans la matrice !--Score : "+timer+" pts-Record : "+best+" pts--> appuyez sur votre clavier pour rejouer <", "-");
			infos.dessiner(g);
		}
		else{
			timer++;
			dot.dessiner(g);
			if(timer % 100 == 0){
				Lettre lettre = new Lettre((int) (Math.random() * UI.LARGEUR_FENETRE ), (int) (Math.random() * UI.HAUTEUR_FENETRE + 1), 16,16, Color.red);
				objets.add(lettre);
			}
			for (Objet o : objets){
				o.dessiner(g);
				if(dot.collisionAvec(o, Lettre.class)){
					jeuFini = true;
				}
				
			}
		}

		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(jeuFini == true){
			//on enléve les lettres en plus ^^
			
			timer = 0;
			jeuFini = false;
			initObjets();
		
		}
		//cheat
		if(e.getKeyChar() == '$'){
			timer += 1000;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setJeuFini(Boolean jeuFini) {
		this.jeuFini = jeuFini;
	}
	

}
