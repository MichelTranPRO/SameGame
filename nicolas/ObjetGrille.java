import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>ObjetGrille</code> représente un objet de la matrice du jeu.
 * 
 *  
 * @version 1.1
 * @author Nicolas Miekisiak
 */

public class ObjetGrille extends JComponent{
	/**
	* Variable contenant les coordonnées x de l'objet.
	*/
	private int x;
	/**
	* Variable contenant les coordonnées y de l'objet.
	*/
	private int y;
	/**
	* Booléen qui est true si l'objet est survolé, false sinon.
	*/
	private boolean survole;
	/**
	* Booléen qui est true si l'objet est vivant, false sinon.
	*/
	private boolean myEtat;

	/**
    * Constructeur unique destiné a la création d'un ObjetGrille.
    *
    * @param y l'abcisse ou ligne dans la matrice.
    * @param x l'ordonnée ou colonne dans la matrice.
    * @param clr La couleur de l'ObjetGrille.
    */
	public ObjetGrille(int y,int x,Color clr){
		super();
		this.x=x;
		this.y=y;
		this.survole=false;
		this.myEtat=true;
		this.setClr(clr);
	}

	/**
	* change la couleur de l'objet.
	*
	* @param coul la nouvelle couleur a attribué à l'objet
	*/
	public void setClr(Color coul){
		this.setBackground(coul);
	}

	/**
	* change la variable survole.
	*
	* @param bool le booléen a attribué a survole, true si survolé, false sinon.
	*/
	public void setSurvole(boolean bool){
		this.survole=bool;
	}

	/**
	* change la variable myEtat.
	*
	* @param bool le booléen a attribué a myEtat, true si vivant, false sinon.
	*/
	public void setEtat(boolean bool){
		this.myEtat=bool;
	}

	/**
	* Renvoie la couleur de l'objet.
	*
	* @return la couleur de l'objet
	*/
	public Color getClr(){
		return this.getBackground();
	}

	/**
	* Renvoie la ligne attribuée à l'objet dans la matrice.
	*
	* @return la ligne attribuée à l'objet dans la matrice
	*/
	public int getMyX(){
		return this.x;
	}

	/**
	* Renvoie la colonne attribuée à l'objet dans la matrice.
	*
	* @return la colonne attribuée à l'objet dans la matrice
	*/
	public int getMyY(){
		return this.y;
	}

	/**
	* Renvoie l'etat de l'objet.
	*
	* @return l'etat de l'objet
	*/
	public boolean getMyEtat(){
		return this.myEtat;
	}

	/**
	* compare l'objet avec un autre et renvoie true si ils sont pareilles, false sinon.
	*
	* @param comp l'objet avec lequel on compare le notre
	* 
	* @return true si ils sont pareilles, false sinon
	*/
	public boolean equals(ObjetGrille comp){
		if(this.x == comp.getMyX() && this.y == comp.getMyY()){
			if(this.getClr()==comp.getClr()){
				return true;
			}
		}
		return false;
	}

	/**
	* dessine l'objet dans une fenêtre avec une forme différente en fonction de sa couleur.
	*
	* @param pinceau Objet venant de la classe Graphics
	*/
	@Override
	protected void paintComponent(Graphics pinceau) {
	    Graphics secondPinceau = pinceau.create();
	    if (this.isOpaque()) {
	      secondPinceau.setColor(this.getBackground());
	      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	    }

	    if(this.survole){
	    	secondPinceau.setColor(Color.YELLOW);
	    	secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	    }

	    secondPinceau.setColor(this.getClr());
	    if(this.getClr()==Color.CYAN){
		    secondPinceau.fillOval(0, 2, this.getWidth(), this.getHeight()-2);
		}
		else if(this.getClr()==Color.RED){
			int[] xRuby = {10,0,this.getWidth()/2,this.getWidth(),this.getWidth()-10};
			int[] yRuby = {2,10,this.getHeight(),10,2};
		    secondPinceau.fillPolygon(xRuby,yRuby,5);
		}
		else if(this.getClr()==Color.GREEN){
			int[] xEmeraude = {2,17,this.getWidth()-17,this.getWidth()-2,
							  this.getWidth()-2,this.getWidth()-17,17,2};
			int[] yEmeraude = {17,2,2,17,
							  this.getHeight()-17,this.getHeight()-2,this.getHeight()-2,this.getHeight()-17};
		    secondPinceau.fillPolygon(xEmeraude,yEmeraude,8);
		}
	    }
}