package Arma;

import Logica.Nivel;
import Visitores.Visitor;

public abstract class Proyectil extends Arma {
	Nivel nivel = Nivel.getNivel();
	protected Visitor visitor;
	

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public  void moverArmamento(int i) {
		if (this.getLocation().y >= 590) 
			nivel.quitarArma(this);
		else
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
	}

	public void aceppt(Visitor visitor) {
		visitor.visit(this);
	}
}


