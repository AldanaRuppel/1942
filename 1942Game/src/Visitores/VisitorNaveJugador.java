package Visitores;

import Arma.Laser;
import Arma.Proyectil;
import Consumible.PowerUp;
import Logica.Nivel;
import Nave.NaveEnemiga;
import Nave.NaveJugador;

public class VisitorNaveJugador  extends Visitor{
	
	protected NaveJugador nave;
	protected 	Nivel nivel = Nivel.getNivel();

	@Override
	public void visit(PowerUp powerUp) {
		powerUp.consumir();
		nivel.EliminarElemento(powerUp);
		nave.aumentarVelocidad(powerUp.getMultiplicador());
		
	}

	@Override
	
	public void visit(Proyectil proyectil) {
		int danio=proyectil.getDanio();
		if(nave.getVida()>danio) {
			nave.recibirDanio(danio);
		}else {
				nivel.EliminarNaveJugador();
		}
	}
		
		

	@Override
	public void visit(Laser laser) {
		// La nave jugador no visita al laser
		
	}

	@Override
	public void visit(NaveEnemiga nE) {
		nivel.EliminarNaveEnemiga(nE);
		
	}

	@Override
	public void visit(NaveJugador nave) {
		//La nave jugador no visita a la nave jugador
		
	}

}
