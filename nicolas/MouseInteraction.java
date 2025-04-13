import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseInteraction implements MouseListener{
	private ObjetGrille objAssoc;
	private ObjetGrille[][] matrice;
	private PanelScore scoreRef;
	// static car il n'y aura toujours qu'un seul groupe dernierement visité.
	private static ObjetGrille[] dernierVoisin;

	public MouseInteraction(ObjetGrille objAssoc, ObjetGrille[][] matrice, PanelScore scorePanel){
		super();
		this.objAssoc=objAssoc;
		this.matrice=matrice;
		this.scoreRef=scorePanel;
	}

	@Override
	public void mouseClicked(MouseEvent evenement){
		// on casse les voisins.
		int nbVoisinCasse = AlgoJeu.casserVoisin(this.dernierVoisin);
		scoreRef.setScore(nbVoisinCasse);
		// on fait chuter les cases.
		int[] colCasse = AlgoJeu.getColCasse(this.dernierVoisin, nbVoisinCasse);
		AlgoJeu.gererGravite(this.matrice,colCasse);
		// on recalcule les voisins après la chute.
		AlgoJeu.setSurvoleVoisin(this.dernierVoisin, false);
		ObjetGrille[] temp = AlgoJeu.getVoisin(this.matrice, this.objAssoc.getMyY(), this.objAssoc.getMyX());
		this.dernierVoisin = AlgoJeu.setSurvoleVoisin(temp, true);
	}

	@Override
	public void mouseEntered(MouseEvent evenement){
		ObjetGrille[] temp = AlgoJeu.getVoisin(this.matrice, this.objAssoc.getMyY(), this.objAssoc.getMyX());
		// on les met en surbrillance et on stocke le tableau pour le réutilisé
		this.dernierVoisin = AlgoJeu.setSurvoleVoisin(temp, true);
	}

	@Override
	public void mouseExited(MouseEvent evenement){
		AlgoJeu.setSurvoleVoisin(this.dernierVoisin, false);
	}

	@Override
	public void mousePressed(MouseEvent evenement){}

	@Override
	public void mouseReleased(MouseEvent evenement){}
}