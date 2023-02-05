package Consumible;

import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.Visitor;

public class PowerUp extends JLabel {
	
	protected int multiplicador;
	protected boolean consumido;

	public PowerUp (int puntaje) {
		multiplicador=puntaje;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/powerUp.png")));
		int x = (int)(Math.random()*(15-495+1)+495);
		int y = (int)(Math.random()*(595-305+1)+305);
		this.setBounds(x, y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		
		
		
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	public boolean getConsumido() {
		return consumido;
	}
	public void consumir() {
		consumido=true;
	}
	public int getMultiplicador() {
		return multiplicador;
	}
}
