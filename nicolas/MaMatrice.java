import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MaMatrice{
	private ObjetGrille[][] matr;

	public MaMatrice(int hauteur, int largeur, JFrame fen){
		super();
		Random graine = new Random();
		Color couleur = Color.CYAN;
		this.matr = new ObjetGrille[hauteur][largeur];
		for(int ligne=0; ligne<hauteur; ligne+=1){
			for(int col=0; col<largeur; col+=1){
				int aleatoire = graine.nextInt(3);
				if(aleatoire==0){
					couleur=Color.CYAN;
				}
				else if(aleatoire==1){
					couleur=Color.RED;
				}
				else if(aleatoire==2){
					couleur=Color.GREEN;
				}
				this.matr[ligne][col] = new ObjetGrille(ligne,col,couleur);
				matr[ligne][col].addMouseListener(new MouseOver(matr[ligne][col],this.matr));
				fen.add(matr[ligne][col]);
			}
		}
	}

	public ObjetGrille[][] getMatr(){
		return this.matr;
	}

	public ObjetGrille getObj(int x, int y){
		return this.matr[y][x];
	}
}