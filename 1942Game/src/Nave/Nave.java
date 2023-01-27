package Nave;

import javax.swing.JLabel;

import Arma.Arma;
import Logica.Nivel;

public abstract class Nave  extends JLabel{
protected int vida;
protected int velocidad;
protected Arma arma;
protected Nivel nivel;

//Setters y Getters

public int getVida() {
	return vida;
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
public abstract void mover();

}
