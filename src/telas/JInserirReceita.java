package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_extras.Conexao;
import classes_extras.JNumberFormatField;//importando classe da mascara.

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.UIManager;
import telas.TelaPrincipal;
import java.awt.Dialog.ModalExclusionType;

public class JInserirReceita extends JFrame {

	private JPanel contentPane;
	Conexao conecta = new Conexao();// conecantando ao banco de dados

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInserirReceita frame = new JInserirReceita();
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
	public JInserirReceita() {
		setResizable(false);
		setAlwaysOnTop(true);
		conecta.conectar();
		// this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(null, "Saldo atual do caixa",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setToolTipText("");
		panel_4.setBounds(10, 21, 714, 104);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JNumberFormatField saldo_atual = new JNumberFormatField();
		saldo_atual.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		saldo_atual.setBounds(10, 47, 694, 30);
		panel_4.add(saldo_atual);

		JLabel lblSaldoAtual = new JLabel("Saldo Atual:");
		lblSaldoAtual.setBounds(10, 22, 108, 14);
		panel_4.add(lblSaldoAtual);
		lblSaldoAtual.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null,
				"Atualizar Salto atual do caixa", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 134, 714, 104);
		contentPane.add(panel);
		panel.setLayout(null);

		JNumberFormatField InserirSaldo = new JNumberFormatField();
		InserirSaldo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		InserirSaldo.setBounds(10, 54, 694, 30);
		panel.add(InserirSaldo);
		InserirSaldo
				.setToolTipText("Clique para inserir ou acrescentar um novo valor para o caixa.");

		JLabel lblInserir = new JLabel("Inserir:");
		lblInserir.setBounds(10, 29, 108, 14);
		panel.add(lblInserir);
		lblInserir.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JInserirReceita.this.dispose();
			}
		});
		lblVoltar.setBounds(29, 295, 121, 56);
		contentPane.add(lblVoltar);
		lblVoltar.setForeground(Color.DARK_GRAY);
		lblVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblVoltar.setIcon(new ImageIcon(JInserirReceita.class
				.getResource("/img/leftarrow.png")));

		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setBounds(590, 310, 115, 56);
		contentPane.add(lblSalvar);
		lblSalvar
				.setToolTipText("Clique para atualizar o saldo de sua poupan\u00E7a.");
		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					PreparedStatement pst = conecta.conn
							.prepareStatement("INSERT INTO receita (id_perfil, mes_ano_receita, valor_receita, id_receita) VALUES (?,?,?,?)");
					// passar os dados por parametro para a tabela.

					// --Capturar as informações do formulário para o banco--//
					pst.setInt(1, 4);
					pst.setDate(2,
							java.sql.Date.valueOf(java.time.LocalDate.now()));
					pst.setBigDecimal(3, InserirSaldo.getValue());
					pst.setInt(4, 1);

					// --verificar os campos obrigatórios--//
					if (InserirSaldo.getText() == null
							&& InserirSaldo.getText().length() < 0
							&& InserirSaldo.getText().replaceAll("[^1-9]", "")
									.isEmpty()) {
						JOptionPane.showMessageDialog(rootPane,
								"Verifique os campos obrigatórios!");
					} else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(rootPane,
								"Dados salvos com sucesso!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(rootPane,
							"ERRO:!" + e.getMessage());
				}
			}
		});
		lblSalvar.setForeground(Color.DARK_GRAY);
		lblSalvar.setIcon(new ImageIcon(JInserirReceita.class
				.getResource("/img/floppy1.png")));
		lblSalvar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
	}
}
