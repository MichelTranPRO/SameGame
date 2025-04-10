import java.awt.*;
import javax.swing.*;

public class ObjetGrille extends JComponent{
	private int x;
	private int y;

	public ObjetGrille(int y,int x,Color clr){
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