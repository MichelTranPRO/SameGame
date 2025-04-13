import java.awt.*;

public class AlgoJeu{

	// Algorithmes de recherche des vosins :
	public static ObjetGrille[] getVoisinDirect(ObjetGrille[][] matrice, int ligne, int col){
		ObjetGrille[] tabVoisin = new ObjetGrille[4];
		int compt=0;

		//voisins verticaux
		for(int i=-1; i<=1; i+=2){
			// si les coords sont dans la matrice
			if((ligne+i)>=0 && col>=0 && (ligne+i)<10 && col<15){
				// si l'objet existe et est vivant
				if(matrice[ligne+i][col]!=null && matrice[ligne+i][col].getMyEtat()){
					// si ils ont la même couleur
					if (matrice[ligne][col].getClr().equals(matrice[ligne+i][col].getClr())){
						tabVoisin[compt]=matrice[ligne+i][col];
						compt+=1;
					}
				}
			}
		}

		//voisins horizontaux
		for(int i=-1; i<=1; i+=2){
			if(ligne>=0 && (col+i)>=0 && ligne<10 && (col+i)<15){
				if(matrice[ligne][col+i]!=null && matrice[ligne][col+i].getMyEtat()){
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
			ObjetGrille[] tempVoisin = AlgoJeu.getVoisinDirect(matrice, allVoisin[parc].getMyY(), allVoisin[parc].getMyX());
			while(incrTemp<tempVoisin.length && tempVoisin[incrTemp]!=null){
				if(!AlgoJeu.contient(allVoisin,tempVoisin[incrTemp])){
					allVoisin[comptAV]=tempVoisin[incrTemp];
					comptAV+=1;
				}
				incrTemp+=1;
			}
			parc+=1;
		}
		return allVoisin;
	}
	// fin des algorithmes de recherche des voisins.

	// pour les MouseListener :
	public static ObjetGrille[] setSurvoleVoisin(ObjetGrille[] tabVoisins, boolean etat){
		int compt = 0;
		while(tabVoisins[compt]!=null){
			tabVoisins[compt].setSurvole(etat);
			tabVoisins[compt].repaint();
			compt+=1;
		}
		return tabVoisins;
	}

	public static int casserVoisin(ObjetGrille[] tabVoisins){ // renvoi le nombre de voisin en plus
		int nbVoisin=0; 
        if (tabVoisins[1] != null){
            while(tabVoisins[nbVoisin]!=null){
                tabVoisins[nbVoisin].setVisible(false); // on le cache
                tabVoisins[nbVoisin].setEtat(false); // on met son etat a false
                nbVoisin += 1;
            }
        }
        return nbVoisin;
	}

	// vérifications pour la "gravité".
	public static int[] getColCasse(ObjetGrille[] tabVoisins, int nbVoisinCasse){
		int[] colCasse = new int[15]; // 15 est le nombre max de col cassée.
		// on rempli le tableau de -1 pour éviter les confusions.
		for(int i=0; i<colCasse.length; i+=1){
			colCasse[i]=-1;
		}

		int colPrise=0;
		for(int vois=0; vois<nbVoisinCasse; vois+=1){	
			int temp = tabVoisins[vois].getMyX();
			boolean in = false;

			//on check si il y est déjà.
			for(int compt=0; compt<colCasse.length; compt+=1){
				if (colCasse[compt]==temp){
					in = true;
				}
			}
			if(!in){
				colCasse[colPrise] = temp;
				colPrise+=1;
			}
		}

		// création d'un tableau avec pile les bonnes dimensions
		int[] finColCasse = new int[colPrise];
		for(int i=0; i<colPrise; i+=1){
			finColCasse[i]=colCasse[i];
		}

		return finColCasse;
	}

	public static void gererGravite(ObjetGrille[][] matrice, int[] colCasse){
		for(int col : colCasse){
			// on commence de la dernière ligne
			for(int y = matrice.length-1; y>=0; y-=1){
				ObjetGrille objActuel = matrice[y][col];
				// si la case est "morte"
				if(!objActuel.getMyEtat()){
					int yTemp = y-1;
					boolean trouve = false;
					while(yTemp>=0 && !trouve){
						ObjetGrille objTemp = matrice[yTemp][col];
						if(objTemp.getMyEtat()){
							// on lui met les attributs de l'objTemp
							objActuel.setClr(matrice[yTemp][col].getClr());
							objActuel.setEtat(true);
							objActuel.setVisible(true);
							// on enlève les attributs de l'objTemp
							objTemp.setEtat(false);
							objTemp.setVisible(false);
							objTemp.repaint();
							trouve=true;
						}
						yTemp-=1;
					}
					objActuel.repaint();
				}
			}
		}
	}

	public static boolean colVide(ObjetGrille[][] matrVoisins, int nbCol){
		boolean vide = false;
		for(int i=0; i<matrVoisins.length; i+=1){
			if(matrVoisins[i][nbCol].getMyEtat()){
				vide=true;
			}
		}
		return vide;
	}
}