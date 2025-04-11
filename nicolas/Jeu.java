import javax.swing.*;
import java.awt.*;

public class Jeu{
	public static void main(String[] args){
		MaFenetre fenetre = new MaFenetre();
		MaMatrice matrice = new MaMatrice(10,15,fenetre);

		fenetre.setVisible(true);
	}
}