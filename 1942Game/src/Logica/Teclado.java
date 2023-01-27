package Logica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Nave.naveJugador;


public class Teclado {
	public class MenteTeclado implements KeyListener {
		protected naveJugador miNave;
		
		public MenteTeclado(naveJugador naveJugador){
			this.miNave = naveJugador;
		}
		
		public void keyPressed(KeyEvent evt) {
			
			switch(evt.getKeyCode()) {
				case KeyEvent.VK_UP: {
					miNave.moverNave(1);

					break;
				}
				case KeyEvent.VK_DOWN: {
					miNave.moverNave(2);

					break;
				}
				case KeyEvent.VK_LEFT: {
					miNave.moverNave(3);

					break;
				}
				case KeyEvent.VK_RIGHT: {
					miNave.moverNave(4);

					break;
				}
				case KeyEvent.VK_X: {
					miNave.atacar();
					break;
				}	

			}
			//juego.repaint();
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

}
