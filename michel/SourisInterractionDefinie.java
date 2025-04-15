import java.awt.event.*;
import javax.swing.*;

public class SourisInterractionDefinie implements MouseListener{
    private int choix;
    private ImageMap imageCarte;
    private char[][] choixMap;
    private ConfigMap configuration;
    private MaMatrice matriceGrille;
    private Fenetre fenetreMenu;
    private MaFenetreJeu fenetreJeu;
    private boolean statutDefined;

    /** 
     * Panneau de jeu. 
     */
    private PanelJeu jeu;

    /** 
     * Panneau d'affichage des scores. 
     */
    private PanelScore score;
    public SourisInterractionDefinie(int c, ImageMap i, char[][] cm, ConfigMap confMap, MaMatrice matrGrille, Fenetre fenMenu, MaFenetreJeu fenJeu, Boolean statDef, PanelJeu j, PanelScore s){
        this.choix = c;
        this.imageCarte = i;
        this.choixMap = cm;
        this.configuration = confMap;
        this.matriceGrille = matrGrille;
        this.fenetreMenu = fenMenu;
        this.fenetreJeu = fenJeu;
        this.statutDefined = statDef; 
        this.jeu = j;
        this.score = s;

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (configuration.selectDefined()) {
            choixMap = configuration.getGrilleChoix(); /** Récupère les caractères du fichier et les mets dans un tableau de char [][].*/
            matriceGrille = new MaMatrice(10, 15, jeu, choixMap, score);

            if (choixMap != null) {
                fenetreJeu = new MaFenetreJeu(jeu, score);
                fenetreMenu.dispose();
                fenetreJeu.setVisible(true);
                statutDefined = true;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        choix = 1;
        imageCarte.setChoix(choix);
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
