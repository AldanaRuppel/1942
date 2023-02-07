package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Proyectil;
import Arma.Proyectil1;
import Visitores.VisitorNaveEnemiga;
import Visitores.VisitorNaveJugador;

public class NaveEnemigaB  extends NaveEnemiga{
	
	public NaveEnemigaB() {
		vida=5;
		velocidad=2;
		puntaje=70;
		tiempoAtaque = (int)(Math.random()*(40-5+1)+30);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyB.png")));
		int x = (int)(Math.random()*(500-50+1)+50);
		this.setBounds(x, 50,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		visitor= new VisitorNaveEnemiga(this);
	}

	protected Proyectil generarAtaque() {
		return new Proyectil1((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
	}

}
