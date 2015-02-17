package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;

public class JMeta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField nomemetas;
	private JTextField datametas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMeta frame = new JMeta();
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
	public JMeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 734, 661);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome\r\n:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 121, 26);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 87, 121, 26);
		panel.add(label_1);
		
		JEditorPane descricao = new JEditorPane();
		descricao.setBackground(SystemColor.text);
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		descricao.setBounds(10, 114, 709, 177);
		panel.add(descricao);
		
		JLabel label_2 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 302, 171, 26);
		panel.add(label_2);
		
		JComboBox comboboxmetas = new JComboBox();
		comboboxmetas.setModel(new DefaultComboBoxModel(new String[] {"Caixa/Paupar", "Despesa", "Receita"}));
		comboboxmetas.setBounds(10, 339, 709, 30);
		panel.add(comboboxmetas);
		
		JLabel label_3 = new JLabel("Data a cumprir:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 442, 149, 26);
		panel.add(label_3);
		
		nomemetas = new JTextField();
		nomemetas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		nomemetas.setBounds(10, 46, 709, 31);
		panel.add(nomemetas);
		nomemetas.setColumns(10);
		
		datametas = new JTextField();
		datametas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		datametas.setColumns(10);
		datametas.setBounds(10, 469, 709, 30);
		panel.add(datametas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 510, 709, 112);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("Voltar");
		label_4.setBounds(10, 11, 130, 79);
		panel_2.add(label_4);
		label_4.setIcon(new ImageIcon(JMeta.class.getResource("/img/leftarrow.png")));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		label_4.setToolTipText("Clique aqui para voltar a tela inicial.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("Salvar\r\n");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		label_5.setBounds(599, 11, 130, 79);
		panel_2.add(label_5);
		label_5.setIcon(new ImageIcon(JMeta.class.getResource("/img/floppy1.png")));
		label_5.setToolTipText("Clique aqui para voltar a tela inicial.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_10 = new JLabel("Valor da meta:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(10, 380, 149, 26);
		panel.add(label_10);
		
		JFormattedTextField valormeta = new JFormattedTextField();
		valormeta.setText("\r\n");
		valormeta.setBounds(10, 405, 709, 30);
		panel.add(valormeta);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Metas Cadastradas\r\n", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Metas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 149, 31);
		panel_1.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 286, 317, -228);
		panel_1.add(table);
		
		JLabel label_7 = new JLabel("Editar\r\n");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setIcon(new ImageIcon(JMeta.class.getResource("/img/editar3.png")));
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_7.setBounds(556, 450, 149, 69);
		panel_1.add(label_7);
		
		JLabel label_9 = new JLabel("Salvar");
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setIcon(new ImageIcon(JMeta.class.getResource("/img/floppy1.png")));
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_9.setBounds(556, 530, 149, 69);
		panel_1.add(label_9);
		
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "Nome - Descri\u00E7\u00E3o", "Status", "Valor", "Data"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(304);
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBounds(10, 45, 709, 394);
		panel_1.add(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 450, 709, 155);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_6 = new JLabel("Apagar");
		label_6.setBounds(10, 0, 149, 69);
		panel_3.add(label_6);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setIcon(new ImageIcon(JMeta.class.getResource("/img/apagar.png")));
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		JLabel label_8 = new JLabel("Voltar");
		label_8.setBounds(10, 80, 149, 69);
		panel_3.add(label_8);
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setIcon(new ImageIcon(JMeta.class.getResource("/img/leftarrow.png")));
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 16));
	}
}
