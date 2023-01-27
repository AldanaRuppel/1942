package Logica;

import java.util.LinkedList;

import Jugador.Jugador;
import Nave.Nave;
import Nave.NaveEnemiga;

public class Nivel {
	protected boolean terminarJuego;
	protected LinkedList<NaveEnemiga>enemigos;
	protected Thread hiloGeneral;
	protected Thread hiloMusica;
	protected Nave nave;
	protected Jugador jugador;
	protected GamePlay game;
	
	private static Nivel nivel = new Nivel();
	
	private Nivel () {
		terminarJuego=false;
		enemigos= new LinkedList<NaveEnemiga>();
	}
	

}
