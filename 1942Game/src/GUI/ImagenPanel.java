package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagenPanel  extends JPanel{

	private Image img;
	
	public ImagenPanel(Image img){
		this.img = img;
		Dimension dimension = new Dimension(img.getWidth(null),img.getHeight(null));
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setMaximumSize(dimension);
		this.setSize(dimension);
		this.setLayout(null);
		
	}

	protected void paintComponent(Graphics g){
		g.drawImage(img,0,0,null);
	}
	
}


