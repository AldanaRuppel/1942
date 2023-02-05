package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Proyectil;
import Arma.Proyectil2;

public class NaveEnemigaC  extends NaveEnemiga{

	public NaveEnemigaC() {
		vida=6;
		velocidad=4;
		tiempoAtaque = (int)(Math.random()*(40-5+1)+30);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyC.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	protected Proyectil generarAtaque() {
		return new Proyectil2((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
	}
	}
