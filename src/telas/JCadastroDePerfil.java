package telas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes_extras.Conexao;

import javax.swing.JFormattedTextField;
import javax.swing.JFileChooser;

import com.sun.xml.internal.ws.Closeable;

public class JCadastroDePerfil extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField nome_usuario;
	private JPasswordField senha;
	private JPasswordField confirmar_senha;
	private JTextField nome_mae;

	Conexao conecta = new Conexao();// conecantando ao banco de dados
	private JTextField cpf;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroDePerfil frame = new JCadastroDePerfil();
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
	public JCadastroDePerfil() {
		setTitle("Perfil");
		setResizable(false);
		conecta.conectar();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel salvar_img = new JPanel();
		salvar_img.setBorder(new TitledBorder(new LineBorder(new Color(192,
				192, 192)), "Foto do Usu\u00E1rio", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.DARK_GRAY));
		salvar_img.setBackground(Color.WHITE);
		salvar_img.setBounds(24, 31, 230, 301);
		contentPane.add(salvar_img);
		salvar_img.setLayout(null);

		JLabel lbl_img = new JLabel("");
		lbl_img.setBounds(5, 14, 221, 281);
		salvar_img.add(lbl_img);

		JLabel lblNome = new JLabel("Nome Completo: *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(265, 51, 170, 14);
		contentPane.add(lblNome);

		nome = new JTextField();
		nome.setToolTipText("Digite seu nome completo.");
		nome.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nome.setForeground(Color.DARK_GRAY);
		nome.setBackground(Color.WHITE);
		nome.setBounds(265, 76, 448, 30);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblCpf = new JLabel("Nome de Usu\u00E1rio: *");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(265, 117, 170, 14);
		contentPane.add(lblCpf);

		nome_usuario = new JTextField();
		nome_usuario
				.setToolTipText("Digite um nome de usu\u00E1rio. Ex: meunome_meusobrenome");
		nome_usuario.setBackground(Color.WHITE);
		nome_usuario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nome_usuario.setForeground(Color.DARK_GRAY);
		nome_usuario.setBounds(265, 142, 448, 30);
		contentPane.add(nome_usuario);
		nome_usuario.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo: *");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(265, 176, 70, 30);
		contentPane.add(lblSexo);

		JComboBox sexo = new JComboBox();
		sexo.setBackground(Color.WHITE);
		sexo.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione uma op\u00E7\u00E3o...", "Feminino", "Masculino" }));
		sexo.setToolTipText("Selecione seu g\u00EAnero sexual.");
		sexo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		sexo.setForeground(Color.DARK_GRAY);
		sexo.setBounds(265, 208, 448, 30);
		contentPane.add(sexo);

		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(265, 249, 129, 14);
		contentPane.add(lblSenha);

		senha = new JPasswordField();
		senha.setToolTipText("Digite sua senha. Sua senha pode conter n\u00FAmeros e letras.");
		senha.setBackground(Color.WHITE);
		senha.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		senha.setForeground(Color.DARK_GRAY);
		senha.setBounds(265, 274, 448, 30);
		contentPane.add(senha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha: *");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(264, 307, 183, 30);
		contentPane.add(lblConfirmarSenha);

		confirmar_senha = new JPasswordField();
		confirmar_senha.setToolTipText("Confirme sua senha.");
		confirmar_senha.setBackground(Color.WHITE);
		confirmar_senha.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		confirmar_senha.setForeground(Color.DARK_GRAY);
		confirmar_senha.setBounds(265, 340, 448, 30);
		contentPane.add(confirmar_senha);

		JLabel lblNewLabel = new JLabel("CPF: *");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(18, 418, 65, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDaMe.setBounds(17, 482, 183, 14);
		contentPane.add(lblNomeDaMe);

		nome_mae = new JTextField();
		nome_mae.setToolTipText("Informe o nome da m\u00E3e para recuperar senha futuramente!");
		nome_mae.setBackground(Color.WHITE);
		nome_mae.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nome_mae.setForeground(Color.DARK_GRAY);
		nome_mae.setBounds(17, 507, 702, 30);
		contentPane.add(nome_mae);
		nome_mae.setColumns(10);

		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar
				.setToolTipText("Clique para salvar as informa\u00E7\u00F5es.");
		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					PreparedStatement pst = conecta.conn
							.prepareStatement("INSERT INTO Perfil"
									+ "(nome_mae, cpf, senha, nome_usuario, sexo, nome) VALUES"
									+ "(?,?,?,?,?,?)");

					pst.setString(1, nome_mae.getText());
					pst.setString(2, cpf.getText());
					pst.setString(3, new String(senha.getPassword()));
					pst.setString(4, nome_usuario.getText());
					if (sexo.getSelectedIndex() == 1) {
						pst.setString(5, "F");
					} else {
						pst.setString(5, "M");
					}
					pst.setString(6, nome.getText());
					if (nome.getText().trim().equals("")) {
						nome.requestFocus();
						JOptionPane.showMessageDialog(rootPane,
								"Campo NOME é obrigatório!");
					} else if (nome_usuario.getText().trim().equals("")) {
						nome_usuario.requestFocus();
						JOptionPane.showMessageDialog(rootPane,
								"Campo NOME DE USUÁRIO é obrigatório!");
					} else if (sexo.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(rootPane,
								"Campo SEXO é obrigatório!");
					} else if (new String(senha.getPassword()).trim()
							.equals("")) {
						senha.requestFocus();
						JOptionPane.showMessageDialog(rootPane,
								"Campo SENHA é obrigatório!");
					} else if (cpf.getText().trim().equals("")) {
						cpf.requestFocus();
						JOptionPane.showMessageDialog(rootPane,
								"Campo CPF é obrigatório!");
					} else {
						if (new String(senha.getPassword()).trim().equals(
								new String(confirmar_senha.getPassword()))) {
							pst.executeUpdate(); // faz salvar no banco de dados
							JOptionPane.showMessageDialog(rootPane,
									"Dados salvos com sucesso!");
							// limpar os campos após salvar no banco
							nome_mae.setText("");
							cpf.setText("");
							senha.setText("");
							confirmar_senha.setText("");
							nome_usuario.setText("");
							sexo.setSelectedIndex(0);
							nome.setText("");

							new TelaPrincipal().setVisible(true);
							JCadastroDePerfil.this.dispose();

						} else {
							JOptionPane.showMessageDialog(rootPane,
									"Confira suas senhas e tente novamente!");
							senha.requestFocus();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// passar os dados por parametro para a tabela.
			}
		});
		lblSalvar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblSalvar.setIcon(new ImageIcon(JCadastroDePerfil.class
				.getResource("/img/floppy1.png")));
		lblSalvar.setBounds(595, 594, 109, 55);
		contentPane.add(lblSalvar);

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// new JLogin().setVisible(true);
				JCadastroDePerfil.this.dispose();
			}
		});
		lblVoltar.setBackground(Color.WHITE);
		lblVoltar.setToolTipText("Clique para voltar a tela principal");
		lblVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblVoltar.setIcon(new ImageIcon(JCadastroDePerfil.class
				.getResource("/img/leftarrow.png")));
		lblVoltar.setBounds(24, 594, 694, 55);
		contentPane.add(lblVoltar);

		JLabel lblCarregarFoto = new JLabel("Inserir foto");
		lblCarregarFoto.setIcon(new ImageIcon(JCadastroDePerfil.class
				.getResource("/img/camera2.png")));
		lblCarregarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg",
						"jpeg", "gif", "png"));
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.showDialog(jfc, "Selecione");
				JOptionPane.showMessageDialog(null, jfc.getSelectedFile());
				String caminho = jfc.getSelectedFile().getAbsolutePath();
				ImageIcon icon = new ImageIcon(caminho);
				salvar_img.setBackground(null);
				lbl_img.setIcon(new ImageIcon(icon.getImage()
						.getScaledInstance(221, 281, Image.SCALE_SMOOTH)));
			}
		});
		lblCarregarFoto
				.setToolTipText("Clique para carregar uma foto de seu perfil.");
		lblCarregarFoto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCarregarFoto.setBounds(34, 332, 220, 54);
		contentPane.add(lblCarregarFoto);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 559, 724, 101);
		contentPane.add(panel_3);

		JLabel lblCamposObrigatrios = new JLabel("* campos obrigat\u00F3rios");
		lblCamposObrigatrios.setBounds(547, 31, 131, 14);
		contentPane.add(lblCamposObrigatrios);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 724, 375);
		contentPane.add(panel);

		cpf = new JTextField();
		cpf.setBounds(18, 438, 702, 30);
		contentPane.add(cpf);
		cpf.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 400, 724, 148);
		contentPane.add(panel_1);
	}
}
