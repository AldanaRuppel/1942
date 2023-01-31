
package Logica;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.GamePlay;


public class Teclado implements KeyListener {
	
    protected Nivel nivel=Nivel.getNivel();
    protected GamePlay juego;
	
	public Teclado() {
	}
	
	public void keyPressed(KeyEvent evt) {
		
		switch(evt.getKeyCode()) {
			case KeyEvent.VK_UP: {
				nivel.moverNave(1);
				

				break;
			}
			case KeyEvent.VK_DOWN: {
				nivel.moverNave(2);
				

				break;
			}
			case KeyEvent.VK_LEFT: {
				nivel.moverNave(3);
			

				break;
			}
			case KeyEvent.VK_RIGHT: {
				nivel.moverNave(4);
				

				break;
			}
			case KeyEvent.VK_SPACE : {
				nivel.atacarNave();
				
				break;
			}
			
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}