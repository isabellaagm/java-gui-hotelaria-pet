package exercicioTelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class PerfilDoPet {

	private JFrame frame;
	
	static int num;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final int numAnimal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilDoPet window = new PerfilDoPet(numAnimal);
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
	public PerfilDoPet(int numAnimal) {
		initialize(numAnimal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int numAnimal) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(38, 142, 184));
		frame.setBounds(100, 100, 500, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Perfil do Pet");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTitulo.setBounds(37, 11, 271, 48);
		frame.getContentPane().add(lblTitulo);

		JButton btnDiarioPet = new JButton("Diário do Pet");
		btnDiarioPet.setBounds(37, 272, 121, 32);
		ImageIcon imgDiario = new ImageIcon(getClass().getResource("/ELEMENTOS/18.png"));
		imgDiario.setImage(imgDiario.getImage().getScaledInstance(btnDiarioPet.getWidth()+30, btnDiarioPet.getHeight()+110, 1));
		btnDiarioPet.setIcon(imgDiario);
		btnDiarioPet.setBorderPainted(false);
		frame.getContentPane().add(btnDiarioPet);

		Border lineBorder = BorderFactory.createLineBorder(new Color(243,248,250));
		TitledBorder nomePet = BorderFactory.createTitledBorder(lineBorder, "Nome do Pet");
		
		JLabel lblNome = new JLabel("Nome do Pet: ");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(10, 95, 183, 14);
		lblNome.setBorder(lineBorder);
		lblNome.setSize(100, 70);
		frame.getContentPane().add(lblNome);

		JLabel lblRaca = new JLabel("Raça: ");
		lblRaca.setVerticalAlignment(SwingConstants.TOP);
		lblRaca.setForeground(new Color(255, 255, 255));
		lblRaca.setBounds(129, 95, 148, 14);
		lblRaca.setBorder(lineBorder);
		lblRaca.setSize(100,70);
		frame.getContentPane().add(lblRaca);

		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setVerticalAlignment(SwingConstants.TOP);
		lblIdade.setForeground(new Color(255, 255, 255));
		lblIdade.setBounds(10, 176, 131, 14);
		lblIdade.setBorder(lineBorder);
		lblIdade.setSize(100,70);
		frame.getContentPane().add(lblIdade);

		JLabel lblCor = new JLabel("Nota: ");
		lblCor.setVerticalAlignment(SwingConstants.TOP);
		lblCor.setForeground(new Color(255, 255, 255));
		lblCor.setBounds(129, 176, 100, 56);
		lblCor.setBorder(lineBorder);
		lblCor.setSize(100, 70);
		frame.getContentPane().add(lblCor);

		JLabel lblAvaliacao = new JLabel("Nota");
		lblAvaliacao.setBounds(187, 70, 276, 209);
		ImageIcon boletim = new ImageIcon(getClass().getResource("/ELEMENTOS/17.png"));
		boletim.setImage(boletim.getImage().getScaledInstance(lblAvaliacao.getWidth()+70, lblAvaliacao.getHeight()+45, 1));
		lblAvaliacao.setIcon(boletim);
		frame.getContentPane().add(lblAvaliacao);
		
		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSair.setBounds(417, 261, 46, 43);
		ImageIcon sair = new ImageIcon(getClass().getResource("/ELEMENTOS/10.png"));
		sair.setImage(sair.getImage().getScaledInstance(lblSair.getWidth(), lblSair.getHeight(), 1));
		lblSair.setIcon(sair);
		frame.getContentPane().add(lblSair);

		int n = Banco.animais.size();

		if (n != 0) {
			lblNome.setText("<html> <body>"+lblNome.getText() + " <br>  " + Banco.animais.get(numAnimal).nome+" </body> </html>");
			lblRaca.setText("<html> <body>"+lblRaca.getText() + " <br>" + Banco.animais.get(numAnimal).raca+" </body> </html>");
			lblIdade.setText("<html> <body>"+lblIdade.getText() + " <br>" + String.valueOf(Banco.animais.get(numAnimal).idade)+" </body> </html>");
			lblCor.setText("<html> <body>"+lblCor.getText() + "<br> A+ </body> </html>");
		}
		
		btnDiarioPet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DiarioDoPet.main(null, 0);
				frame.dispose();
				
			}
		});
	}
}
