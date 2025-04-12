import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelJeu extends JPanel{
    int HEIGHT, WIDTH;
    public PanelJeu(){
        super();
        this.HEIGHT = 10; 
        this.WIDTH = 15;
        this.setLayout(new GridLayout(HEIGHT,WIDTH));
    }
}