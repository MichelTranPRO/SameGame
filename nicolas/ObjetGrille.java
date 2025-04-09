import java.awt.*;
import javax.swing.*;

public class ObjetGrille extends JComponent{
	private int x;
	private int y;

	public ObjetGrille(int x,int y,Color clr){
		super();
		this.x=x;
		this.y=y;
		this.setClr(clr);
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
	    secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	    }
}