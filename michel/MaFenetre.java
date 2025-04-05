import javax.swing.*;
import java.awt.*;

public class MaFenetre extends JFrame{
	public MaFenetre(){
		super();
		this.setSize(1050,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(10,15));
	}
}