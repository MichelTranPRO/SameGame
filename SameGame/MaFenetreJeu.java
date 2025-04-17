import javax.swing.JFrame;
import java.awt.*;

/**
 * La classe <code>MaFenetreJeu</code> est utilisée pour gérer et afficher le jeu.
 * @version 1.1
 * @author Michel Tran
 */
public class MaFenetreJeu extends JFrame {
    /**
     * Composante de la hauteur.
     */
    private int HEIGHT;

    /**
     * Composante de la largeur.
     */
    private int WIDTH;

    /**
     * Panneau contenant la partie jeu.
     */

    private PanelJeu jeu;
    /**
     * Panneau contenant la partie score.
     */
    private PanelScore score;

    /**
     * Constructeur de la classe <code>MaFenetreJeu</code>. 
     * Défini les paramètres de la fenetre et fais le lien avec la classe <code>PanelJeu</code> et <code>PanelScore</code>.
     * Ajoute les panneaux de la classe <code>PanelJeu</code> au centre et <code>PanelScore</code> à gauche.
     * @param j le panneau qui sera positionné à droite, contenant tous les objets du jeu.
     * @param s le panneau qui sera positionné à gauche, contenant tous les objets de la partie du score.
     */
    public MaFenetreJeu (PanelJeu j, PanelScore s){
        this.HEIGHT = 800; 
        this.WIDTH = 1000;
        this.jeu = j;
        this.score = s;
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        add(jeu,BorderLayout.CENTER);
        add(score, BorderLayout.WEST);
    }
}
