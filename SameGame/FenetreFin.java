import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;

/**
 * La classe <code>FenetreFin</code> est utilisée pour générer et afficher le fenetre de fin.
 * @version 1.1
 * @author Michel Tran
 */
public class FenetreFin extends JFrame{
    /**
     * Composante de la hauteur.
     */
    private int HEIGHT = 250; 

    /**
     * Composante de la largeur.
     */
    private int WIDTH = 450;

    /**
     * Texte contenant le score final.
     */
    private JLabel resultatScore;

    /**
     * Constructeur de la classe <code>FenetreFin</code>.
     * Defini les paramètres de la fenetre.
     */
    public FenetreFin (){
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());

    }
    /**
     * La méthode <code>setScore</code> permet de modifier le score de la classe <code>FenetreFin</code> et d'afficher le score final.
     * @param s score à afficher.
     */
    public void setScore(int s){
        int scoreFin = s;
        this.resultatScore = new JLabel("Bravo ! Vous avez réalisé un score de : "+ scoreFin+ "pts");
        this.resultatScore.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(resultatScore);
    }


}
