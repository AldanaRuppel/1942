package Logica;

import java.awt.Component;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.text.Position;


import Arma.Arma;
import Arma.Laser;
import Arma.Proyectil;
import Consumible.PowerUp;
import GUI.GamePlay;
import GUI.autoRemove;
import Hilos.HiloEnemigos;
import Hilos.HiloMoverEnemigos;
import Hilos.HiloMusica;
import Jugador.Jugador;
import Nave.Nave;
import Nave.NaveEnemiga;
import Nave.NaveEnemigaA;
import Nave.NaveEnemigaB;
import Nave.NaveEnemigaC;
import Nave.NaveJugador;
import Visitores.Visitor;
import Visitores.VisitorNaveEnemiga;
import Visitores.VisitorNaveJugador;

public class Nivel {
	protected boolean terminarJuego;
	protected LinkedList<LinkedList<NaveEnemiga>>conjuntoEnemigo;
	protected Thread hilomusica;
	protected Thread hiloEnemigos;
	protected Thread hiloMoverEnemigos;
	protected NaveJugador nave;
	protected Jugador jugador;
	public GamePlay juego;
	protected LinkedList<NaveEnemiga> navesPantalla;
	protected LinkedList<Proyectil> proyectiles;
	protected PowerUp power;
	protected  NaveEnemiga naveE;
	protected Visitor visitor1;
	protected Laser laser;
	private static Nivel nivel = new Nivel();
	
	public  Nivel () {
	terminarJuego=false;
        
	}
	public boolean getTerminar () {
		
		return terminarJuego;
	}
	public static Nivel getNivel() {
		return nivel;
	}
	
	public void perder () {
		if(jugador.getVida()==0) 
			juego.perder();
			this.terminarJuego();
			
			
		}
	public boolean ganar() {
		boolean gano=false;
		if(conjuntoEnemigo.isEmpty()) {
			gano=true;
			juego.ganar();
			terminarJuego();
		}
		return gano;
	}
	public void terminarJuego() {
		hiloEnemigos.stop();
		hiloMoverEnemigos.stop();
		hilomusica.stop();
		terminarJuego=true;
	
	}
	
	public void consumirVidaNave() {
		nave.consumirVida();
		jugador.consumirVidaJugador();
	}
	public void consumirVidaEnemiga() {
		naveE.consumirVida();
		
	}
	public LinkedList<NaveEnemiga> getNavesPantalla() {
		return (LinkedList<NaveEnemiga>) navesPantalla.clone();
	}
	

	public LinkedList<LinkedList<NaveEnemiga>> getEnemigos() {
		return (LinkedList<LinkedList<NaveEnemiga>>) conjuntoEnemigo.clone();
	}
	public void setNavesEnemigas (NaveEnemiga nave) {
		navesPantalla.addFirst(nave);
		juego.agregarAlPanel(navesPantalla.getFirst());
	}

	public void setJuego (GamePlay juego) {
		this.juego=juego;
	}
	
