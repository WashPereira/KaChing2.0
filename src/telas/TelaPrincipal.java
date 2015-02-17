package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.LineBorder;


public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("KaChing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Perfil de Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(10, 11, 242, 252);
		contentPane.add(panel);
		
		JLabel ImgPerfilM = new JLabel("");
		ImgPerfilM.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/Man.png")));
		panel.add(ImgPerfilM);
		
		JLabel EditarPerfil = new JLabel("Editar Perfil");
		EditarPerfil.setVerticalAlignment(SwingConstants.TOP);
		EditarPerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/editar.png")));
		panel.add(EditarPerfil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Calendario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_1.setToolTipText("");
		panel_1.setBounds(10, 274, 242, 216);
		contentPane.add(panel_1);
		
		JCalendar calendar = new JCalendar();
		panel_1.add(calendar, "2, 2, left, top");
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.GRAY);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Controle do Caixa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(270, 11, 1070, 479);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel InserirReceita = new JLabel("Inserir Receita");
		InserirReceita.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		InserirReceita.setBounds(10, 418, 170, 50);
		panel_2.add(InserirReceita);
		InserirReceita.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/plus+.png")));
		
		JLabel InserirDespesas = new JLabel("Inserir Despesas");
		InserirDespesas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		InserirDespesas.setBounds(190, 418, 180, 50);
		panel_2.add(InserirDespesas);
		InserirDespesas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/rounded61.png")));
		
		JLabel InserirMetas = new JLabel("Inserir Metas");
		InserirMetas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		InserirMetas.setBounds(380, 418, 170, 50);
		panel_2.add(InserirMetas);
		InserirMetas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/alvo.png")));
		
		JLabel PouparDinheiro = new JLabel("Poupar Dinheiro");
		PouparDinheiro.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		PouparDinheiro.setBounds(560, 418, 180, 50);
		panel_2.add(PouparDinheiro);
		PouparDinheiro.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/pig.png")));
		
		JLabel Relatorios = new JLabel("Relat\u00F3rios");
		Relatorios.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Relatorios.setBounds(750, 418, 150, 50);
		panel_2.add(Relatorios);
		Relatorios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/relatorio..png")));
		
		JLabel lblNewLabel_1 = new JLabel("Editar");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(909, 201, 122, 50);
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/pencil78.png")));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Check-In");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(909, 140, 151, 50);
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/check.png")));
		panel_2.add(lblNewLabel);
		
		JLabel lblApagar = new JLabel("Apagar");
		lblApagar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblApagar.setBounds(909, 263, 122, 50);
		lblApagar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/img/apagar.png")));
		panel_2.add(lblApagar);
		
		JLabel lblInserirTabelaAqui = new JLabel("Inserir tabela aqui");
		lblInserirTabelaAqui.setBounds(10, 33, 113, 14);
		panel_2.add(lblInserirTabelaAqui);
	
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Linha do Tempo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_3.setBounds(10, 501, 1330, 202);
		contentPane.add(panel_3);
		
	}
}
