import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MonPanelMap extends JPanel {
    public JButton randomMap = new JButton("RANDOM MAP");
    public JButton definedMap = new JButton("DEFINED MAP");
    public JPanel panelBouton = new JPanel();
    public int choix = 1;
    public ImageMap imageMap = new ImageMap();
    public MonPanelMap(){
        

        panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        randomMap.setPreferredSize(new Dimension(200, 50));
        randomMap.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 2;
                imageMap.setChoix(choix);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        definedMap.setPreferredSize(new Dimension(200, 50));
        definedMap.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                choix = 1;
                imageMap.setChoix(choix);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        panelBouton.add(randomMap);
        panelBouton.add(definedMap);

        
        imageMap.setOpaque(true);
        
        this.setLayout(new BorderLayout());
        this.add(panelBouton,BorderLayout.NORTH);
        this.add(imageMap, BorderLayout.CENTER);
        


    }
    
}