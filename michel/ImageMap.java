import javax.swing.*;
import java.awt.*;

public class ImageMap extends JComponent {
    private Image definedMap;
    private Image randomMap;
    private int choix;

    public ImageMap() {
        super();
        this.definedMap = Toolkit.getDefaultToolkit().getImage("definedMap.png");
        this.randomMap = Toolkit.getDefaultToolkit().getImage("randomMap.png");
        this.choix = 1;
    }

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
