package Consumible;

import java.awt.Label;

import Visitores.Visitor;

public class PowerUp extends Label {
	protected int multiplicador;

public PowerUp (int puntaje) {
	multiplicador=puntaje;
	
}
public void aceptar(Visitor visitor) {
	visitor.visit(this);
}
}
