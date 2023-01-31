package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Laser;
import GUI.GamePlay;
import GUI.autoRemove;
import Logica.Nivel;


public class NaveJugador extends Nave {
	
	public Nivel nivel = Nivel.getNivel();
	
	public NaveJugador () {
		vida=3;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/plane.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
	}
	
	@Override
	public void atacar() {	
			arma = new Laser((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
			nivel.agregarLabel(arma);
			arma.setVisible(true);
			autoRemove a= new autoRemove(arma, nivel.juego.jPanelNivel);
			a.start();
			//Colisiones();
		}
	
	public void mover(int i ) {
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
			if(x<500)
				this.setLocation(x, this.getY());
			
		}
		
		private void MoverIzquierda(){
			int x= this.getX()-velocidad;
			if(x>10)
				this.setLocation(x, this.getY());
			
	
		}
		
		private void MoverArriba(){
			int y=this.getY()-velocidad;
			if(y>300)
				this.setLocation(this.getX(), y);
			
	
		}
		
		private void MoverAbajo(){
			int y=this.getY()+velocidad;
			if(y<600)
				this.setLocation(this.getX(), y);
	
		}


	

}

