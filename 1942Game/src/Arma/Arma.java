package Arma;

import javax.swing.JLabel;

import Entidad.Entidad;
import GUI.autoRemove;
import Logica.Nivel;
import Visitores.Visitor;

public class Arma extends Entidad {

	Nivel nivel = Nivel.getNivel();
	protected int danio;
	
	public JLabel getArma() {return this;}

	public int getVelocidad() {
		return velocidad;
	}
	

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	/*
	public void mover(int i) {
		super.mover(i);
	}
	*/
	public int getDanio() {
		return danio;
	}
		
	}




