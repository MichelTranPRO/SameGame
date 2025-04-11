import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class MaFenetreJeu extends JFrame {
    private int HEIGHT, WIDTH;
    private PanelJeu jeu;
    private PanelScore score;
    public MaFenetreJeu (PanelJeu j, PanelScore s){
        this.HEIGHT = 800; 
        this.WIDTH = 1000;
        this.jeu = j;
        this.score = s;
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SameGame");
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        add(jeu,BorderLayout.CENTER);
        add(score, BorderLayout.WEST);
    }
}
