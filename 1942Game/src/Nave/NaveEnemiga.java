package Nave;

import Arma.Arma;

import Arma.Laser;
import Arma.Proyectil;
import GUI.autoRemove;
import Logica.Nivel;
import Visitores.Visitor;


public  abstract class NaveEnemiga  extends Nave{
	
	Nivel nivel = Nivel.getNivel();
	protected int tiempoAtaque;
	

@Override
	public void atacar() {
		arma = generarAtaque();
		nivel.setArma(arma);
		arma.setVisible(true);
	}

	protected abstract Proyectil generarAtaque();
	
	public int getTiempoAtaque() {return tiempoAtaque;}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public Visitor getVisitor() {
		return visitor;
	}


}
