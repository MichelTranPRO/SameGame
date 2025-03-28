import javax.swing.*;
import java.awt.*;

public class Img extends JComponent {
    private Image random;
    private Image defined;
    public int choix;
    private int imageWidth = 400;   // Largeur souhaitée pour l'image
    private int imageHeight = 275;

    public Img() {
        this.random = Toolkit.getDefaultToolkit().getImage("randomMap.png");
        this.defined = Toolkit.getDefaultToolkit().getImage("defined.png");
        this.choix = 1;
    }

    public void setChoix(int ch){
        this.choix = ch;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics pinceau) {
        super.paintComponent(pinceau); 

        // dessin des images en fonction du choix
        if (choix == 1) { // defined
            pinceau.drawImage(this.defined, 0, 0, getWidth(), getHeight(), this);
        } else if (choix == 2) { // random
            pinceau.drawImage(this.random, 0, 0, getWidth(), getHeight(), this);
        }

        if (this.isOpaque()) {
            pinceau.setColor(this.getBackground());
            pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
