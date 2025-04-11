import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MonPanelMap extends JPanel {
    private JButton randomMap;
    private JButton definedMap;
    private JPanel panelBouton;
    private int choix;
    private ImageMap imageMap;
    private ConfigMap configuration; 
    private char[][] choixMap;
    private boolean statutRandom;
    private boolean statutDefined;
    private MaFenetreJeu fenetreJeu;
    private MaMatrice matriceGrille;
    private PanelJeu jeu;
    private PanelScore score;
    private Fenetre fenetreMenu;

    public MonPanelMap(Fenetre f){

        this.fenetreMenu = f;
        this.configuration = new ConfigMap();
        this.imageMap = new ImageMap();
        this.choix = 1;
        this.panelBouton = new JPanel();
        this.definedMap = new JButton("DEFINED MAP");
        this.randomMap = new JButton("RANDOM MAP");
        this.jeu = new PanelJeu();
        this.score = new PanelScore();

        panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));

        // RANDOM MAP 
        randomMap.setPreferredSize(new Dimension(200, 50));
        randomMap.addMouseMotionListener(new MouseMotionListener() { // changer image en fonction du bouton
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 2;
                imageMap.setChoix(choix);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        randomMap.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                configuration.setChoix("random");
                choixMap = configuration.getGrilleChoix();
                matriceGrille = new MaMatrice(10, 15, jeu, choixMap,score);

                if (choixMap != null){
                    fenetreJeu = new MaFenetreJeu(jeu,score);
                    fenetreMenu.dispose();
                    fenetreJeu.setVisible(true);
                statutRandom = true;
                }
            }
        });

        // DEFINED MAP
        definedMap.setPreferredSize(new Dimension(200, 50));
        definedMap.addMouseMotionListener(new MouseMotionListener() { // changer image en fonction du bouton
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 1;
                imageMap.setChoix(choix);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        definedMap.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configuration.setChoix("defined");
                choixMap = configuration.getGrilleChoix();
                matriceGrille = new MaMatrice(10, 15, jeu, choixMap,score);

                if (choixMap != null){
                    fenetreJeu = new MaFenetreJeu(jeu,score);
                    fenetreMenu.dispose();
                    fenetreJeu.setVisible(true);
                }
                statutDefined = true;
            }
        });

        panelBouton.add(randomMap);
        panelBouton.add(definedMap);
        
        imageMap.setOpaque(true);
        
        this.setLayout(new BorderLayout());
        this.add(panelBouton,BorderLayout.NORTH);
        this.add(imageMap, BorderLayout.CENTER);
        


    }
    public char[][] getChoixGrille(char[][] grilleFinal) {
        if (choixMap == null) {
            System.out.println("Erreur : aucun choix de map n'a encore été fait");
            return grilleFinal;
        }
    
        for (int ligne = 0; ligne < 10; ligne++) {
            for (int colonne = 0; colonne < 15; colonne++) {
                grilleFinal[ligne][colonne] = choixMap[ligne][colonne];
            }
        }
        return grilleFinal;
    }
  
    
}