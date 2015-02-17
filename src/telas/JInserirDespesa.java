package telas;

//importação das bibiliotecas utilizadas nessa classe
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.awt.TextArea;
import classes_extras.Conexao;
import classes_extras.JNumberFormatField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.Color;


public class JInserirDespesa extends JFrame {

	private JPanel JFInserirDespesa;
	private JTextField nome_despesa;
	Conexao conecta = new Conexao();//conecantando ao banco de dados
	/**
	 * Launch the application.
	 * by: Wanderson R
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInserirDespesa frame = new JInserirDespesa();
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
	public JInserirDespesa() {
		conecta.conectar();
		setName("JFInserirDespesa");
		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Inserir Despesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		JFInserirDespesa = new JPanel();
		JFInserirDespesa.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JFInserirDespesa);
		JFInserirDespesa.setLayout(null);
		setLocationRelativeTo(null); //faz abrir centralizado na tela.
		
		JLabel lblNomeDaDespesa = new JLabel("Despesa:");
		lblNomeDaDespesa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDaDespesa.setBounds(23, 25, 118, 28);
		JFInserirDespesa.add(lblNomeDaDespesa);
		
		nome_despesa = new JTextField();
		nome_despesa.setToolTipText("Insira o nome da despesa.");
		nome_despesa.setBounds(20, 64, 685, 28);
		JFInserirDespesa.add(nome_despesa);
		nome_despesa.setColumns(10);
		
		TextArea descricao_despesa = new TextArea();
		descricao_despesa.setBounds(23, 137, 682, 131);
		JFInserirDespesa.add(descricao_despesa);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrio_1.setBounds(23, 103, 118, 28);
		JFInserirDespesa.add(lblDescrio_1);
		
		JLabel lblDataDeVencimento = new JLabel("Data de vencimento:");
		lblDataDeVencimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeVencimento.setBounds(23, 290, 227, 28);
		JFInserirDespesa.add(lblDataDeVencimento);
		
		JDateChooser data_venc_desp = new JDateChooser();
		data_venc_desp.setToolTipText("Insira a data de vencimento da despesa.");
		data_venc_desp.setBounds(20, 329, 685, 28);
		JFInserirDespesa.add(data_venc_desp);
		
		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParcelas.setBounds(23, 368, 118, 28);
		JFInserirDespesa.add(lblParcelas);
		
		JSpinField qtd_parcelas = new JSpinField();
		qtd_parcelas.setToolTipText("Insira a quantidade de parcelas que esta despesa possui, caso necess\u00E1rio.");
		qtd_parcelas.setMinimum(0);
		qtd_parcelas.setBounds(23, 407, 682, 28);
		JFInserirDespesa.add(qtd_parcelas);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(23, 445, 118, 28);
		JFInserirDespesa.add(lblValor);
		
		JNumberFormatField valor_despesa = new JNumberFormatField();
		valor_despesa.setToolTipText("Insira o valor da despesa. N\u00E3o pode conter letras ou valores negativos.");
		valor_despesa.setBounds(23, 484, 682, 28);
		JFInserirDespesa.add(valor_despesa);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es de cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 714, 524);
		JFInserirDespesa.add(panel);
		
		JLabel Voltar = new JLabel("Voltar");
		Voltar.setForeground(Color.DARK_GRAY);
		Voltar.setToolTipText("Clique aqui para voltar a tela inicial.");
		Voltar.setIcon(new ImageIcon(JInserirDespesa.class.getResource("/img/leftarrow.png")));
		Voltar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Voltar.setBounds(23, 560, 130, 79);
		JFInserirDespesa.add(Voltar);
		
		JLabel lblNewLabel = new JLabel("Salvar");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				java.util.Date data = data_venc_desp.getDate();//converter o formato da data
				try {
					PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO Despesas (id_perfil, nome_desp, vencimento, descricao_desp, qtd_parcela, valor_desp) VALUES (?,?,?,?,?,?)");//passar os dados por parametro para a tabela.
					
					//--Capturar as informações do formulário para o banco--//
					pst.setInt(1, 4);
					pst.setString(2, nome_despesa.getText());
					pst.setDate(3, new java.sql.Date(data.getTime()));
					pst.setString(4, descricao_despesa.getText());
					pst.setInt(5, qtd_parcelas.getValue());
					pst.setBigDecimal(6, valor_despesa.getValue());
					
					
					//--verificar os campos obrigatórios--//
					if(nome_despesa.getText() == null && nome_despesa.getText().length() < 0 && data_venc_desp.getDate()== null &&
							valor_despesa.getText().replaceAll("[^1-9]","").isEmpty()){
						JOptionPane.showMessageDialog(rootPane, "Verifique os campos obrigatórios!");
					}else{
						pst.executeUpdate();
						JOptionPane.showMessageDialog(rootPane, "Dados salvos com sucesso!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "ERRO:!"+e.getMessage());
				}
			}
		});
		lblNewLabel.setToolTipText("Clique aqui para salvar as informa\u00E7\u00F5es.");
		lblNewLabel.setIcon(new ImageIcon(JInserirDespesa.class.getResource("/img/floppy1.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(575, 560, 130, 79);
		JFInserirDespesa.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 546, 714, 104);
		JFInserirDespesa.add(panel_1);
	}
}
