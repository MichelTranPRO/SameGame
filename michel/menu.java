import java.awt.BorderLayout;

public class menu{
    public static void main(String[] args) {
        Fenetre maFenetre = new Fenetre();
        MonPanelTitre titre = new MonPanelTitre();
        MonPanelMap maps = new MonPanelMap();
        maFenetre.addPanel(titre, maps);
        
    }
}