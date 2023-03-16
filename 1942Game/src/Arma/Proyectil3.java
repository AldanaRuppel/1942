package Arma;

import javax.swing.ImageIcon;

	
public class Proyectil3 extends Proyectil {
		
	public Proyectil3 (int x , int y) {
			 
		danio=1;
		velocidad=4;
			
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/bullet3.png")));
		this.setBounds(x, y-(int)this.getIcon().getIconHeight(),this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
			
	}
	public void moverArmamento() {
		MoverAbajo();
			
	}

}



