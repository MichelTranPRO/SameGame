import java.awt.*;
import javax.swing.*;
import java.util.Random;

/**
 * La classe <code>MaMatrice</code> génère la matrice du jeu.
 * 
 *  
 * @version 1.1
 * @author Nicolas Miekisiak
 */
public class MaMatrice{
	private ObjetGrille[][] matr;

	/**
	* Unique constructeur de MaMatrice qui génère une matrice et les ajoutes à un panel.
	*
	* @param hauteur la hauteur de la matrice.
	* @param largeur la largeur de la matrice.
	* @param pan le panneau dans lequel les ObjetGrille seront mis.
	* @param tabCoul la matrice des couleurs qui définira le pattern de la map.
	* @param scorePanel le panneau de score qui sera influencé par les ObjetGrille de la matrice.
	* 
	*/
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

	/**
	* Renvoie la matrice générée dans le constructeur.
	* 
	* @return la matrice générée dans le constructeur.
	* 
	*/
	public ObjetGrille[][] getMatr(){
		return this.matr;
	}
}