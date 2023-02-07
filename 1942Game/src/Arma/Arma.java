package Arma;

import javax.swing.JLabel;

import Entidad.Entidad;
import GUI.autoRemove;
import Logica.Nivel;
import Visitores.Visitor;

public abstract class Arma extends Entidad {

	protected int danio;
	
	public JLabel getArma() {return this;}

	public int getVelocidad() {
		return velocidad;
	}
	

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	public int getDanio() {
		return danio;
	}

}




