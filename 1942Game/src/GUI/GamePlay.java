 package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Logica.Nivel;
import Logica.Teclado;
import Nave.Nave;
import Nave.NaveEnemiga;


import java.awt.Color;


public class GamePlay extends JFrame {

	private JPanel contentPane;
	protected Nivel nivel = Nivel.getNivel();
	public ImagenPanel jPanelNivel;
	private JLabel jLabelPuntaje;
	protected JPanel jPanelFondo;
	protected JLabel jLabelPerdi;
	private JLabel jLabelCorazon;
	protected JLabel jLabelPuntos;
	protected JPanel PanelPuntos;
	protected Teclado menteTeclado;
	protected Thread hilo;
	protected Teclado teclado;
	protected GameOver gameO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(4000);
		splash.showSplash();
		SwingUtilities.invokeLater(new Runnable() 
		//EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					GamePlay frame = new GamePlay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GamePlay() {
			super();
			initGUI();
			initGame();
		}	
	
	private void initGUI() {
		try {
			this.setLocationByPlatform(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(173,216,230));
			this.setResizable(false);

			ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("Recursos/Fondo2.png"));
			jPanelNivel = new ImagenPanel(img.getImage());
			getContentPane().add(jPanelNivel, BorderLayout.CENTER);
			jPanelNivel.setLayout(null);
			jPanelNivel.setOpaque(false);
			jPanelNivel.setBackground(new java.awt.Color(131,186,204));
			jPanelNivel.setVisible(true);
			
			contentPane = new JPanel();
			getContentPane().add(contentPane, BorderLayout.CENTER);
			contentPane.setLayout(null);
			contentPane.setOpaque(false);
			contentPane.setBackground(new java.awt.Color(131,186,204));
			contentPane.setVisible(true);
			
			{
			
			
			
			{
				PanelPuntos = new JPanel();
				jPanelNivel.add(PanelPuntos);
				PanelPuntos.setBounds(-1, 0, 940, 38);
				PanelPuntos.setLayout(null);
				PanelPuntos.setBackground(new Color(102, 204, 255));
				{
					jLabelPuntos = new JLabel();
					PanelPuntos.add(jLabelPuntos);
					jLabelPuntos.setText("0000");
					jLabelPuntos.setBounds(115, -2, 55, 39);
					jLabelPuntos.setFont(new java.awt.Font("Segoe UI",1,20));
					jLabelPuntos.setForeground(new java.awt.Color(255,0,0));
					jLabelPuntos.setBackground(new java.awt.Color(255,255,125));
				}
				{
					jLabelCorazon = new JLabel();
					PanelPuntos.add(jLabelCorazon);
					jLabelCorazon.setIcon(new ImageIcon(getClass().getClassLoader().getResource(("Recursos/Corazon.png"))));
					jLabelCorazon.setBounds(403, -1, 118, 38);
					
				}
				
				{
					jLabelPuntaje = new JLabel();
					jLabelPuntaje.setBounds(10, -4, 178, 44);
					PanelPuntos.add(jLabelPuntaje);
					jLabelPuntaje.setText("Score:");
					jLabelPuntaje.setFont(new java.awt.Font("Segoe UI",1,20));
					jLabelPuntaje.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/monedita.gif")));
					jLabelPuntaje.setForeground(new java.awt.Color(255,0,0));
				}
			}
			{
				jLabelPerdi = new JLabel();
				jLabelPerdi.setText("Game Over");
				jLabelPerdi.setBounds(145, 307, 286, 75);
				jLabelPerdi.setFont(new java.awt.Font("Britannic Bold",1,36));
				jLabelPerdi.setBackground(new java.awt.Color(255,0,0));
				jLabelPerdi.setForeground(new java.awt.Color(255,0,0));
				jLabelPerdi.setVisible(false);
				jLabelPerdi.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/gameover (2).gif")));
			}
			{

			}

			pack();
			this.setSize(600, 700);
			}
		}
		catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public float getAncho() {
		return this.getWidth();
	}
	
	public float getAlto() {
		return this.getHeight();
	}
	
	private void initGame() {	
		
		teclado = new Teclado();
		this.addKeyListener(teclado);
		nivel.iniciarJuego(this);		//nivel.moverNave(2);
		jPanelNivel.add(nivel.getNave());
	
		
	}
	
	public void agregarAlPanel (JLabel l) {
		jPanelNivel.add(l);
		this.repaint();
	}
	
	public void quitarDelPanel (JLabel l) {
		jPanelNivel.remove(l);
		this.repaint();
	}
	
	public void actualizar() {this.repaint();}
	
	public JLabel mostrarGameOver() {
		return jLabelPerdi;
	}

	public void perder() {
		jPanelNivel.add(jLabelPerdi);
		jLabelPerdi.setVisible(true);
		/*
		jPanelNivel.setVisible(false);
		jPanelNivel.remove(this);
		
		gameO.add(jLabelPerdi);
		gameO.setVisible(true);
		jLabelPerdi.setVisible(true);
		/*
		System.out.println("PERDISTE QUE TRISTE NO HAY NADIE PEOR QUE VOS");
		this.remove(jPanelNivel);
		JPanel gameOver = new JPanel();
		jPanelNivel.repaint();
		this.add(gameOver);
		this.repaint();
		jPanelNivel.add(jLabelPerdi);
		jLabelPerdi.setVisible(true);
		jPanelNivel.repaint();
		*/
		//this.add(gameOver);
		//this.repaint();
	}
 
		
 }



