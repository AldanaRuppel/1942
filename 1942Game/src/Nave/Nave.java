package Nave;

import javax.swing.JLabel;


import Arma.Arma;
import Arma.Proyectil;
import Entidad.Entidad;
import Logica.Nivel;
import Visitores.Visitor;

public abstract class Nave  extends Entidad{
protected int vida;
protected Arma arma;
protected Nivel nivel;
protected int puntajeNave;
protected Visitor visitor;

//Setters y Getters


	public int getVida() {
		return vida;
	}
	public void setVida (int vida) {
		this.vida=vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	public void recibirDanio (int danio) {
		vida-=danio;
	}
	public abstract void atacar ();
	
	public Arma getArma () {
		return arma;
	}
	public void setArma(Proyectil proyectil) {
		this.arma=proyectil;
	}
	public Nivel getNivel() {
		return nivel;
	}
	
	
	public void setPuntajeNave(int puntaje ) {
		this.puntajeNave=puntaje;
	}
	public int obtenerPuntaje () {
		return puntajeNave;
	}
	

}
