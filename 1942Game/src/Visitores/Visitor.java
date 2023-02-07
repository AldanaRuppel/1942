package Visitores;


import Arma.Laser;
import Arma.Proyectil;
import Consumible.PowerUp;
import Entidad.Entidad;
import Nave.NaveEnemiga;
import Nave.NaveJugador;

public abstract class Visitor {

	 public abstract void visit(PowerUp powerUp);
	 public abstract void visit(Proyectil proyectil);
	 public abstract void visit(Laser laser);
	 public abstract void visit (NaveEnemiga nE);
	 public abstract void visit (NaveJugador nave);
	public void setEntidad(Entidad e) {
		
		
	}
}
