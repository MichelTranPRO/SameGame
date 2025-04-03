import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Jeu{
	public static void main(String[] args){
		MaFenetre fenetre = new MaFenetre();
		MaMatrice matrice = new MaMatrice(10,15,fenetre);
		ObjetGrille[] tab = AlgoVoisin.getVoisin(matrice.getMatr(),0,0);

		for(ObjetGrille elem : tab){
			System.out.print(elem.getX()+", ");
			System.out.println(elem.getY());
		}

		fenetre.setVisible(true);
	}
}