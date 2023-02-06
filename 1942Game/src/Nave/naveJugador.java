package Nave;

import javax.swing.ImageIcon;


import Arma.Laser;
import GUI.GamePlay;
import GUI.autoRemove;
import Logica.Nivel;
import Visitores.Visitor;


public class NaveJugador extends Nave {
	
	public Nivel nivel = Nivel.getNivel();
	protected Visitor visitor;

	
	public NaveJugador () {
		vida=3;
		velocidad=4;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/plane.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	
		
	}
	
	@Override
	public void atacar() {	
			arma = new Laser((int)this.getBounds().getCenterX(), (int) this.getBounds().getCenterY());
			nivel.agregarLabel(arma);
			arma.setVisible(true);
			autoRemove a= new autoRemove(arma);
			a.start();
			//Colisiones();
		}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	public void aumentarVelocidad(int mult) {
		velocidad=velocidad*mult;
	}

	public Visitor getVisitor() {
		return visitor;
	}

}

