import javax.swing.JFrame;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
        PanelScore score = new PanelScore();
        Fenetre fenetreMenu = new Fenetre();
        FenetreFin fenetreFin = new FenetreFin(score);
        fenetreFin.setVisible(true);

        MonPanelTitre titre = new MonPanelTitre();
        MonPanelMap maps = new MonPanelMap(fenetreMenu);
        
        fenetreMenu.addPanel(titre, maps);
    }
}
