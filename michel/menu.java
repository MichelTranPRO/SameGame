import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.*;

public class menu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fenetre maFenetre = new Fenetre();
            MonPanelTitre titre = new MonPanelTitre();
            MonPanelMap maps = new MonPanelMap();
            maFenetre.addPanel(titre, maps);
        });
    }
}
