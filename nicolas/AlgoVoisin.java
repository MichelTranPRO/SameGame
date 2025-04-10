import java.awt.*;

public class AlgoVoisin{
	public static ObjetGrille[] getVoisinDirect(ObjetGrille[][] matrice, int ligne, int col){
		ObjetGrille[] tabVoisin = new ObjetGrille[4];
		int compt=0;

		//voisins horizontaux
		for(int i=-1; i<=1; i+=2){
			// si les coords sont dansla matrice
			if((ligne+i)>=0 && col>=0 && (ligne+i)<10 && col<15){
				// si l'objet existe
				if(matrice[ligne+i][col]!=null){
					// si ils ont la même couleur
					if (matrice[ligne][col].getClr().equals(matrice[ligne+i][col].getClr())){
						tabVoisin[compt]=matrice[ligne+i][col];
						compt+=1;
					}
				}
			}
		}

		//voisins verticaux
		for(int i=-1; i<=1; i+=2){
			if(ligne>=0 && (col+i)>=0 && ligne<10 && (col+i)<15){
				if(matrice[ligne][col+i]!=null){
					if (matrice[ligne][col].getClr().equals(matrice[ligne][col+i].getClr())){
						tabVoisin[compt]=matrice[ligne][col+i];
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

	public static ObjetGrille[] getVoisin(ObjetGrille[][] matrice, int lig, int col){
		ObjetGrille[] allVoisin = new ObjetGrille[150];
		int comptAV=0, parc=0;

		allVoisin[comptAV] = matrice[lig][col];
		comptAV+=1;
		while(comptAV<allVoisin.length && allVoisin[parc]!=null){
			int incrTemp = 0;
			ObjetGrille[] tempVoisin = AlgoVoisin.getVoisinDirect(matrice, allVoisin[parc].getMyY(), allVoisin[parc].getMyX());
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