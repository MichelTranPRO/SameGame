import javax.swing.*;
import java.awt.*;

public class Jeu{
	public static void main(String[] args){
		MaFenetre fenetre = new MaFenetre();
		MaMatrice matrice = new MaMatrice(10,15,fenetre);
		ObjetGrille[] tab = AlgoVoisin.getVoisin(matrice.getMatr(),0,0);

		for(ObjetGrille elem : tab){
			if(elem!=null){
				System.out.print(elem.getMyY()+", ");
				System.out.println(elem.getMyX());
			}
		}
		fenetre.setSize(1050,700);
		fenetre.setVisible(true);
	}
}