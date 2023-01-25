package Arma;

import Visitores.Visitor;

public class Proyectil extends Arma {
	
public Proyectil () {
	danio=3;
	velocidad=2;
}

@Override
public void mover() {
	// TODO Auto-generated method stub
	
}
public void aceptar(Visitor visitor) {
	visitor.visit(this);
}
}
