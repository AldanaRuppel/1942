package Arma;

import javax.swing.ImageIcon;

import Visitores.Visitor;
import Visitores.VisitorNaveEnemiga;

public class Laser extends Arma {
	public Laser(int x , int y) {
		
			danio=5;
			velocidad=7;
			this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/Laser.gif")));
			this.setBounds(x, y-(int)this.getIcon().getIconHeight(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
			
	}
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	

}
