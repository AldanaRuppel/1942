package Arma;

import javax.swing.ImageIcon;

import Visitores.Visitor;
import Visitores.VisitorNaveJugador;

public class Proyectil1  extends Proyectil { 
	
	public Proyectil1 (int x , int y) {
		danio=1;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/Bomba1.png")));
		this.setBounds(x, y-(int)this.getIcon().getIconHeight(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
	}

 	public void aceptar(Visitor visitor) {
 		visitor.visit(this);
 	}
 	public void moverArmamento(){
 		MoverAbajo();
 		
 	}
}
