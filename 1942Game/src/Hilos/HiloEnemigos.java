package Hilos;

import java.util.LinkedList;

import Logica.Nivel;
import Nave.NaveEnemiga;



public class HiloEnemigos implements Runnable {
	
	  protected LinkedList<LinkedList<NaveEnemiga>> conjuntoEnemigos;
      protected Nivel nivel = Nivel.getNivel();
	  protected int dormir;
	 
	  public HiloEnemigos () {
		  conjuntoEnemigos = nivel.getEnemigos(); //clona el conjunto de enemigos
		  dormir=3000;
	  }

	@Override
	public void run() {
		while (!conjuntoEnemigos.isEmpty()) {
			
		      try {
		        LinkedList<NaveEnemiga> navesEnemigas = conjuntoEnemigos.getFirst();
		        while (!navesEnemigas.isEmpty()) {
		          
		          NaveEnemiga nave = navesEnemigas.remove(); 
		          nivel.setNaveEnemiga(nave);
		          		          
		          Thread.sleep(dormir);
		        }
		        conjuntoEnemigos.remove(conjuntoEnemigos.getFirst());
		        Thread.sleep(20000);
		        
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		  
			}
			
		}
	

}
