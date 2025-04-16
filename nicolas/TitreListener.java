import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
/**
 * La classe <code>MonPanelTitre</code> est utilisée pour gérer le panneau contenant le titre.
 * @version 1.1
 * @author Michel Tran
 */
public class TitreListener extends ComponentAdapter{
    /**
     * Panneau associé avec le listenre
     */
    private JPanel pan; 
    /**
     * Texte du titre.
     */
    private JLabel titre; 
    /**
     * Composante de la nouvelle taille de police.
     */
    private int nouvelleTaille;


    public TitreListener(JLabel titre, JPanel pan) {
        super();
        this.pan=pan;
        this.titre=titre;
    }

    /**
     * Ajuste dynamiquement la taille de la police en fonction de la largeur du panneau.
     */
    private void changerTailleTexte() {
        nouvelleTaille = this.pan.getWidth() / 15;
        this.titre.setFont(new Font("Arial", Font.BOLD, nouvelleTaille));
    }

    @Override
    public void componentResized(ComponentEvent e) {
       changerTailleTexte();
    }
}