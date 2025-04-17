import java.awt.event.*;
/**
 * La classe <code>SourisInterractionAleatoire</code> est utilisé pour gérer les actions du bouton "Carte Aléatoire".
 * @author Michel Tran 
 * @version 1.1
 */
public class SourisInterractionAleatoire implements MouseListener{

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
    * Indique si une carte aléatoire a été sélectionnée. 
    */
    private boolean statutRandom;
    /** 
     * Panneau de jeu. 
     */
    private PanelJeu jeu;

    /** 
     * Panneau d'affichage des scores. 
     */
    private PanelScore score;
    
    /**
     * Constructeur de la classe <code>SourisInterractionAleatoire</code> permet de faire le lien avec <code>MonPanelMap</code>.
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
    public SourisInterractionAleatoire(int choixRef, ImageMap imageCarteRef, char[][] choixMapRef, ConfigMap confMap, MaMatrice matrGrilleRef, Fenetre fenMenuRef, MaFenetreJeu fenJeuRef, Boolean statRand, PanelJeu jeuRef, PanelScore scoreRef){
        this.choix = choixRef;
        this.imageCarte = imageCarteRef;
        this.choixMap = choixMapRef;
        this.configuration = confMap;
        this.matriceGrille = matrGrilleRef;
        this.fenetreMenu = fenMenuRef;
        this.fenetreJeu = fenJeuRef;
        this.statutRandom = statRand; 
        this.jeu = jeuRef;
        this.score = scoreRef;

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

    @Override
    public void mouseEntered(MouseEvent e) {
        choix = 2;
        imageCarte.setChoix(choix);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
