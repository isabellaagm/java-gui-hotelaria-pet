package exercicioTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 500, 500);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 113, 88));
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JTextArea textAreaUser = new JTextArea();
		textAreaUser.setBounds(193, 206, 112, 22);
		panel.add(textAreaUser);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(193, 252, 112, 20);
		passwordFieldSenha.setBorder(null);
		panel.add(passwordFieldSenha);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.setForeground(null);
		btnEntrar.setBounds(205, 284, 89, 23);
		ImageIcon imgBtnEntrar = new ImageIcon(getClass().getResource("/ELEMENTOS/BOTÃO ENTRAR.png"));
		imgBtnEntrar.setImage(imgBtnEntrar.getImage().getScaledInstance(btnEntrar.getWidth(), btnEntrar.getHeight()+50, 1));
		btnEntrar.setIcon(imgBtnEntrar);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setBackground(new Color(242, 242, 255));
		panel.add(btnEntrar);
		
		JButton btnTelaCadastro = new JButton("");
		btnTelaCadastro.setBackground(new Color(242, 242, 255));
		btnTelaCadastro.setBounds(193, 309, 112, 23);
		ImageIcon imgBtnCadastro = new ImageIcon(getClass().getResource("/ELEMENTOS/9.png"));
		imgBtnCadastro.setImage(imgBtnCadastro.getImage().getScaledInstance(btnTelaCadastro.getWidth(), btnTelaCadastro.getHeight()+60, 1));
		btnTelaCadastro.setIcon(imgBtnCadastro);
		btnTelaCadastro.setBorderPainted(false);
		panel.add(btnTelaCadastro);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(193, 191, 46, 14);
		panel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(193, 238, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(57, -18, 364, 164);
		ImageIcon logo = new ImageIcon(getClass().getResource("/ELEMENTOS/Logo.png"));
		logo.setImage(logo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), 1));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(logo);
		panel.add(lblLogo);
		
		JLabel lblFotoUser = new JLabel("");
		lblFotoUser.setBounds(67, 100, 354, 254);
		lblFotoUser.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon fotoUsuario = new ImageIcon(getClass().getResource("/ELEMENTOS/3.png"));
		fotoUsuario.setImage(fotoUsuario.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), 1));
		lblFotoUser.setIcon(fotoUsuario);
		panel.add(lblFotoUser);
		
		btnTelaCadastro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Banco.senha=passwordFieldSenha.getText();
				Banco.usuario=textAreaUser.getText();
				passwordFieldSenha.setText("");
				textAreaUser.setText("");
			}
			
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(passwordFieldSenha.getText().equals(Banco.senha) && textAreaUser.getText().equals(Banco.usuario)) {
					EscolhaDoPet.main(null);
					frmLogin.dispose();
				} else if(textAreaUser.getText().equals(Banco.usuario)) {
					textAreaUser.setText("Senha incorreta");
				} else if(passwordFieldSenha.getText().equals(Banco.senha)) {
					textAreaUser.setText("Usuário incorreto");
				}
				
			}
			
		});
	}
}

