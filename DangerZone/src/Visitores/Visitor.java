package Visitores;

import Arma.Proyectil;
import Consumible.PowerUp;

public abstract class Visitor {

	 public abstract void visit(PowerUp powerUp);
	 public abstract void visit(Proyectil proyectil);

}
