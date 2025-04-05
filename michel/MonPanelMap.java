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
    private MaFenetre fenetreJeu;
    private MaMatrice matriceGrille;

    public MonPanelMap(){

        this.configuration = new ConfigMap();
        this.imageMap = new ImageMap();
        this.choix = 1;
        this.panelBouton = new JPanel();
        this.definedMap = new JButton("DEFINED MAP");
        this.randomMap = new JButton("RANDOM MAP");
        this.fenetreJeu = new MaFenetre();

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
                System.out.println("randomMap Cliqué");
                matriceGrille = new MaMatrice(10, 15, fenetreJeu, choixMap);

                if (choixMap != null){
                    fenetreJeu.setVisible(true);
                for (int i = 0; i < choixMap.length; i++) {
                    for (int j = 0; j < choixMap[i].length; j++) {
                        System.out.print(choixMap[i][j] + " ");
                    }
                    System.out.println();
                }
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
                System.out.println("definedmap Cliqué");
                matriceGrille = new MaMatrice(10, 15, fenetreJeu, choixMap);

                if (choixMap != null){
                    fenetreJeu.setVisible(true);
                    for (int i = 0; i < choixMap.length; i++) {
                        for (int j = 0; j < choixMap[i].length; j++) {
                            System.out.print(choixMap[i][j] + " ");
                        }
                        System.out.println();
                    }
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