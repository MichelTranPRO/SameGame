import java.awt.*;
import java.lang.*;
import javax.swing.*;

public class ObjetGrille extends JComponent{
	private Color clr;
	private int x;
	private int y;

	public ObjetGrille(int x,int y,Color clr){
		super();
		this.x=x;
		this.y=y;
		this.clr=clr;
	}

	public void setClr(Color coul){
		this.clr=coul;
	}

	public Color getClr(){
		return this.clr;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public boolean equals(ObjetGrille comp){
		if(this.x == comp.getX() && this.y == comp.getY()){
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
	    secondPinceau.setColor(this.clr);
	    secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}