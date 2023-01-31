package Nave;

import javax.swing.ImageIcon;

public class naveEnemigaB  extends NaveEnemiga{
	
	public naveEnemigaB() {
		vida=5;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyB.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}


}
