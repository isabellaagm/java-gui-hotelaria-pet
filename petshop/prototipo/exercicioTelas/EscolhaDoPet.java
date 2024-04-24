package exercicioTelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class EscolhaDoPet {

	private JFrame frmEscolhaDoPet;
	private ButtonGroup radioGroup;
	static int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaDoPet window = new EscolhaDoPet();
					window.frmEscolhaDoPet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EscolhaDoPet() {

		Animal lua = new Animal("Lua", "American Bully", "Preto", "Rua das Rosas, 456", "(11)90876-4376", "24/05/2019",
				"Isabella", null, null); // ELEMENTOS/bull.png
		Animal george = new Animal("George", "Golden", "Dourado", "Rua da Feira, 999", "(11)90876-4376", "31/07/2013",
				"Isabella", null, "/ELEMENTOS/golden.png");
		Animal marley = new Animal("Marley", "Lulu da Pomerânia", "Branco", "Av Paulista, 226", "(11)90876-4376",
				"25/11/2016", "Isabella", null, "/ELEMENTOS/lulu.png");

		Banco.animais.add(lua);
		Banco.animais.add(marley);
		Banco.animais.add(george);

		frmEscolhaDoPet = new JFrame();
		frmEscolhaDoPet.setTitle("Escolha do Pet");
		frmEscolhaDoPet.setBounds(100, 100, 500, 354);
		frmEscolhaDoPet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEscolhaDoPet.getContentPane().setLayout(new BoxLayout(frmEscolhaDoPet.getContentPane(), BoxLayout.X_AXIS));

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 142, 184));
		frmEscolhaDoPet.getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton btnPet1 = new JRadioButton(Banco.animais.get(0).nome);
		btnPet1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPet1.setForeground(Color.WHITE);
		btnPet1.setBackground(new Color(38, 142, 184));
		btnPet1.setBounds(18, 76, 109, 23);
		panel.add(btnPet1);

		radioGroup = new ButtonGroup();
		radioGroup.add(btnPet1);

		JRadioButton btnPet2 = new JRadioButton(Banco.animais.get(1).nome);
		if (Banco.animais.get(1) != null) {
			btnPet2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnPet2.setForeground(Color.WHITE);
			btnPet2.setBackground(new Color(38, 142, 184));
			btnPet2.setBounds(18, 113, 109, 23);
			panel.add(btnPet2);

			radioGroup.add(btnPet2);
		}

		JRadioButton btnPet3 = new JRadioButton(Banco.animais.get(2).nome);
		if (Banco.animais.get(2) != null) {
			btnPet3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnPet3.setForeground(Color.WHITE);
			btnPet3.setBackground(new Color(38, 142, 184));
			btnPet3.setBounds(18, 149, 109, 23);
			panel.add(btnPet3);

			radioGroup.add(btnPet3);
		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, -20, 296, 119);
		ImageIcon selecioneOPet = new ImageIcon(getClass().getResource("/ELEMENTOS/SELECIONE O PET (1).png"));
		selecioneOPet.setImage(
				selecioneOPet.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), 1));

		final JLabel lblFotoPet = new JLabel("");
		lblFotoPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoPet.setBounds(253, 83, 176, 160);
		ImageIcon fotoPet = new ImageIcon(getClass().getResource("/ELEMENTOS/11.png"));
		fotoPet.setImage(
				fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() + 60, lblFotoPet.getHeight() + 7, 1));
		lblFotoPet.setIcon(fotoPet);
		panel.add(lblFotoPet);
		lblNewLabel.setIcon(selecioneOPet);
		panel.add(lblNewLabel);

		btnPet1.addItemListener(new java.awt.event.ItemListener() {
			ImageIcon fotoPet = new ImageIcon();

			public void itemStateChanged(java.awt.event.ItemEvent e) {

				if (Banco.animais.get(0).foto != null) {
					fotoPet = new ImageIcon(getClass().getResource(Banco.animais.get(0).foto));
					fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
							lblFotoPet.getHeight(), 1));
				} else {
					lblFotoPet.setIcon(null);
					final JLabel carregaFoto = new JLabel("Upload foto do pet");
					carregaFoto.setHorizontalAlignment(SwingConstants.CENTER);
					carregaFoto.setBounds(253, 83, 176, 160);
					panel.add(carregaFoto);

					carregaFoto.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							File arquivo;
							BufferedImage imagem;
							JFileChooser chooser = new JFileChooser();
							chooser.showOpenDialog(null);
							arquivo = chooser.getSelectedFile();

							fotoPet = new ImageIcon(arquivo.getPath());
							fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
									lblFotoPet.getHeight(), 1));
							lblFotoPet.setIcon(fotoPet);
						}
					});

				}
				lblFotoPet.setIcon(fotoPet);
				a = 0;
			}

		});

		btnPet2.addItemListener(new java.awt.event.ItemListener() {
			ImageIcon fotoPet = new ImageIcon();

			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (Banco.animais.get(1).foto != null) {
					fotoPet = new ImageIcon(getClass().getResource(Banco.animais.get(1).foto));
					fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
							lblFotoPet.getHeight(), 1));
					lblFotoPet.setIcon(fotoPet);
					a = 1;
				} else {
					lblFotoPet.setIcon(null);
					final JLabel carregaFoto = new JLabel("Upload foto do pet");
					carregaFoto.setHorizontalAlignment(SwingConstants.CENTER);
					carregaFoto.setBounds(253, 83, 176, 160);
					panel.add(carregaFoto);

					carregaFoto.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							File arquivo;
							BufferedImage imagem;
							JFileChooser chooser = new JFileChooser();
							chooser.showOpenDialog(null);
							arquivo = chooser.getSelectedFile();

							fotoPet = new ImageIcon(arquivo.getPath());
							fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
									lblFotoPet.getHeight(), 1));
							lblFotoPet.setIcon(fotoPet);
						}
					});

				}
				lblFotoPet.setIcon(fotoPet);
				a = 1;
			}
		});

		btnPet3.addItemListener(new java.awt.event.ItemListener() {
			ImageIcon fotoPet = new ImageIcon();

			public void itemStateChanged(java.awt.event.ItemEvent e) {

				if (Banco.animais.get(2).foto != null) {
					fotoPet = new ImageIcon(getClass().getResource(Banco.animais.get(2).foto));
					fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
							lblFotoPet.getHeight(), 1));
				} else {
					lblFotoPet.setIcon(null);
					final JLabel carregaFoto = new JLabel("Upload foto do pet");
					carregaFoto.setHorizontalAlignment(SwingConstants.CENTER);
					carregaFoto.setBounds(253, 83, 176, 160);
					panel.add(carregaFoto);

					carregaFoto.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							File arquivo;
							BufferedImage imagem;
							JFileChooser chooser = new JFileChooser();
							chooser.showOpenDialog(null);
							arquivo = chooser.getSelectedFile();

							fotoPet = new ImageIcon(arquivo.getPath());
							fotoPet.setImage(fotoPet.getImage().getScaledInstance(lblFotoPet.getWidth() - 10,
									lblFotoPet.getHeight(), 1));
							lblFotoPet.setIcon(fotoPet);
						}
					});

				}
				lblFotoPet.setIcon(fotoPet);
				a = 2;
			}

		});

		JButton btnVisualizar = new JButton("");
		btnVisualizar.setBounds(25, 252, 102, 23);
		ImageIcon imgVisualizar = new ImageIcon(getClass().getResource("/ELEMENTOS/8.png"));
		imgVisualizar.setImage(imgVisualizar.getImage().getScaledInstance(btnVisualizar.getWidth() + 20,
				btnVisualizar.getHeight() + 60, 1));
		btnVisualizar.setBorderPainted(false);
		btnVisualizar.setIcon(imgVisualizar);
		panel.add(btnVisualizar);

		JButton btnCadastrarNovoPet = new JButton("");
		btnCadastrarNovoPet.setBounds(139, 252, 109, 23);
		ImageIcon imgBtnCadastro = new ImageIcon(getClass().getResource("/ELEMENTOS/9.png"));
		imgBtnCadastro.setImage(imgBtnCadastro.getImage().getScaledInstance(btnCadastrarNovoPet.getWidth() + 20,
				btnCadastrarNovoPet.getHeight() + 60, 1));
		btnCadastrarNovoPet.setBorderPainted(false);
		btnCadastrarNovoPet.setIcon(imgBtnCadastro);
		panel.add(btnCadastrarNovoPet);

		if (Banco.animais.size() > 3) {
			// só pode cadastrar três animais
			btnCadastrarNovoPet.setEnabled(false);
		}
		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSair.setBounds(421, 272, 53, 32);
		ImageIcon sair = new ImageIcon(getClass().getResource("/ELEMENTOS/10.png"));
		sair.setImage(sair.getImage().getScaledInstance(lblSair.getWidth(), lblSair.getHeight(), 1));
		lblSair.setIcon(sair);
		panel.add(lblSair);

		btnCadastrarNovoPet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cadastro.main(null);
				frmEscolhaDoPet.dispose();

			}
		});

		btnVisualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DiarioDoPet.main(null, a);
				frmEscolhaDoPet.dispose();

			}
		});

	}
}
