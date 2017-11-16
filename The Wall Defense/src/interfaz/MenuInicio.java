package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.BancoRecursos;
import Controladores.Director;
import main.Juego;

/*
 * Clase MenuInicio.
 * Clase encargada de desplegar el menu de inicio.
 */

public class MenuInicio extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Icon menuback;
	protected JLabel menupanel;
	protected Icon newGame[];
	protected Icon help[];
	protected Icon options[];
	protected JButton buttons[];
	protected Juego game;
	protected BancoRecursos bancoRecursos;
	protected JButton opcion1;
	protected JButton opcion2;
	protected JButton close;
	protected boolean onefects;
	protected boolean onmusic;
	protected boolean oyentesCreados;
	protected JLabel musicOn, efectsOn;
	protected JLabel musicOff, efectsOff;

	// Constructor.
	public MenuInicio(Juego game) {

		this.game = game;
		bancoRecursos = Director.getBancoRecursos();
		armarIconos();
		armarBotonera();
		oyentes();

		this.setBounds(235, 0, 243, 420);
		this.setLayout(new BorderLayout());
		menuback = new ImageIcon(this.getClass().getResource("/resources/static/background/menu3.png"));
		menupanel = new JLabel();
		menupanel.setIcon(menuback);
		menupanel.setSize(243, 423);
		this.add(menupanel);

		onefects = true;
		onmusic = true;
		oyentesCreados = false;
	}

	// Metodos locales.
	public void armarIconos() {
		newGame = new Icon[3];
		help = new Icon[3];
		options = new Icon[3];

		for (int i = 0; i < 3; i++) {
			newGame[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/ngbutton" + (i + 1) + ".png"));
			help[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/helpbutton" + (i + 1) + ".png"));
			options[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/optionsbutton" + (i + 1) + ".png"));
		}

	}

	public void armarBotonera() {

		buttons = new JButton[3];

		buttons[0] = new JButton();
		buttons[0].setIcon(newGame[2]);
		buttons[0].setBounds(50, 100, buttons[0].getIcon().getIconWidth(), buttons[0].getIcon().getIconHeight());

		buttons[1] = new JButton();
		buttons[1].setIcon(options[2]);
		buttons[1].setBounds(50, 200, buttons[1].getIcon().getIconWidth(), buttons[1].getIcon().getIconHeight());

		buttons[2] = new JButton();
		buttons[2].setIcon(help[2]);
		buttons[2].setBounds(50, 300, buttons[2].getIcon().getIconWidth(), buttons[2].getIcon().getIconHeight());

		for (int i = 0; i < 3; i++) {
			this.add(buttons[i]);
		}
	}

	public void oyentes() {

		// Oyente boton new game crea GUI
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				game.crearGUI();
			}
		});

		// Oyentes boton new game

		buttons[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[0].setIcon(newGame[2]);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[0].setIcon(newGame[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent evento) {
				buttons[0].setIcon(newGame[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[0].setIcon(newGame[2]);

			}

		});

		// Oyentes boton help

		buttons[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[2].setIcon(help[2]);
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);
				armarAyuda();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[2].setIcon(help[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				buttons[2].setIcon(help[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[2].setIcon(help[2]);

			}

		});

		// Oyentes boton options

		buttons[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[1].setIcon(options[2]);
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);

				opcion1.setVisible(true);
				opcion2.setVisible(true);
				close.setVisible(true);

				armarOyentesSonido();

				armarOpciones();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[1].setIcon(options[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent evento) {
				buttons[1].setIcon(options[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[1].setIcon(options[2]);

			}

		});

		opcion1 = new JButton();
		opcion2 = new JButton();
		close = new JButton();

		opcion1.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
		opcion2.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
		close.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/close.png")));
		musicOn = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/on.png")));
		musicOff = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/off.png")));
		efectsOn = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/on.png")));
		efectsOff = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/off.png")));

		opcion1.setBounds(50, 150, opcion1.getIcon().getIconWidth(), opcion1.getIcon().getIconHeight());
		opcion2.setBounds(50, 250, opcion2.getIcon().getIconWidth(), opcion2.getIcon().getIconHeight());
		close.setBounds(110, 350, close.getIcon().getIconWidth(), close.getIcon().getIconHeight());
		musicOn.setBounds(110, 220, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		musicOff.setBounds(110, 220, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		efectsOn.setBounds(110, 120, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		efectsOff.setBounds(110, 120, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());

		close.setBackground(Color.BLACK);
		close.setBorderPainted(false);
		close.setBorder(new LineBorder(Color.BLACK));
		close.setFocusPainted(false);
		close.setOpaque(false);
		close.setContentAreaFilled(false);

	}

	public void armarOyentesSonido() {
		if (!oyentesCreados) {
			oyentesCreados = true;
			// oyente boton efectos
			opcion1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					if (onefects) {
						bancoRecursos.stopEfectos();
						opcion1.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
						onefects = false;
						System.out.println("1-Efectos habilitados: " + onefects);
						efectsOff.setVisible(true);
						efectsOn.setVisible(false);
					}
					else {
						bancoRecursos.playEfectos();
						opcion1.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
						onefects = true;
						System.out.println("1-Efectos habilitados: " + onefects);

						efectsOff.setVisible(false);
						efectsOn.setVisible(true);
					}

				}

				@Override
				public void mousePressed(MouseEvent e) {
					opcion1.setIcon(new ImageIcon(
							this.getClass().getResource("/resources/static/botones/efectbotonpresed.png")));
					bancoRecursos.playClick();

				}
			});

			// Oyente boton musica
			opcion2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					if (onmusic == true) {
						bancoRecursos.stopMusica();
						opcion2.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
						onmusic = false;
						System.out.println("2-Musica habilitada: " + onmusic);
						musicOff.setVisible(true);
						musicOn.setVisible(false);
					}
					else {
						if (onmusic == false) {
							bancoRecursos.playMusica();
							opcion2.setIcon(new ImageIcon(
									this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
							onmusic = true;
							System.out.println("2-Musica habilitada: " + onmusic);

							musicOff.setVisible(false);
							musicOn.setVisible(true);
						}
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {

					opcion2.setIcon(new ImageIcon(
							this.getClass().getResource("/resources/static/botones/musicbotonpressed.png")));
					bancoRecursos.playClick();

				}
			});

			close.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					opcion1.setVisible(false);
					opcion2.setVisible(false);
					close.setVisible(false);
					musicOn.setVisible(false);
					musicOff.setVisible(false);
					efectsOn.setVisible(false);
					efectsOff.setVisible(false);
					buttons[0].setVisible(true);
					buttons[1].setVisible(true);
					buttons[2].setVisible(true);
					System.out.println("3-Musica habilitada: " + onmusic);
					System.out.println("3-Efector habilitados: " + onefects);
				}

			});
		}
	}

	public void armarOpciones() {

		if (onmusic) {
			musicOn.setVisible(true);
		}
		else {
			musicOff.setVisible(true);
		}

		if (onefects) {
			efectsOn.setVisible(true);
		}
		else {
			efectsOff.setVisible(true);
		}

		menupanel.add(close);
		menupanel.add(opcion1);
		menupanel.add(opcion2);
		menupanel.add(musicOn);
		menupanel.add(efectsOn);
		menupanel.add(musicOff);
		menupanel.add(efectsOff);
	}

	public void armarAyuda() {
		menupanel.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/background/ayuda.png")));
		menupanel.add(close);
		close.setVisible(true);

		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				opcion1.setVisible(false);
				opcion2.setVisible(false);
				close.setVisible(false);
				buttons[0].setVisible(true);
				buttons[1].setVisible(true);
				buttons[2].setVisible(true);
				menupanel.setIcon(menuback);

			}

		});

	}

}