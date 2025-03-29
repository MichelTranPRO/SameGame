import javax.swing.JFrame;
import java.awt.*;

public class Fenetre extends JFrame{
    private int HEIGHT = 600, WIDTH = 800;
    public Fenetre (){
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    public void addPanel(MonPanelTitre panelTitre, MonPanelMap panelMap){
        this.add(panelTitre, BorderLayout.NORTH);
        this.add(panelMap, BorderLayout.CENTER);
    }
}