	public void moverNave(int i) {
		nave.mover(i);
		
	}
	public void atacarNave() {
		nave.atacar();
	}
	public void setNaveEnemiga (NaveEnemiga naveE) {
		navesPantalla.add(naveE);
		juego.agregarAlPanel(naveE);
		
	}
	public void setArma(Arma arma) {
		proyectiles.add((Proyectil) arma);
		juego.agregarAlPanel(arma);
	}
	public void setPowerUp (PowerUp powerup) {
		juego.agregarAlPanel(powerup);
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
		conjuntoEnemigo = new LinkedList<LinkedList<NaveEnemiga>>();
		navesPantalla = new LinkedList<NaveEnemiga>();
		proyectiles= new LinkedList<Proyectil>();
		nave = new NaveJugador();
		power= new PowerUp();
		jugador = new Jugador ();
	     LinkedList<NaveEnemiga> enemigos;enemigos= new LinkedList<NaveEnemiga>();
		NaveEnemigaA naveA= new NaveEnemigaA();
		enemigos.add(naveA);
		naveA= new NaveEnemigaA();
		enemigos.add(naveA);
		naveA= new NaveEnemigaA();
		enemigos.add(naveA);
		conjuntoEnemigo.add(enemigos);
		LinkedList<NaveEnemiga> enemigos2= new LinkedList<NaveEnemiga>();
		NaveEnemigaB naveB= new NaveEnemigaB();
		enemigos2.add(naveB);
		naveB= new NaveEnemigaB();
		enemigos2.add(naveB);
		naveB= new NaveEnemigaB();
		enemigos2.add(naveB);
		conjuntoEnemigo.add(enemigos2);
		LinkedList<NaveEnemiga> enemigos3= new LinkedList<NaveEnemiga>();
		NaveEnemigaC naveC= new NaveEnemigaC();
		enemigos3.add(naveC);
		naveC= new NaveEnemigaC();
		conjuntoEnemigo.add(enemigos3);
		
		//Crear otras listas con el mismo procedimiento
		
		//Llenando la lista de proyectiles
		 nivel.setPowerUp(power);
		 
		
		//Hilos
		 

		  HiloMusica musica = new HiloMusica();
		  hilomusica = new Thread (musica);
		  hilomusica.start();
	      
		  HiloEnemigos hiloE;
	      hiloE = new HiloEnemigos();
	      hiloEnemigos = new Thread(hiloE);
	      hiloEnemigos.start();
	      
	      HiloMoverEnemigos hiloME;
	      hiloME = new HiloMoverEnemigos();
	      hiloMoverEnemigos = new Thread(hiloME);
	      hiloMoverEnemigos.start();
	      
}
	public void moverEnemigos() {
		
		for (Nave n: (LinkedList<NaveEnemiga>)navesPantalla.clone()) {
			int i = (int)(Math.random()*(4-2+1)+2);
			n.mover(i);
			n.repaint();
			juego.actualizar();
		}
	}
	
	public void atacar(int t) {
		for (NaveEnemiga n: (LinkedList<NaveEnemiga>)navesPantalla.clone()) {
			if (t%n.getTiempoAtaque()==0)
				n.atacar();
		}
	}
	
	public void moverProyectil () {
		for (Proyectil p: (LinkedList<Proyectil>)proyectiles.clone()) {
			p.moverArmamento();

			p.repaint();
			juego.actualizar();
		}
	}
	public void quitarArma(Proyectil arma) {
		proyectiles.remove(arma);
		juego.quitarDelPanel(arma);
	}
	public void EliminarElemento(JLabel l) {
		juego.quitarDelPanel(l);
	}
	public void EliminarNaveJugador() {
		juego.quitarDelPanel(nave);
		jugador.consumirVidaJugador();
		juego.actualizarVida();
		if (jugador.getVida() > 0) {
			nave = new NaveJugador();
			juego.agregarAlPanel(nave);
		}
		else
			perder();
		
	}
	
	public void EliminarNaveEnemiga (NaveEnemiga nE) {
		conjuntoEnemigo.remove(nE);
		navesPantalla.remove(nE);
		juego.quitarDelPanel(nE);
	}
	
	public void ColisionNaveJugador() {
		  if (nave.getBounds().intersects(power.getBounds())) {
			  power.aceppt(nave.getVisitor());
		  }
		
		LinkedList<Proyectil> copiaProyectil = (LinkedList<Proyectil>) proyectiles.clone();
		   
		    for (Proyectil proyectil : copiaProyectil) {
		        if (nave.getBounds().intersects(proyectil.getBounds())) {
		          proyectil.aceppt(nave.getVisitor());
		        }
		    }
		    for (NaveEnemiga n :  (LinkedList<NaveEnemiga>) navesPantalla.clone()){
		        	if (nave.getBounds().intersects(n.getBounds())) {
		        		n.aceppt(nave.getVisitor());
		        	}
		
		    }
		    if(conjuntoEnemigo.isEmpty()) {
		    	juego.ganar();
		    	terminarJuego();
		    }
		    
	}
	public void aumentarScore(int puntaje) {
		jugador.aumentarPuntaje(puntaje);
		juego.actualizarPuntaje(jugador.getPuntaje());
	}
	public Jugador obtenerJugador () {
		return jugador;
	}
	public void actualizarVidaJugador() {
		juego.actualizarVida();
	}
}


	