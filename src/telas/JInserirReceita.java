package telas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JTextField;
import javax.swing.UIManager;

public class JInserirReceita extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Saldo atual do caixa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		panel.setBorder(new TitledBorder(null, "Atualizar Salto atual do caixa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 134, 714, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JNumberFormatField inserir_saldo = new JNumberFormatField();
		inserir_saldo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		inserir_saldo.setBounds(10, 54, 694, 30);
		panel.add(inserir_saldo);
		inserir_saldo.setToolTipText("Clique para inserir ou acrescentar um novo valor para o caixa.");
		
		JLabel lblInserir = new JLabel("Inserir:");
		lblInserir.setBounds(10, 29, 108, 14);
		panel.add(lblInserir);
		lblInserir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Atualizar saldo atual da poupan\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 249, 714, 104);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JNumberFormatField poupanca = new JNumberFormatField();
		poupanca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		poupanca.setBounds(10, 52, 694, 30);
		panel_1.add(poupanca);
		poupanca.setToolTipText("Clique para inserir um valor para acrescentar em sua poupan\u00E7a.");
		
		JLabel lblPoupana = new JLabel("Poupan\u00E7a:");
		lblPoupana.setBounds(10, 25, 90, 16);
		panel_1.add(lblPoupana);
		lblPoupana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sair", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 364, 714, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setForeground(Color.DARK_GRAY);
		lblVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblVoltar.setIcon(new ImageIcon(JInserirReceita.class.getResource("/img/leftarrow.png")));
		lblVoltar.setBounds(10, 23, 121, 56);
		panel_2.add(lblVoltar);
		
		JLabel lblPoupar = new JLabel("Poupar");
		lblPoupar.setBounds(589, 23, 115, 56);
		panel_2.add(lblPoupar);
		lblPoupar.setToolTipText("Clique para atualizar o saldo de sua poupan\u00E7a.");
		lblPoupar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String teste = poupanca.getText().replaceAll("[^1-9]",""); // Isso irá retirar qualquer caracter diferente de 1 e 9.
				if (teste.isEmpty()){
					JOptionPane.showMessageDialog(poupanca, "O campo está vazio. Verifique e tente novamente!");
				}
			}
		});
		lblPoupar.setForeground(Color.DARK_GRAY);
		lblPoupar.setIcon(new ImageIcon(JInserirReceita.class.getResource("/img/pig.png")));
		lblPoupar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
	}
}
