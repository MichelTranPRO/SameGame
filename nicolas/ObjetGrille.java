import java.awt.*;
import javax.swing.*;

public class ObjetGrille extends JComponent{
	private int x;
	private int y;
	private boolean survole;
	private boolean myEtat;

	public ObjetGrille(int y,int x,Color clr){
		super();
		this.x=x;
		this.y=y;
		this.survole=false;
		this.myEtat=true;
		this.setClr(clr);
	}

	public void setClr(Color coul){
		this.setBackground(coul);
	}

	public void setSurvole(boolean bool){
		this.survole=bool;
	}

	public void setEtat(boolean bool){
		this.myEtat=bool;
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

	public boolean getMyEtat(){
		return this.myEtat;
	}

	public boolean equals(ObjetGrille comp){
		if(this.x == comp.getMyX() && this.y == comp.getMyY()){
			if(this.getClr()==comp.getClr()){
				return true;
			}
		}
		return false;
	}

	@Override
	protected void paintComponent(Graphics pinceau) {
	    Graphics secondPinceau = pinceau.create();
	    if (this.isOpaque()) {
	      secondPinceau.setColor(this.getBackground());
	      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
	    }

	    if(this.survole){
	    	secondPinceau.setColor(Color.YELLOW);
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
			int[] xEmeraude = {2,17,this.getWidth()-17,this.getWidth()-2,
							  this.getWidth()-2,this.getWidth()-17,17,2};
			int[] yEmeraude = {17,2,2,17,
							  this.getHeight()-17,this.getHeight()-2,this.getHeight()-2,this.getHeight()-17};
		    secondPinceau.fillPolygon(xEmeraude,yEmeraude,8);
		}
	    }
}