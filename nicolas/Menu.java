/**
 * Classe principale du programme.
 * Elle initialise la fenêtre du menu, le titre et les différentes cartes,
 * puis lance l'affichage de l'interface utilisateur.
 * @author Michel Tran
 * @version 1.1
 */
public class Menu {

    /**
     * Point d'entrée du programme.
     * Initialise la fenêtre principale avec les différents panneaux (titre et carte),
     * puis rend la fenêtre visible.
     *
     * @param args les arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
        Fenetre fenetreMenu = new Fenetre();
        MonPanelTitre titre = new MonPanelTitre();
        MonPanelMap maps = new MonPanelMap(fenetreMenu);
            
        fenetreMenu.addPanel(titre, maps);
        fenetreMenu.setVisible(true);
    }
}
