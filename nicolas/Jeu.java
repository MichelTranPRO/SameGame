import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Jeu{
	public static void main(String[] args){
		MaFenetre fenetre = new MaFenetre();
		PanelJeu panneauJeu = new PanelJeu();
		PanelScore panneauScore = new PanelScore();
		Random random = new Random();
        char[] tabColor = {'R', 'V', 'B'};
        char[][] tabCoul = new char[10][15];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                int cleTab = random.nextInt(3);  // Génère un nombre entre 0 et 2
                tabCoul[i][j] = tabColor[cleTab];
            }
        }
		MaMatrice matrice = new MaMatrice(10,15,panneauJeu, tabCoul, panneauScore);
		fenetre.add(panneauScore,BorderLayout.WEST);
		fenetre.add(panneauJeu,BorderLayout.CENTER);
		fenetre.setVisible(true);
	}
}