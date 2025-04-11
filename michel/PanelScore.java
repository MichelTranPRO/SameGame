import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class PanelScore extends JPanel {
    int score, HEIGHT, WIDTH;
    JLabel scoreTexte,vide1,vide2;
    public PanelScore(){
        this.HEIGHT=3;
        this.WIDTH=1;
        this.vide1 = new JLabel(" ");
        this.vide2 = new JLabel(" ");
        this.setLayout(new GridLayout(HEIGHT,WIDTH));
        this.score = 0;
        this.scoreTexte = new JLabel("score : " + String.format("%04d", score));
        add(vide1);
        add(scoreTexte);
        add(vide2);
    }

    public void setScore(int nbVoisin){
        this.score = score + (nbVoisin-2)*(nbVoisin-2);
        scoreTexte.setText("score : " + String.format("%04d", score));
    }
    
}
