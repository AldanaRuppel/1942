package Logica;

import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;

import Arma.Arma;
import Arma.Laser;
import GUI.GamePlay;
import Jugador.Jugador;
import Nave.Boss;
import Nave.Nave;
import Nave.NaveEnemiga;
import Nave.NaveJugador;
import Nave.naveEnemigaA;
import Nave.naveEnemigaB;
import Nave.naveEnemigaC;



public class Nivel {
	protected boolean terminarJuego;
	protected LinkedList<NaveEnemiga>enemigos;
	protected Thread hiloGeneral;
	protected Thread hiloMusica;
	protected NaveJugador nave;
	protected Jugador jugador;
	public GamePlay juego;
	protected Boss boss;
	

	
	private static Nivel nivel = new Nivel();
	
	
	
	public  Nivel () {
		
        
	}
	public boolean juegoTerminado () {
		return terminarJuego;
	}
	public static Nivel getNivel() {
		return nivel;
	}
	public void ganar () {
		if(boss.getVida()==0) {
			nivel.ganar();
		}
	}
	public void perder () {
		if(jugador.getVida()==0) 
			nivel.perder();
		}
	public void consumirVida() {
	 int vidaConsumida=jugador.getVida();
		if (nave.getVida()==0)
			vidaConsumida--;
	}
	public void mover () {
		int contX= juego.getWidth()/2-200;
		int contY=-50;
		
			for (int j=0; j<2; j++){
				NaveEnemiga n= new naveEnemigaA();
				agregarNaveEnemiga(n, contX, contY);
				contX+=252;
				contY-=120;
			}
			contX=100;
			contY=-373;
			for (int j=0; j<3; j++){
				NaveEnemiga n= new naveEnemigaB();
				agregarNaveEnemiga(n, contX, contY);
				contX-=184;
				contY-=100;
				NaveEnemiga n2= new naveEnemigaC();
				agregarNaveEnemiga(n2, contX, contY);
				contX+=184*2;
				contY-=57;
				
			}
			

	}
	protected void agregarNaveEnemiga(NaveEnemiga n, int x, int y){
		enemigos.add(n);
		n.setBounds(0, 0,n.getIcon().getIconWidth(), n.getIcon().getIconHeight());
		juego.preparar(n, x, y);
	}
	
	public void setJuego (GamePlay juego) {
		
		this.juego=juego;
	}
	
	public void moverNave(int i) {
		nave.mover(i);
		System.out.print("se mueve");
		
	}
	public void atacarNave() {
		nave.atacar();
	}
	
	public void agregarLabel (JLabel l) {
		
		juego.agregarAlPanel(l);
	}
	
	public JLabel getNave() {
		return nave;
	}
	
	public void iniciarJuego (GamePlay j) {
		juego = j;
		terminarJuego = false;
		enemigos = new LinkedList<NaveEnemiga>();
		nave = new NaveJugador();
		
	}

}

	