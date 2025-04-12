import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MaMatrice{
	private ObjetGrille[][] matr;

	public MaMatrice(int hauteur, int largeur, PanelJeu pan, char[][] tabCoul, PanelScore scorePanel){
		super();
		Color couleur = Color.CYAN;
		this.matr = new ObjetGrille[hauteur][largeur];
		for(int ligne=0; ligne<hauteur; ligne+=1){
			for(int col=0; col<largeur; col+=1){
				if(tabCoul[ligne][col]=='R'){
					couleur=Color.RED;
				}
				else if(tabCoul[ligne][col]=='V'){
					couleur=Color.GREEN;
				}
				else if(tabCoul[ligne][col]=='B'){
					couleur=Color.CYAN;
				}
				this.matr[ligne][col] = new ObjetGrille(ligne,col,couleur);
				matr[ligne][col].addMouseListener(
					new MouseInteraction(matr[ligne][col],this.matr, scorePanel));
				pan.add(matr[ligne][col]);
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