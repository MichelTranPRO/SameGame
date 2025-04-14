import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * La classe <code>PanelJeu</code> est utilisée pour gérer l'affichage du jeu.
 * @version 1.1
 * @author Michel Tran
 */
public class PanelJeu extends JPanel{
    
    /**
     * Constante de la hauteur du grid.
     */
    private int HEIGHT;

    /**
     * Constante de la largeur du grid.
     */
    private int WIDTH;

    /**
     * Constructeur de la classe <code>PanelJeu</code>. Initialise les paramètres du panneau.
     */
    public PanelJeu(){
        this.HEIGHT = 10; 
        this.WIDTH = 15;
        this.setLayout(new GridLayout(HEIGHT,WIDTH));
    }
    
}
