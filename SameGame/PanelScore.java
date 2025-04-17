import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * La classe <code>PanelScore</code> est utilisée pour gérer l'affichage du score.
 * @version 1.1
 * @author Michel Tran
 */
public class PanelScore extends JPanel {
    /**
     * Valeur du score.
     */
    private int score;
    /**
     * Constante de la hauteur du grid.
     */
    private int HEIGHT;
    /**
     * Constante de la largeur du grid.
     */
    private int WIDTH;
    /** 
     * Texte du score.
     */
    private JLabel scoreTexte,vide1,vide2;
    /**
     * Constructeur de la classe <code>PanelScore</code>. Initialise les paramètres du panneau.
     */
    public PanelScore(){
        this.HEIGHT=3;
        this.WIDTH=1;
        this.vide1 = new JLabel(" ");
        this.vide2 = new JLabel(" ");
        this.setLayout(new GridLayout(HEIGHT,WIDTH));
        this.score = 0;
        this.scoreTexte = new JLabel("score : " + String.format("%04d", score));
        add(vide1);
        add(scoreTexte);
        add(vide2);
    }

     /**
     * Définie le nouveau score, grace à la formule (nombre de voisins - 2)².
     * @param nbVoisin nombre de voisins de la meme couleur.
     */
    public void setScore(int nbVoisin){
        if(nbVoisin!=0){
            this.score = score + (nbVoisin-2)*(nbVoisin-2);
            scoreTexte.setText("score : " + String.format("%04d", score));
        }
    }   

    /**
     * Permet de recevoir la valeur de la variable score.
     * @return la valeur de la variable score.
     */
    public int getScore(){
        return score;
    }
}
