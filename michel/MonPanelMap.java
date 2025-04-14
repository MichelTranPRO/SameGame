import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * La classe <code>MonPanelMap</code> est utilisée pour gérer le panneau contenant les boutons
 * de sélection d'une carte (définie ou aléatoire), ainsi que l'affichage de l'image associée.
 * 
 * @version 1.1
 * @author Michel Tran
 */
public class MonPanelMap extends JPanel {

    /** 
     * Bouton pour sélectionner le choix "Carte aléatoire". 
     */
    private JButton carteAleatoire;

    /** 
     * Bouton pour sélectionner le choix "Carte définie". 
     */
    private JButton carteDefinie;

    /** 
     * Panneau contenant les boutons de choix de carte. 
     */
    private JPanel panelBouton;

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
     * Objet de gestion de la configuration de la carte. 
     */
    private ConfigMap configuration;

    /** 
     * Grille choisie par l'utilisateur (définie ou aléatoire). 
     */
    private char[][] choixMap;

    /** 
     * Indique si une carte aléatoire a été sélectionnée. 
     */
    private boolean statutRandom;

    /** 
     * Indique si une carte définie a été sélectionnée. 
     */
    private boolean statutDefined;

    /** 
     * Fenêtre de jeu affichée après sélection d'une carte. 
     */
    private MaFenetreJeu fenetreJeu;

    /** 
     * Objet représentant la matrice du jeu. 
     */
    private MaMatrice matriceGrille;

    /** 
     * Panneau de jeu. 
     */
    private PanelJeu jeu;

    /** 
     * Panneau d'affichage des scores. 
     */
    private PanelScore score;

    /** 
     * Fenêtre du menu principal. 
     */
    private Fenetre fenetreMenu;

    /**
     * Constructeur de la classe <code>MonPanelMap</code>.
     * Initialise les composants et configure les actions des boutons.
     * 
     * @param f la fenêtre principale (menu) à fermer après lancement du jeu.
     */
    public MonPanelMap(Fenetre f) {
        this.fenetreMenu = f;
        this.configuration = new ConfigMap();
        this.imageCarte = new ImageMap();
        this.choix = 1;
        this.panelBouton = new JPanel();
        this.carteDefinie = new JButton("Carte définie");
        this.carteAleatoire = new JButton("Carte aléatoire");
        this.jeu = new PanelJeu();
        this.score = new PanelScore();

        panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        /** --- BOUTON CARTE ALÉATOIRE --- **/
        carteAleatoire.setPreferredSize(new Dimension(200, 50));
        carteAleatoire.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 2;
                imageCarte.setChoix(choix);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Rien à faire ici
            }
        });

        carteAleatoire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configuration.selectRand(); /** Envoie l'information du choix. */
                choixMap = configuration.getGrilleChoix(); /** Récupère un tableau aléatoire de char[][] avec "R","G" et "B" à l'intérieur.*/
                matriceGrille = new MaMatrice(10, 15, jeu, choixMap, score);

                if (choixMap != null) {
                    fenetreJeu = new MaFenetreJeu(jeu, score);
                    fenetreMenu.dispose();
                    fenetreJeu.setVisible(true);
                    statutRandom = true;
                }
            }
        });

        /** --- BOUTON CARTE DÉFINIE --- **/
        carteDefinie.setPreferredSize(new Dimension(200, 50));
        carteDefinie.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 1;
                imageCarte.setChoix(choix);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        carteDefinie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        /** Ajout des boutons au panneau. */
        panelBouton.add(carteAleatoire);
        panelBouton.add(carteDefinie);

        imageCarte.setOpaque(true);

        this.setLayout(new BorderLayout());
        this.add(panelBouton, BorderLayout.NORTH);
        this.add(imageCarte, BorderLayout.CENTER);
    }

    /**
     * Retourne la grille sélectionnée par l'utilisateur, copiée dans une grille cible.
     *
     * @param grilleFinal la grille dans laquelle copier le contenu choisi.
     * @return la grille remplie avec le choix utilisateur ou la grille originale si aucune sélection n'a été faite.
     */
    public char[][] getChoixGrille(char[][] grilleFinal) {
        if (choixMap == null) {
            System.out.println("Erreur : aucun choix de map n'a encore été fait");
            return grilleFinal;
        }

        for (int ligne = 0; ligne < 10; ligne++) {
            for (int colonne = 0; colonne < 15; colonne++) {
                grilleFinal[ligne][colonne] = choixMap[ligne][colonne];
            }
        }
        return grilleFinal;
    }
}
