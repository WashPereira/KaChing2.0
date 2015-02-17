package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class JRelatório extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRelatório frame = new JRelatório();
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
	public JRelatório() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecionar Ano");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 135, 27);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Tipo Relat\u00F3rio");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 68, 135, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Salvar");
		label_1.setIcon(new ImageIcon(JRelatório.class.getResource("/img/floppy1.png")));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(367, 503, 181, 76);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Imprimir");
		label_2.setIcon(new ImageIcon(JRelatório.class.getResource("/img/print.png")));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(181, 503, 181, 76);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(JRelatório.class.getResource("/img/marcar.png")));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(442, 68, 68, 76);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 37, 500, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 106, 422, 20);
		contentPane.add(comboBox_1);
	}
}
