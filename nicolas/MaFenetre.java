import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>MaFenetre</code> génère une fenêtre.
 *  
 * @version 1.1
 * @author Nicolas Miekisiak
 */
public class MaFenetre extends JFrame{
	/**
    * Constructeur unique destiné a la création de la fenêtre.
    *
    */
	public MaFenetre(){
		super();
		this.setSize(1050,700);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
}