package Nave;

import javax.swing.JLabel;

import Arma.Arma;
import Logica.Nivel;

public abstract class Nave  extends JLabel{
protected int vida;
protected int velocidad;
protected Arma arma;
protected Nivel nivel;
protected int puntajeNave;

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
	public void setArma(Arma arma) {
		this.arma=arma;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public abstract void mover(int i);
	
	public void setPuntajeNave(int puntaje ) {
		this.puntajeNave=puntaje;
	}
	public int obtenerPuntaje () {
		return puntajeNave;
	}
}
