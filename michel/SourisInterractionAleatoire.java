import java.awt.event.*;
import javax.swing.*;

public class SourisInterractionAleatoire implements MouseListener{
    private int choix;
    private ImageMap imageCarte;
    private char[][] choixMap;
    private ConfigMap configuration;
    private MaMatrice matriceGrille;
    private Fenetre fenetreMenu;
    private MaFenetreJeu fenetreJeu;
    private boolean statutRandom;
    /** 
     * Panneau de jeu. 
     */
    private PanelJeu jeu;

    /** 
     * Panneau d'affichage des scores. 
     */
    private PanelScore score;
    public SourisInterractionAleatoire(int c, ImageMap i, char[][] cm, ConfigMap confMap, MaMatrice matrGrille, Fenetre fenMenu, MaFenetreJeu fenJeu, Boolean statRand, PanelJeu j, PanelScore s){
        this.choix = c;
        this.imageCarte = i;
        this.choixMap = cm;
        this.configuration = confMap;
        this.matriceGrille = matrGrille;
        this.fenetreMenu = fenMenu;
        this.fenetreJeu = fenJeu;
        this.statutRandom = statRand; 
        this.jeu = j;
        this.score = s;

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (configuration.selectRand()) {
            choixMap = configuration.getGrilleChoix(); /** Récupère un tableau aléatoire de char[][] avec "R","G" et "B" à l'intérieur.*/
            matriceGrille = new MaMatrice(10, 15, jeu, choixMap, score);

            if (choixMap != null) {
                fenetreJeu = new MaFenetreJeu(jeu, score);
                fenetreMenu.dispose();
                fenetreJeu.setVisible(true);
                statutRandom = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /** --- ACTION SOURIS SUR LE COMPOSANT --- **/
    @Override
    public void mouseEntered(MouseEvent e) {
        choix = 2;
        imageCarte.setChoix(choix);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
