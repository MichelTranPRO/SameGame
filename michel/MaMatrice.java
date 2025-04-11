import java.awt.*;
import java.lang.*;
import javax.swing.*;

public class MaMatrice{
	private ObjetGrille[][] matr;
	private Color couleurObjet; 
	private char[][] grilleTemp; 

	public MaMatrice(int hauteur, int largeur, PanelJeu jeu, char[][] couleur, PanelScore scorePanel){
		super();
		this.grilleTemp = new char[10][15];
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 15; j++){
				this.grilleTemp[i][j] = couleur[i][j];
			}
		}
		this.matr = new ObjetGrille[hauteur][largeur];
		for(int ligne = 0; ligne < hauteur; ligne += 1){
			for(int col = 0; col < largeur; col += 1){
				if (couleur[ligne][col] == 'R'){
					couleurObjet = Color.RED;
				}
				else if (couleur[ligne][col] == 'V'){
					couleurObjet = Color.GREEN;
				}
				else if (couleur[ligne][col] == 'B'){
					couleurObjet = Color.CYAN;
				}
				this.matr[ligne][col] = new ObjetGrille(ligne, col, couleurObjet, this, scorePanel); 
				jeu.add(matr[ligne][col]);
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