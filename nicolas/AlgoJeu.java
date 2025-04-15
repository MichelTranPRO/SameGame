import java.awt.*;

/**
 * La classe <code>AlgoJeu</code> rassemble tous les algorithmes permettant le bon fonctionnement du jeu.
 * 
 *  
 * @version 1.1
 * @author Nicolas Miekisiak
 */
public class AlgoJeu{

	// Algorithmes de recherche des vosins :
	/**
	* Renvoie un tableau d'ObjetGrille contenant les voisins directs d'un objet dans une matrice.
	*
	* @param matrice une matrice d'ObjetGrille
	* @param ligne la ligne à laquelle l'objet est situé
	* @param col la col à laquelle l'objet est situé
	* 
	* @return un tableau d'ObjetGrille contenant les voisins directs d'un objet dans une matrice.
	*/
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

	/**
	* Renvoie true si un tableau d'ObjetGrille contient un objet, false sinon.
	*
	* @param tab tableau d'ObjetGrille à parcourir.
	* @param obj l'ObjetGrille à comparé.
	* 
	* @return true si l'objet est dedans, false sinon.
	*/
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

	/**
	* Renvoie un tableau d'ObjetGrille contenant tous les voisins d'un objet.
	*
	* @param matrice une matrice d'ObjetGrille.
	* @param lig la ligne à laquelle l'objet est situé.
	* @param col la col à laquelle l'objet est situé.
	* 
	* @return un tableau d'ObjetGrille contenant tous les voisins d'un objet.
	*/
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
	/**
	* Change l'attribut survole de tous les ObjetGrille d'un tableau.
	*
	* @param tabVoisins le tableau contenant les voisins à modifier.
	* @param etat l'etat (true ou false) à assigné a l'attribut survole de chaque voisin.
	* 
	* @return le tableau d'ObjetGrille mis en argument.
	*/
	public static ObjetGrille[] setSurvoleVoisin(ObjetGrille[] tabVoisins, boolean etat){
		int compt = 0;
		while(tabVoisins[compt]!=null){
			tabVoisins[compt].setSurvole(etat);
			tabVoisins[compt].repaint();
			compt+=1;
		}
		return tabVoisins;
	}

	/**
	* Met l'etat à false des ObjetGrille d'un tableau et les caches.
	*
	* @param tabVoisins le tableau contenant les voisins à casser.
	* 
	* @return le nombre de voisin(s) cassé.
	*/
	public static int casserVoisin(ObjetGrille[] tabVoisins){ // renvoi le nombre de voisin cassé
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
	/**
	* Renvoie un tableau(int) des colonnes affectée par casserVoisin().
	*
	* @param tabVoisins le tableau contenant les voisins cassés.
	* @param nbVoisinCasse le nombre de voisins cassés.
	* 
	* @return un tableau(int) des colonnes affectée.
	*/
	public static int[] getColCasse(ObjetGrille[] tabVoisins, int nbVoisinCasse){
		int[] colCasse = new int[15]; // 15 est le nombre max de col cassée.
		// on remplit le tableau de -1 pour éviter les confusions.
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

	/**
	* Fait chuter les ObjetGrille si nécessaire.
	*
	* @param matrice la matrice d'ObjetGrille du jeu.
	* @param colCasse les colonnes affectées par CasserVoisin().
	* 
	*/
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

	// vérifications et maj pour les colonnes vides
	/**
	* Renvoie true si une colonne est vide, false sinon.
	*
	* @param matrVoisins la matrice d'ObjetGrille du jeu.
	* @param nbCol le numéro de la colonne à vérifier.
	* 
	* @return true si une colonne est vide, false sinon.
	*/
	public static boolean colVide(ObjetGrille[][] matrVoisins, int nbCol){
		boolean vide = true;
		for(int i=0; i<matrVoisins.length; i+=1){
			if(matrVoisins[i][nbCol].getMyEtat()){
				vide=false;
			}
		}
		return vide;
	}

	/**
	* Trie un tableau dans l'ordre décroissant avec un bubble sort.
	*
	* @param tab le tableau à trier.
	* 
	*/
	public static void descTriBulle(int[] tab){
		for(int i=tab.length-1; i>=0; i-=1){
			for(int j=0; j<i; j+=1){
				if(tab[j]<tab[j+1]){
					int temp = tab[j+1];
					tab[j+1] = tab[j];
					tab[j] = temp;
				}
			}
		}
	}

	/**
	* Colle les colonnes à gauche si il y en a une vide.
	*
	* @param matrice la matrice d'ObjetGrille du jeu.
	* @param colCasse un talbeau des colonnes cassées.
	* 
	*/
	public static void majColVide(ObjetGrille[][] matrice, int[] colCasse){
		AlgoJeu.descTriBulle(colCasse); // on trie dans l'odre décroissant
		for(int col : colCasse){
			if(AlgoJeu.colVide(matrice, col)){
				for(int x=0; x<matrice[0].length-(col+1); x+=1){
					for(int y=0; y<matrice.length; y+=1){
						if((col+x)<15){
							// on vole les attributs du suivant
							ObjetGrille objActuel = matrice[y][col+x];
							objActuel.setClr(matrice[y][col+x+1].getClr());
							objActuel.setEtat(matrice[y][col+x+1].getMyEtat());
							if(objActuel.getMyEtat()){
								objActuel.setVisible(true);
							}
							objActuel.repaint();
							// on enlève les attributs de l'objet suivant
							matrice[y][col+x+1].setEtat(false);
							matrice[y][col+x+1].setVisible(false);
							matrice[y][col+x+1].repaint();
						}
					}
				}
			}
		}
	}
}