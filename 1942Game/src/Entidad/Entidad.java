package Entidad;

import javax.swing.JLabel;

public abstract class Entidad extends JLabel {
	protected int velocidad;
	
	public abstract int  getVelocidad();
	public abstract void atacar();

	public void mover(int i) {
		switch(i) {
			case 1: {
				MoverArriba();
	
				break;
			}
			case 2: {
				MoverAbajo();
				
				break;
			}
			case 3: {
				MoverIzquierda();
	
				break;
			}
			case 4: {
				MoverDerecha();	
	
				break;
			}
		}
		this.repaint();
}
	protected  void MoverDerecha(){
		int x=this.getX()+velocidad;
		if(x<=500)
			this.setBounds(x,this.getY(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			//this.setLocation(x, this.getY());
		
	}
	
	protected  void MoverIzquierda(){
		int x= this.getX()-velocidad;
		if(x>=10)
			this.setBounds(x,this.getY(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			//this.setLocation(x, this.getY());
		

	}
	
	protected void MoverArriba(){
		int y=this.getY()-velocidad;
		if(y>300)
			this.setBounds(this.getX(), y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			//this.setLocation(this.getX(), y);
		

	}
	
	protected void MoverAbajo(){
		int y=this.getY()+velocidad;
		if(y<=600)
			this.setBounds(this.getX(), y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			//this.setLocation(this.getX(), y);

	}

}


