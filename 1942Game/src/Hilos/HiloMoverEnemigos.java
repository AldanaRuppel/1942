package Hilos;


import Logica.Nivel;

public class HiloMoverEnemigos implements Runnable {
	
      protected Nivel nivel = Nivel.getNivel();
      protected boolean terminar;
      protected int tiempo;
	
	 
	  public HiloMoverEnemigos () {
		  terminar=nivel.getTerminar();
		  tiempo=0;
	  }

	@Override
	public void run() {
		
		while (!nivel.getTerminar()) {
			tiempo++;
			nivel.moverEnemigos();
			nivel.atacar(tiempo);
			if(!terminar)
				nivel.moverProyectil();
				nivel.ColisionNaveJugador();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
	}
}
