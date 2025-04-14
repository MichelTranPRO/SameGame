import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>ImageMap</code> est utilisée pour générer l'image de la carte définie ou aléatoire.
 * @version 1.1
 * @author Michel Tran
 */
public class ImageMap extends JComponent {
    /**
     * Image de la carte définie.
     */
    private Image definedMap;

    /**
     * Image de la carte aléatoire.
     */
    private Image randomMap;

    /**
     * Choix de la carte.
     */
    private int choix;

    /** Constructeur de la classe <code>ImageMap</code> qui défini le chemin des fichiers "png", ainsi que le choix par défaut.*/
    public ImageMap() {
        super();
        this.definedMap = Toolkit.getDefaultToolkit().getImage("image/definedMap.png");
        this.randomMap = Toolkit.getDefaultToolkit().getImage("image/randomMap.png");
        this.choix = 1;
    }
    /**
     * Défini le choix et change l'image affiché en fonction du choix.
     * @param ch choix de l'image (1 ou 2).
     */
    public void setChoix(int ch) {
        this.choix = ch;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics pinceau) {
        super.paintComponent(pinceau); 
        Graphics secondPinceau = pinceau.create();
        if (this.isOpaque()) {
            secondPinceau.setColor(this.getBackground());
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        if (choix == 2) {
            secondPinceau.drawImage(this.randomMap, 0, 0, getWidth(), getHeight(), this);
        }
        if (choix == 1) {
            secondPinceau.drawImage(this.definedMap, 0, 0, getWidth(), getHeight(), this);
        }

        secondPinceau.dispose();
    }
}
