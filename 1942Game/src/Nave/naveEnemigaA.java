package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Proyectil;
import Arma.Proyectil2;
import Visitores.VisitorNaveEnemiga;
import Visitores.VisitorNaveJugador;

public class NaveEnemigaA extends NaveEnemiga {
	
	public NaveEnemigaA() {
		vida=7;
		velocidad=1;
		puntaje=50;
		tiempoAtaque = (int)(Math.random()*(60-5+1)+80);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/enemyA.png")));
		int x = (int)(Math.random()*(500-50+1)+50);
		this.setBounds(x, 50,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		visitor = new VisitorNaveEnemiga(this);
		
		
	}

	protected Proyectil generarAtaque() {
		return new Proyectil2((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
		
	}
}
