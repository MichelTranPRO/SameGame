import java.awt.*;
import java.lang.*;

public class AlgoVoisin{
	public static ObjetGrille[] getVoisinDirect(ObjetGrille[][] matrice, int x, int y){
		ObjetGrille[] tabVoisin = new ObjetGrille[4];
		int compt=0;

		//voisins horizontaux
		for(int i=-1; i<=1; i+=2){
			// si les coords sont dansla matrice
			if((x+i)>=0 && y>=0 && (x+i)<10 && y<15){
				// si l'objet existe
				if(matrice[x+i][y]!=null){
					// si ils ont la même couleur
					if (matrice[x][y].getClr().equals(matrice[x+i][y].getClr())){
						tabVoisin[compt]=matrice[x+i][y];
						compt+=1;
					}
				}
			}
		}

		//voisins verticaux
		for(int i=-1; i<=1; i+=2){
			if(x>=0 && (y+i)>=0 && x<10 && (y+i)<15){
				if(matrice[x][y+i]!=null){
					if (matrice[x][y].getClr().equals(matrice[x][y+i].getClr())){
						tabVoisin[compt]=matrice[x][y+i];
						compt+=1;
					}
				}
			}
		}
		return tabVoisin;
	}

	public static boolean contient(ObjetGrille[] tab, ObjetGrille obj){
		boolean cont = false;
		int index = 0;

		while(index<tab.length && tab[index]!=null){
			if(tab[index].equals(obj)){
				cont = true;
			}
			index+=1;
		}
		return cont;
	}

	public static ObjetGrille[] getVoisin(ObjetGrille[][] matrice, int x, int y){
		ObjetGrille[] allVoisin = new ObjetGrille[150];
		int comptAV=0, parc=0;

		allVoisin[comptAV] = matrice[x][y];
		comptAV+=1;
		while(comptAV<allVoisin.length && allVoisin[parc]!=null){
			int incrTemp = 0;
			ObjetGrille[] tempVoisin = AlgoVoisin.getVoisinDirect(matrice, allVoisin[parc].getX(), allVoisin[parc].getY());
			while(incrTemp<tempVoisin.length && tempVoisin[incrTemp]!=null){
				if(!AlgoVoisin.contient(allVoisin,tempVoisin[incrTemp])){
					allVoisin[comptAV]=tempVoisin[incrTemp];
					comptAV+=1;
				}
				incrTemp+=1;
			}
			parc+=1;
		}
		return allVoisin;
	}
}