package Nave;

import javax.swing.ImageIcon;


import Arma.Laser;
import GUI.GamePlay;
import GUI.autoRemove;
import Logica.Nivel;
import Visitores.Visitor;
import Visitores.VisitorNaveJugador;


public class NaveJugador extends Nave {
	
	public Nivel nivel = Nivel.getNivel();
	protected Visitor miVisitor;

	
	public NaveJugador () {
		vida=10;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/plane.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		miVisitor = new VisitorNaveJugador(this); 
	}
	
	@Override
	public void atacar() {	
			arma = new Laser((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
			nivel.agregarLabel(arma);
			arma.setVisible(true);
			autoRemove a= new autoRemove(arma);
			a.start();
				for(NaveEnemiga n :nivel.getNavesPantalla()) {
					if (n.getBounds().intersects(arma.getBounds())) {
						Laser laser = (Laser)arma;
						laser.aceptar(n.getVisitor());
					}
				}
	}
			
		
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	
	public Visitor getVisitor() {
		return miVisitor;
	}

	
}

