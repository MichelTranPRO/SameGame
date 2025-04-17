import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>MouseInteraction</code> gère les interractions entre la souris et les ObjetGrille.
 *
 *  
 * @version 1.1
 * @author Nicolas Miekisiak
 */
public class MouseInteraction implements MouseListener{
	/**
	* Variable contenant l'objet auquel la classe est associée.
	*/
	private ObjetGrille objAssoc;
	/**
	* Variable contenant la matrice du jeu.
	*/
	private ObjetGrille[][] matrice;
	/**
	* Variable contenant une réference au panneau de score.
	*/
	private PanelScore scoreRef;
	/**
	* Variable contenant une réference a la fenêtre de fin.
	*/
	private FenetreFin fenFin;
	/**
	* Variable contenant un tableau du dernir group de voisins visités.
	* static car il n'y aura toujours qu'un seul groupe dernierement visité
	*/
	private static ObjetGrille[] dernierVoisin;

	/**
    * Constructeur unique destiné a la création d'un MouseInteraction.
    *
    * @param objAssoc l'ObjetGrille Associé au Listener
    * @param matrice la matrice de la partie en cours.
    * @param scorePanel la référence au panneau de score.
    */
	public MouseInteraction(ObjetGrille objAssoc, ObjetGrille[][] matrice, PanelScore scorePanel){
		super();
		this.objAssoc=objAssoc;
		this.matrice=matrice;
		this.scoreRef=scorePanel;
		this.fenFin = new FenetreFin(this.scoreRef);
	}

	/**
    * Interaction lors du clique sur un ObjetGrille.
    * Appelle les fonctions qui cassent les voisins et gèrent les conséquences.
    * 
    * @param evenement géré en dehors du code.
    */
	@Override
	public void mouseClicked(MouseEvent evenement){
		// on casse les voisins.
		int nbVoisinCasse = AlgoJeu.casserVoisin(this.dernierVoisin);
		scoreRef.setScore(nbVoisinCasse);

		// on fait chuter les cases.
		int[] colCasse = AlgoJeu.getColCasse(this.dernierVoisin, nbVoisinCasse);
		AlgoJeu.gererGravite(this.matrice,colCasse);

		//on colle a gauche
		AlgoJeu.majColVide(this.matrice,colCasse);

		// on recalcule les voisins après les ajustements.
		AlgoJeu.setSurvoleVoisin(this.dernierVoisin, false);
		ObjetGrille[] temp = AlgoJeu.getVoisin(this.matrice, this.objAssoc.getMyY(), this.objAssoc.getMyX());
		this.dernierVoisin = AlgoJeu.setSurvoleVoisin(temp, true);

		if(AlgoJeu.partieFinie(this.matrice)){
			this.fenFin.setVisible(true);
		}
	}

	/**
    * Interaction lorsque la souris passe sur un ObjetGrille.
    * Appelle les fonctions qui calculent et  mettent en surbrillance les voisins.
    * 
    * @param evenement géré en dehors du code.
    */
	@Override
	public void mouseEntered(MouseEvent evenement){
		ObjetGrille[] temp = AlgoJeu.getVoisin(this.matrice, this.objAssoc.getMyY(), this.objAssoc.getMyX());
		// on les met en surbrillance et on stocke le tableau pour le réutilisé
		this.dernierVoisin = AlgoJeu.setSurvoleVoisin(temp, true);
	}

	/**
    * Interaction lorsque la souris sort d'un ObjetGrille.
    * Appelle la fonction qui retire la surbrillance.
    * 
    * @param evenement géré en dehors du code.
    */
	@Override
	public void mouseExited(MouseEvent evenement){
		AlgoJeu.setSurvoleVoisin(this.dernierVoisin, false);
	}

	/**
    * Inutilisé
    * 
    * @param evenement géré en dehors du code.
    */
	@Override
	public void mousePressed(MouseEvent evenement){}

	/**
    * Inutilisé
    * 
    * @param evenement géré en dehors du code.
    */
	@Override
	public void mouseReleased(MouseEvent evenement){}
}