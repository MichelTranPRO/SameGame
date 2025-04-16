
import java.awt.event.*;
import javax.swing.*;

public class RejouerInterraction implements MouseListener{
    private FenetreFin fenetreFin;
    private Fenetre fenetreMenu;
    public RejouerInterraction(FenetreFin fenetreFinRef){
        this.fenetreFin = fenetreFinRef;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        fenetreFin.dispose();
        // code a mettre pour relance le programme
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
