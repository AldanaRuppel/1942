package Logica;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.text.Position;


import Arma.Arma;
import Arma.Proyectil;
import Consumible.PowerUp;
import GUI.GamePlay;
import Hilos.HiloEnemigos;
import Hilos.HiloMoverEnemigos;
import Hilos.HiloMusica;
import Jugador.Jugador;
import Nave.Boss;
import Nave.Nave;
import Nave.NaveEnemiga;
import Nave.NaveEnemigaA;
import Nave.NaveEnemigaB;
import Nave.NaveJugador;
import Plantas.Planta;
import Zombies.Zombie;



public class Nivel {
	protected boolean terminarJuego;
	protected LinkedList<LinkedList<NaveEnemiga>>conjuntoEnemigo;
	protected Thread hilomusica;
	protected Thread hiloEnemigos;
	protected Thread hiloMoverEnemigos;
	protected NaveJugador nave;
	protected Jugador jugador;
	public GamePlay juego;
	protected Boss boss;
	protected LinkedList<NaveEnemiga> navesPantalla;
	protected LinkedList<Proyectil> proyectiles;
	protected PowerUp power;
	
	private static Nivel nivel = new Nivel();
	
	public  Nivel () {
		
        
	}
	public boolean getTerminar () {
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
	public void consumirVidaNave() {
	 int vidaConsumida=jugador.getVida();
		if (nave.getVida()==0)
			vidaConsumida--;
	}


	public LinkedList<LinkedList<NaveEnemiga>> getEnemigos() {
		return (LinkedList<LinkedList<NaveEnemiga>>) conjuntoEnemigo.clone();
	}
	public void setNavesEnemigas (NaveEnemiga nave) {
		navesPantalla.addFirst(nave);
		juego.agregarAlPanel(navesPantalla.getFirst());
	}
	/*
	public void quitarNave() {
		boolean encontre=false;
		Position<NaveEnemiga> primero= conjuntoEnemigo.getFirst();
			while(!conjuntoEnemigo.isEmpty() && !encontre) {
					if(primero.getVida()==0) {
						juego.quitarNave();
						conjuntoEnemigo.remove(primero);
						encontre=true;
					}
				primero =(primero==conjuntoEnemigo.getLast())?null:conjuntoEnemigo.next(primero);
			}
	}
	*/
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
		 power= new PowerUp(100);
		LinkedList<NaveEnemiga> enemigos= new LinkedList<NaveEnemiga>();
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
	      

	      
	//Lista de enemigos
	

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
			p.moverArmamento(2);
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
		consumirVidaNave();
		juego.quitarDelPanel( nave);
		hiloEnemigos.stop();
		hiloMoverEnemigos.stop();
		juego.mostrarGameOver();
	}
	public void EliminarNaveEnemiga (NaveEnemiga nE) {
		conjuntoEnemigo.remove(nE);
		navesPantalla.remove(nE);
		EliminarElemento(nE);
		
	}
	public void ColisionNaveJugador() {
		LinkedList<LinkedList<NaveEnemiga>> copiaEnemigos = (LinkedList<LinkedList<NaveEnemiga>>) conjuntoEnemigo.clone();
	    LinkedList<Proyectil> copiaProyectil = (LinkedList<Proyectil>) proyectiles.clone();
	    for (LinkedList<NaveEnemiga> naves : copiaEnemigos) {
	      boolean colision = false;
	      
	      for (Proyectil proyectil : copiaProyectil) {
	        if (naves.getBounds().intersects(proyectil.getBounds())) {
	          proyectil.aceppt(naves.getVisitor());
	        }
	      }
	   
	        }
	      }
	    }
	  } 
		
	
	public void ColisionEnemigos () {
		
	}

	}


	