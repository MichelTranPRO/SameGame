import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.*;

public class menu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            char[][] grilleCouleur = new char[10][15];
            MaMatrice matriceGrille;
            
            MaFenetre fenetreJeu = new MaFenetre(); 
            Fenetre fenetreMenu = new Fenetre();

            MonPanelTitre titre = new MonPanelTitre();
            MonPanelMap maps = new MonPanelMap();


            fenetreMenu.addPanel(titre, maps);
            
        });
    }
}
