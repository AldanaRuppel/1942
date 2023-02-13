package Nave;

import javax.swing.ImageIcon;

public class Boss  extends Nave{
	
	public Boss () {
		vida=10;
		velocidad=6;
		this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/boss.png")));
		this.setBounds(486, 548,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(int i) {
		// TODO Auto-generated method stub
		
	}
}


