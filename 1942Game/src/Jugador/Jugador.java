package Jugador;

public class Jugador {
	protected int puntaje;
	protected int vida;
	
	public Jugador () {
		puntaje=0;
		vida=3;
	}
	public int getPuntaje () {
		return puntaje;
	}
	public void setPuntaje (int puntaje) {
		this.puntaje=puntaje;
	}
	public int getVida () {
		return  vida;
	}
	public void setVida(int vida) {
		this.vida=vida;
	}
	public void consumirVidaJugador() {
		vida--;
	}
	public void aumentarPuntaje() {
		puntaje++;
	}
}
