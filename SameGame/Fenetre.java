import javax.swing.JFrame;
import java.awt.*;

/**
 * La classe <code>Fenetre</code> est utilisée pour générer et afficher le menu.
 * @version 1.1
 * @author Michel Tran
 */
public class Fenetre extends JFrame{
    /**
     * Composante de la hauteur
     */
    private int HEIGHT = 600; 

    /**
     * Composante de la largeur
     */
    private int WIDTH = 800;

    /**
     * Constructeur de la classe <code>Fenetre</code>. Défini les paramètres de la fenetre.
     */
    public Fenetre (){
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    /**
     * Permet d'ajouter des objets de la classe <code>MonPanelTitre</code> et <code>MonPanelMap</code> à la fenetre.
     * @param panelTitre le panneau qui sera positionné en haut, contenant tous les objets de la partie titre.
     * @param panelMap le panneau qui sera positionné au centre, contenant tous les objets de la partie map.
     */
    public void addPanel(MonPanelTitre panelTitre, MonPanelMap panelMap){
        this.add(panelTitre, BorderLayout.NORTH);
        this.add(panelMap, BorderLayout.CENTER);
    }
}
