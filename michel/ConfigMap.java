import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * La classe <code>ConfigMap</code> permet de gérer la configuration de la grille.
 * 
 * @version 1.1
 * @author Michel Tran
 */

public class ConfigMap {
    /**
     * Tableau qui contient les couleurs de la grille finale.
     */
    private char[][] grille;
    
    /**
     * Fichier de configuration choisi.
     */
    private File fichier;

    /**
     * Sélecteur de fichiers utilisé pour choisir un fichier de configuration.
     */
    private JFileChooser selectFichier;

    /**
     * Filter permettant de choisir seulement les fichiers "txt".
     */
    private FileNameExtensionFilter filtre;

    /**
     * Constructeur de la classe <code>ConfigMap</code>. Initialise la grille, prépare le filtre et défini le dossier par défaut. 
     */
    public ConfigMap() {
        this.fichier = new File("");
        this.grille = new char[10][15];
        this.filtre = new FileNameExtensionFilter(" ","txt");
        this.selectFichier = new JFileChooser();selectFichier.setFileFilter(filtre);
        selectFichier.setCurrentDirectory(new File("./map"));
        
    }

    /**
     * Ouvre une boite de dialogue pour sélectionner le fichier voulu.
     * @return si un fichier a été sélectioné alors la méthode renvoie <code>true</code> sinon <code>false</code>.
     */
    public boolean selectDefined(){
        if (selectFichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.fichier = selectFichier.getSelectedFile();
            lireFichier(this.fichier);
            return true;
        } else {
            System.out.println("Aucun fichier sélectionné.");
            return false;
        }
    }

    /**
     * Crée un tableau de charactère composé de "R","G" et "B", rempli ensuite le tableau grille avec ces caractères de manière aléatoire.
     */
    public void selectRand() {
        Random random = new Random();
        char[] tabColor = {'R', 'V', 'B'};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                int cleTab = random.nextInt(3);  // Génère un nombre entre 0 et 2
                this.grille[i][j] = tabColor[cleTab];
            }
        }
    }

    /**
     * Permet de lire un fichier texte ligne par ligne et de remplir le tableau grille avec les caractères lus.
     * @param file le fichier choisi qu'on souhaite lire.
     */
    private void lireFichier(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String ligne;
            int ligneGrille = 0;

            while ((ligne = reader.readLine()) != null) {
                char[] ligneTemp = ligne.toCharArray();
                for (int j = 0; j < 15; j++) {
                    if (j < ligneTemp.length) {
                        this.grille[ligneGrille][j] = ligneTemp[j]; // Copier le caractère
                    }
                }
                ligneGrille++;
            }

            for (int i = ligneGrille; i < 10; i++) {
                for (int j = 0; j < 15; j++) {
                    this.grille[i][j] = ' ';
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier");
        }
    }

    /**
     * Renvoie le tableau de la grille.
     * @return le tableaud de la grille.
     */
    public char[][] getGrilleChoix(){
        return grille;
    }
}
