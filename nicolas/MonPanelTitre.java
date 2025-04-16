import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

/**
 * La classe <code>MonPanelTitre</code> est utilisée pour gérer le panneau contenant le titre.
 * @version 1.1
 * @author Michel Tran
 */
public class MonPanelTitre extends JPanel {
    /**
     * Texte du titre.
     */
    private JLabel titre = new JLabel("SameGame");
    /**
     * Constructeur de la classe <code>MonPanelTitre</code>.
     * Définit la police initiale et ajoute un écouteur pour ajuster la taille du texte
     * lorsque la fenêtre est redimensionnée.
     */
    public MonPanelTitre() {
        this.titre.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titre);
        this.addComponentListener(new TitreListener(this.titre,this));
    }
}
