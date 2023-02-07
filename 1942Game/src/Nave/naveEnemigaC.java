package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Proyectil;
import Arma.Proyectil2;
import Visitores.VisitorNaveEnemiga;
import Visitores.VisitorNaveJugador;

public class NaveEnemigaC  extends NaveEnemiga{

	public NaveEnemigaC() {
		vida=6;
		velocidad=4;
		puntaje=100;
		tiempoAtaque = (int)(Math.random()*(40-5+1)+30);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyC.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		visitor= new VisitorNaveEnemiga(this);
	}

	protected Proyectil generarAtaque() {
		return new Proyectil2((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
	}
}
