package Visitores;

import Arma.Laser;
import Arma.Proyectil;
import Consumible.PowerUp;
import Jugador.Jugador;
import Logica.Nivel;
import Nave.NaveEnemiga;
import Nave.NaveJugador;

public class VisitorNaveEnemiga extends Visitor {
	protected NaveEnemiga naveEnemiga;
	protected 	Nivel nivel = Nivel.getNivel();

	
	

	public VisitorNaveEnemiga (NaveEnemiga n) {
		naveEnemiga = n;
		
	}

	public void visit(PowerUp powerUp) {
		//La nave enemiga no visita el powerUp
		
	}

	public void visit(Proyectil proyectil) {
		//La nave enemiga no visita el proyectil
	}

	@Override
	public void visit(Laser laser) {
		int danio=laser.getDanio();
		if(naveEnemiga.getVida()> danio) {
			naveEnemiga.recibirDanio(danio);
		}else {
			int puntaje=naveEnemiga.getPuntaje();
			nivel.EliminarNaveEnemiga(naveEnemiga);
			nivel.aumentarScore(puntaje);
			
			}
	}
		
	public void visit(NaveEnemiga nE) {
	
		
	}

	public void visit(NaveJugador nave) {
		nave.aceptar(nave.getVisitor());
	}

}
