import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

/**
 * La classe <code>Fenetre</code> est utilisée pour générer et afficher le menu.
 * @version 1.1
 * @author Michel Tran
 */
public class FenetreFin extends JFrame{
    /**
     * Composante de la hauteur.
     */
    private int HEIGHT = 300; 

    /**
     * Composante de la largeur.
     */
    private int WIDTH = 500;

    /**
     * Lien avec la classe <code>PanelScore</code>.
     */
    private PanelScore score;

    /**
     * Texte contenant le score final.
     */
    private JLabel resultatScore;
    
    /**
     * Bouton permettant de rejouer.
     */
    private JButton boutonRejouer; 

    private RejouerInterraction actionRejouer;
    private Menu menu;

    /**
     * Constructeur de la classe <code>Fenetre</code>. Défini les paramètres de la fenetre.
     * @param scoreRef référence à la classe <code>PanelScore</code>.
     */
    public FenetreFin (PanelScore scoreRef){
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());

        menu = new Menu();
        actionRejouer = new RejouerInterraction(this);
        this.boutonRejouer = new JButton("Rejouer");
        boutonRejouer.setPreferredSize(new Dimension(200, 50));
        boutonRejouer.addMouseListener(actionRejouer);
        this.score = scoreRef;
        this.resultatScore = new JLabel("Bravo ! Vous avez réalisé un socre de : "+ score.getScore()+ "pts");



        this.add(resultatScore,BorderLayout.NORTH);
        this.add(boutonRejouer,BorderLayout.CENTER);


    }


}
