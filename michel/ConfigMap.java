import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConfigMap {
    private char[][] grille;
    private File fichier = new File("");
    private JFileChooser selectFichier;
    private FileNameExtensionFilter filtre = new FileNameExtensionFilter(" ","txt");

    public ConfigMap() {
        this.fichier = new File("");
        this.grille = new char[10][15];
        this.selectFichier = new JFileChooser();selectFichier.setFileFilter(filtre);
        selectFichier.setCurrentDirectory(new File("./map"));
        
    }

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



    public char[][] getGrilleChoix(){
        return grille;
    }
}
