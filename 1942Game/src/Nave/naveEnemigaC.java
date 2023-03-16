package Nave;

import javax.swing.ImageIcon;

import Arma.Arma;
import Arma.Proyectil;
import Arma.Proyectil2;
import Arma.Proyectil3;
import Visitores.VisitorNaveEnemiga;
import Visitores.VisitorNaveJugador;

public class NaveEnemigaC  extends NaveEnemiga{

	public NaveEnemigaC() {
		vida=6;
		velocidad=1;
		puntaje=200;
		tiempoAtaque = (int)(Math.random()*(60-5+1)+80);
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/jet.png")));
		int x = (int)(Math.random()*(500-50+1)+50);
		this.setBounds(x, 50,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		visitor= new VisitorNaveEnemiga(this);
	}
	

	protected Proyectil generarAtaque() {
		return new Proyectil3((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
	}
}
