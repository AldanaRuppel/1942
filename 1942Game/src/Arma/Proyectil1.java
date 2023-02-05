package Arma;

import javax.swing.ImageIcon;

public class Proyectil1  extends Proyectil { 
	
 public Proyectil1 (int x , int y) {
	 
		danio=5;
		velocidad=10;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/Bomba1.png")));
		this.setBounds(x, y-(int)this.getIcon().getIconHeight(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		

	}
}
