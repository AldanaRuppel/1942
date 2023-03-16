package Hilos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import Logica.Nivel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class HiloMusica implements Runnable {
	
	protected String musica;
	protected long milisegundos;
	protected Nivel nivel = Nivel.getNivel();
	
	public HiloMusica() {
		musica = "Recursos/audioMusica.mp3";
		milisegundos = 0;
	}

	@Override
	public void run() {
		
			while (!nivel.getTerminar()){
				milisegundos ++;
				if (milisegundos % 88000== 0) {
					try {
						File archivo = new File(getClass().getClassLoader().getResource(musica).toURI());
						FileInputStream fis = new FileInputStream(archivo);
					    Player playMP3 = new Player(fis);
					    playMP3.play();
					} catch (JavaLayerException | URISyntaxException | FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}

}
	





