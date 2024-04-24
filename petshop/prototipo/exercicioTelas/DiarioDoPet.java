package exercicioTelas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class DiarioDoPet {
	static int i=0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final int a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiarioDoPet window = new DiarioDoPet(a);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiarioDoPet(int a) {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int a) {
		
		i=a;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 113, 88));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 113, 88));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setBounds(10, -20, 296, 166);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon titulo = new ImageIcon(getClass().getResource("/ELEMENTOS/22.png"));
		titulo.setImage(
				titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), 1));
		lblTitulo.setIcon(titulo);
		panel.add(lblTitulo);
		
		final JLabel lblLista = new JLabel("Lista de atividades");
		lblLista.setBounds(27, 157, 203, 100);
		panel.add(lblLista);
		
		final JLabel lblFotos = new JLabel("Fotos");
		lblFotos.setBounds(271, 127, 148, 156);
		
		ImageIcon fotoPet = new ImageIcon(getClass().getResource(Banco.animais.get(i).foto));
		fotoPet.setImage(
				fotoPet.getImage().getScaledInstance(lblFotos.getWidth()-10, lblFotos.getHeight(), 1));
		lblFotos.setIcon(fotoPet); 
		panel.add(lblFotos);
		
		switch(a) {
			case 1:
				lblLista.setText("<html><body>Mordeu inspetor <br> Rosnou pra porta <br> Fez xixi no brinquedo</body></html>");
				break;
			case 2:
				lblLista.setText("<html><body>Lambeu todo mundo <br> Deixou fazer carinho na barriga <br> Dormiu no colo do inspetor</body></html>");
				break;
			case 0:
				lblLista.setText("<html><body>Latiu pra tomada <br> Correu pra todo lado <br> Defendeu a pelúcia do aspirador de pó</body></html>");
				break;
		}
		
		JLabel lblProx = new JLabel("New label");
		lblProx.setBounds(412, 178, 63, 60);
		panel.add(lblProx);
		frame.setBounds(100, 100, 500, 354);
		ImageIcon seta= new ImageIcon(getClass().getResource("/ELEMENTOS/21.png"));
		seta.setImage(
				seta.getImage().getScaledInstance(lblProx.getWidth(), lblProx.getHeight(), 1));
		lblProx.setIcon(seta);
		
		lblProx.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				i++;
				if (i==3) {
					i=0;	
				}
				switch(i) {
				case 1:
					lblLista.setText("<html><body>Mordeu inspetor <br> Rosnou pra porta <br> Fez xixi no brinquedo</body></html>");
					break;
				case 2:
					lblLista.setText("<html><body>Lambeu todo mundo <br> Deixou fazer carinho na barriga <br> Dormiu no colo do inspetor</body></html>");
					break;
				case 0:
					lblLista.setText("<html><body>Latiu pra tomada <br> Correu pra todo lado <br> Defendeu a pelúcia do aspirador de pó</body></html>");
					break;
			}
				ImageIcon fotoPets = new ImageIcon(getClass().getResource(Banco.animais.get(i).foto));
				fotoPets.setImage(
						fotoPets.getImage().getScaledInstance(lblFotos.getWidth()-10, lblFotos.getHeight(), 1));
				lblFotos.setIcon(fotoPets); 
				
			}
		});
		
		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSair.setBounds(422, 258, 52, 46);
		ImageIcon sair = new ImageIcon(getClass().getResource("/ELEMENTOS/10.png"));
		sair.setImage(sair.getImage().getScaledInstance(lblSair.getWidth(), lblSair.getHeight(), 1));
		lblSair.setIcon(sair);
		panel.add(lblSair);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
