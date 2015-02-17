package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import classes_extras.Conexao;

public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Conexao conecta = new Conexao();//conecantando ao banco de dados
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		conecta.conectar();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblKaching = new JLabel("");
		lblKaching.setForeground(Color.GRAY);
		lblKaching.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
		lblKaching.setIcon(new ImageIcon(JLogin.class.getResource("/img/Kaching 02.png")));
		lblKaching.setBounds(199, 11, 262, 228);
		contentPane.add(lblKaching);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblNomeDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDeUsurio.setBounds(62, 250, 180, 14);
		contentPane.add(lblNomeDeUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(62, 332, 46, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(Color.WHITE);
		textField.setBounds(62, 275, 275, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		passwordField.setForeground(new Color(204, 204, 204));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(62, 357, 275, 33);
		contentPane.add(passwordField);
		
		JLabel lblEntar = new JLabel("Entrar");
		lblEntar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblEntar.setIcon(new ImageIcon(JLogin.class.getResource("/img/arrow242.png")));
		lblEntar.setBounds(376, 240, 215, 58);
		contentPane.add(lblEntar);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCadastrar.setIcon(new ImageIcon(JLogin.class.getResource("/img/pencil78.png")));
		lblCadastrar.setBounds(376, 296, 215, 58);
		contentPane.add(lblCadastrar);
		
		JLabel lblEsqueciMinhaSenha = new JLabel("Esqueci minha \r\nsenha");
		lblEsqueciMinhaSenha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblEsqueciMinhaSenha.setIcon(new ImageIcon(JLogin.class.getResource("/img/question.png")));
		lblEsqueciMinhaSenha.setBounds(376, 356, 215, 50);
		contentPane.add(lblEsqueciMinhaSenha);
	}
}
