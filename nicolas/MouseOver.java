import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseOver implements MouseListener{
	private ObjetGrille objAssoc;
	private ObjetGrille[][] matrice;
	private static ObjetGrille[] dernierVoisin;

	public MouseOver(ObjetGrille objAssoc, ObjetGrille[][] matrice){
		super();
		this.objAssoc=objAssoc;
		this.matrice=matrice;
	}

	@Override
	public void mouseClicked(MouseEvent evenement){
	}

	@Override
	public void mouseEntered(MouseEvent evenement){
		ObjetGrille[] temp = AlgoVoisin.getVoisin(this.matrice, this.objAssoc.getMyY(), this.objAssoc.getMyX());
		int compt = 0;
		while(temp[compt]!=null){
			temp[compt].setSurvole(true);
			temp[compt].repaint();
			compt+=1;
		}
		this.dernierVoisin=temp;
	}

	@Override
	public void mouseExited(MouseEvent evenement){
		int compt = 0;
		while(this.dernierVoisin[compt]!=null){
			this.dernierVoisin[compt].setSurvole(false);
			this.dernierVoisin[compt].repaint();
			compt+=1;
		}
	}

	@Override
	public void mousePressed(MouseEvent evenement){}

	@Override
	public void mouseReleased(MouseEvent evenement){}
}