package Nave;

import GUI.autoRemove;
import Logica.Nivel;


public class naveJugador extends Nave {

public naveJugador () {
	vida=3;
	velocidad=4;
	
}

@Override
public void atacar() {	
		int x= this.getX()+(this.getWidth()/2)-12;
		arma.setBounds(x, this.getY()-arma.getIcon().getIconHeight(),arma.getIcon().getIconWidth(), arma.getIcon().getIconHeight());
		nivel.agregarArmaJugador(arma);
		autoRemove a= new autoRemove(arma, nivel.game.jPanelNivel);
		a.start();
		//Colisiones();
	}

public void moverNave(int i ) {
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
}
	
	private void MoverDerecha(){
		int x=this.getX()+velocidad;
		if(x<nivel.juego.getWidth()-(this.getWidth()/2))
			this.setLocation(x, this.getY());
	}
	
	private void MoverIzquierda(){
		int x= this.getX()-velocidad;
		if(x>0-(this.getWidth()/2))
			this.setLocation(x, this.getY());
	}
	
	private void MoverArriba(){
		int y=this.getY()-velocidad;
		if(y>nivel.juego.getHeight()/2))
			this.setLocation(this.getX(), y);
	}
	
	private void MoverAbajo(){
		int y=this.getY()+velocidad;
		if(y<nivel.juego.getHeight()-this.getHeight()-35)
			this.setLocation(this.getX(), y);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}


}

