package Nave;

import javax.swing.ImageIcon;

public class naveEnemigaC  extends NaveEnemiga{

	public naveEnemigaC() {
		vida=6;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyC.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	}
