import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

public class MonPanelTitre extends JPanel{
    JLabel titre = new JLabel("SameGame");
    int nouvelleTaille;

    public MonPanelTitre (){

        this.titre.setFont(new Font ("Arial", Font.BOLD, 24));
        add(titre);

        addComponentListener(new ComponentAdapter() { // Si la taille de la fenetre est changée
            @Override
            public void componentResized(ComponentEvent e) {
              changerTailleTexte();
            }
          });
    }

    private void changerTailleTexte(){
        nouvelleTaille = getWidth() / 15;
        titre.setFont(new Font("Arial", Font.BOLD, nouvelleTaille));
    }
}