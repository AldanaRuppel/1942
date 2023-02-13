package Arma;

import Logica.Nivel;
import Visitores.Visitor;

public abstract class Proyectil extends Arma {
	Nivel nivel = Nivel.getNivel();
	protected Visitor visitor;
	

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public  void moverArmamento() {}
	
	protected void MoverDerecha(){
		int x=this.getX()+velocidad;
			if(x<=500)
				this.setBounds(x,this.getY(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}	
	
	protected void MoverIzquierda(){
		int x= this.getX()-velocidad;
			if(x>=10)
				this.setBounds(x,this.getY(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}
	
	protected void MoverArriba(){
		int y=this.getY()-velocidad;
			if(y>300)
				this.setBounds(this.getX(), y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}	
	
	protected void MoverAbajo(){
		int y=this.getY()+velocidad;
			if(y<=600)
				this.setBounds(this.getX(), y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			else
					nivel.quitarArma(this);
				
					
	}

	public void aceppt(Visitor visitor) {
		visitor.visit(this);
	}
	
}


