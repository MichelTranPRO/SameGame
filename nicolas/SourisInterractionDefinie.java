import java.awt.event.*;
import javax.swing.*;

public class SourisInterractionDefinie implements MouseListener{
    /** 
     * Valeur qui contient soit 1 ou 2, si la souris est au dessus du bouton "Carte aléatoire" alors choix = 2, 
     * et si la souris est au dessus du bouton "Carte définie" alors choix = 1. 
     */
    private int choix;

    /** 
     * Composant graphique affichant une image correspondant au choix. 
     */
    private ImageMap imageCarte;

    /** 
     * Grille choisie par l'utilisateur (définie ou aléatoire). 
     */
    private char[][] choixMap;

    /** 
     * Objet de gestion de la configuration de la carte. 
     */
    private ConfigMap configuration;

    /** 
     * Objet représentant la matrice du jeu. 
     */
    private MaMatrice matriceGrille;

    /** 
     * Fenêtre du menu principal. 
     */
    private Fenetre fenetreMenu;

    /** 
     * Fenêtre de jeu affichée après sélection d'une carte. 
     */
    private MaFenetreJeu fenetreJeu;

    /** 
    * Indique si une carte définie a été sélectionnée. 
    */
    private boolean statutDefined;
    /** 
     * Panneau de jeu. 
     */
    private PanelJeu jeu;

    /** 
     * Panneau d'affichage des scores. 
     */
    private PanelScore score;
    
    /**
     * 
     * @param choixRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param imageCarteRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param choixMapRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param confMap variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param matrGrilleRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param fenMenuRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param fenJeuRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param statRand variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param jeuRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     * @param scoreRef variable nécessaire à la référence de la classe <code>MonPanelMap</code>.
     */
    public SourisInterractionDefinie(int choixRef, ImageMap imageCarteRef, char[][] choixMapRef, ConfigMap confMap, MaMatrice matrGrilleRef, Fenetre fenMenuRef, MaFenetreJeu fenJeuRef, Boolean statDefRef, PanelJeu jeuRef, PanelScore scoreRef){
        this.choix = choixRef;
        this.imageCarte = imageCarteRef;
        this.choixMap = choixMapRef;
        this.configuration = confMap;
        this.matriceGrille = matrGrilleRef;
        this.fenetreMenu = fenMenuRef;
        this.fenetreJeu = fenJeuRef;
        this.statutDefined = statDefRef; 
        this.jeu = jeuRef;
        this.score = scoreRef;

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
