import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
            Fenetre fenetreMenu = new Fenetre();
            MonPanelTitre titre = new MonPanelTitre();
            MonPanelMap maps = new MonPanelMap(fenetreMenu);
            
            fenetreMenu.addPanel(titre, maps);
            fenetreMenu.setVisible(true);
    }
}
