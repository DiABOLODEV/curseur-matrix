package moteur;

//import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		/*SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	
		    }
		  });*/
		UI ui = new UI("Curseur Matrix");
		new Moteur(ui.getStrategy(), new Jeu(ui.getCanvas()));
		
	}

}
