import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObjetGrille extends JComponent {
	private int x;
	private int y;
	private MaMatrice matriceRef; 
	private PanelScore scorePanel;

	public ObjetGrille(int y, int x, Color clr, MaMatrice m, PanelScore s){
        super();
        this.x = x;
        this.y = y;
        this.setClr(clr);
        this.matriceRef = m;
        this.scorePanel = s; 

        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int nbVoisin;
                ObjetGrille[][] matrice = matriceRef.getMatr(); 
                ObjetGrille[] voisins = AlgoVoisin.getVoisin(matrice, y, x); // on attrape tous les voisins
                if (voisins[1] != null){
                    for (nbVoisin = 0; voisins[nbVoisin] != null; nbVoisin++) {
                    }
                    for (ObjetGrille obj : voisins){
                        if (obj != null){
                            obj.setVisible(false); // on le cache
                            matrice[obj.getMyY()][obj.getMyX()] = null; // on l'enlève de la matrice 
                        }
                    }
                    scorePanel.setScore(nbVoisin); // ajout du nouveau score
                }
            }
        });
    }


	public void setClr(Color coul){
		this.setBackground(coul);
	}

	public Color getClr(){
		return this.getBackground();
	}

	public int getMyX(){
		return this.x;
	}

	public int getMyY(){
		return this.y;
	}

	

	public boolean equals(ObjetGrille comp){
		if(this.x == comp.getMyX() && this.y == comp.getMyY()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	protected void paintComponent(Graphics pinceau) {
	    Graphics secondPinceau = pinceau.create();
	    if (this.isOpaque()) {
	      secondPinceau.setColor(this.getBackground());
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
			int[] xEmeraude = {0,15,this.getWidth()-15,this.getWidth(),
							  this.getWidth(),this.getWidth()-15,15,0};
			int[] yEmeraude = {15,2,2,15,
							  this.getHeight()-15,this.getHeight(),this.getHeight(),this.getHeight()-15};
		    secondPinceau.fillPolygon(xEmeraude,yEmeraude,8);
		}
	    }
}