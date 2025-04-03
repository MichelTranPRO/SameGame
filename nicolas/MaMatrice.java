import java.awt.*;
import java.lang.*;
import javax.swing.*;

public class MaMatrice{
	private ObjetGrille[][] matr;

	public MaMatrice(int hauteur, int largeur, MaFenetre fen){
		super();
		this.matr = new ObjetGrille[hauteur][largeur];
		for(int ligne=0; ligne<hauteur; ligne+=1){
			for(int col=0; col<largeur; col+=1){
				this.matr[ligne][col] = new ObjetGrille(ligne,col,Color.CYAN);
				fen.add(matr[ligne][col]);
			}
		}
	}

	public ObjetGrille[][] getMatr(){
		return this.matr;
	}

	public ObjetGrille getObj(int x, int y){
		return this.matr[x][y];
	}
}