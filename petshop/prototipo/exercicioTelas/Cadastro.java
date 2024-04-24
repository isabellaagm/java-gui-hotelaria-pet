package exercicioTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class Cadastro {

	private JFrame frmCadastro;
	private JTextField textFieldNome;
	private JTextField textFieldRaca;
	private JTextField textFieldCor;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;
	private JLabel lblSair;
	private String foto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 600, 500);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 248, 250));
		frmCadastro.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 29, 89, 14);
		panel.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(115, -33, 363, 136);
		ImageIcon logo = new ImageIcon(getClass().getResource("/ELEMENTOS/LOGO 2.png"));
		logo.setImage(logo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), 1));
		lblLogo.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 18));
		lblLogo.setIcon(logo);
		panel.add(lblLogo);

		Border lineBorder = BorderFactory.createLineBorder(new Color(38, 142, 184));
		TitledBorder nomePet = BorderFactory.createTitledBorder(lineBorder, "Nome do Pet");
		textFieldNome = new JTextField();
		textFieldNome.setBounds(41, 71, 307, 40);
		textFieldNome.setBorder(nomePet);
		textFieldNome.setBackground(null);
		textFieldNome.setSize(300, 40);
		panel.add(textFieldNome);

		TitledBorder racaPet = BorderFactory.createTitledBorder(lineBorder, "Raça");
		textFieldRaca = new JTextField();
		textFieldRaca.setBounds(41, 149, 192, 20);
		textFieldRaca.setBorder(racaPet);
		textFieldRaca.setBackground(null);
		textFieldRaca.setSize(300, 40);
		panel.add(textFieldRaca);

		TitledBorder corPet = BorderFactory.createTitledBorder(lineBorder, "Cor");
		textFieldCor = new JTextField();
		textFieldCor.setBounds(41, 189, 192, 20);
		textFieldCor.setBorder(corPet);
		textFieldCor.setBackground(null);
		textFieldCor.setSize(300, 40);
		panel.add(textFieldCor);

		TitledBorder endereco = BorderFactory.createTitledBorder(lineBorder, "Endereço");
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(41, 229, 192, 20);
		textFieldEndereco.setBorder(endereco);
		textFieldEndereco.setBackground(null);
		textFieldEndereco.setSize(300, 40);
		panel.add(textFieldEndereco);

		MaskFormatter mfTel = null;

		try {
			mfTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TitledBorder telefone = BorderFactory.createTitledBorder(lineBorder, "Telefone");
		final JFormattedTextField textFieldTelefone = new JFormattedTextField(mfTel);
		textFieldTelefone.setBounds(41, 273, 192, 20);
		textFieldTelefone.setBorder(telefone);
		textFieldTelefone.setBackground(null);
		textFieldTelefone.setSize(300, 40);
		panel.add(textFieldTelefone);

		MaskFormatter mfData = null;

		try {
			mfData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TitledBorder dataNasc = BorderFactory.createTitledBorder(lineBorder, "Data de Nascimento");
		final JFormattedTextField textFieldDataNasc = new JFormattedTextField(mfData);
		textFieldDataNasc.setBounds(41, 111, 192, 20);
		textFieldDataNasc.setBorder(dataNasc);
		textFieldDataNasc.setBackground(null);
		textFieldDataNasc.setSize(300, 40);
		panel.add(textFieldDataNasc);

		TitledBorder user = BorderFactory.createTitledBorder(lineBorder, "Nome do Tutor/Usuario");
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(41, 315, 192, 20);
		textFieldUsuario.setBorder(user);
		textFieldUsuario.setBackground(null);
		textFieldUsuario.setSize(300, 40);
		panel.add(textFieldUsuario);


		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (Banco.contador) {
				case 0:
					foto="/ELEMENTOS/bull.png";
					break;
				case 1:
					foto="/ELEMENTOS/golden.png";
					break;
				case 2:
					foto="/ELEMENTOS/lulu.png";
					break;

				}
				Animal x = new Animal(textFieldNome.getText(), textFieldRaca.getText(), textFieldCor.getText(), textFieldEndereco.getText(), textFieldTelefone.getText(), textFieldDataNasc.getText(), textFieldUsuario.getText(), null, "/ELEMENTOS/bull.png");
				Banco.animais.set(Banco.contador, x);
				Banco.contador++;
				EscolhaDoPet.main(null);
				frmCadastro.dispose();
			}
		});
		btnSalvar.setBounds(182, 409, 179, 41);
		ImageIcon imgBtnCadastro = new ImageIcon(getClass().getResource("/ELEMENTOS/SELECIONE O PET.png"));
		imgBtnCadastro.setImage(
				imgBtnCadastro.getImage().getScaledInstance(btnSalvar.getWidth(), btnSalvar.getHeight() + 60, 1));
		btnSalvar.setBorderPainted(false);
		btnSalvar.setBackground(null);
		btnSalvar.setIcon(imgBtnCadastro);
		panel.add(btnSalvar);

		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(316, 122, 240, 219);
		ImageIcon icon = new ImageIcon(getClass().getResource("/ELEMENTOS/13.png"));
		icon.setImage(icon.getImage().getScaledInstance(lblIcon.getWidth() + 60, lblIcon.getHeight() + 10, 1));
		lblIcon.setIcon(icon);
		panel.add(lblIcon);

		lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSair.setBounds(499, 377, 75, 61);
		ImageIcon sair = new ImageIcon(getClass().getResource("/ELEMENTOS/14.png"));
		sair.setImage(sair.getImage().getScaledInstance(lblSair.getWidth(), lblSair.getHeight(), 1));
		lblSair.setIcon(sair);
		panel.add(lblSair);
		
		
	}
}
