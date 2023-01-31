package Nave;

import javax.swing.ImageIcon;

public class naveEnemigaA extends NaveEnemiga {
	
	public naveEnemigaA() {
		vida=7;
		velocidad=3;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyA.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
}
