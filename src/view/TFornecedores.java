package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 * 2 Fornecedores dos produtos de limpeza
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TFornecedores extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TFornecedores frame = new TFornecedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Fazendo a moldura
	 */
	public TFornecedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Limpex Industria e Comercio de Produtos de Limpeza LTDA ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("CNPJ: 04.928.734/0001-96");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Rua Ansio Salatiel, 199ROGERJOAO PESSOA - PB  ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Produtos de Limpeza Casa e Banheiro");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblProdutosDeLimpeza = new JLabel("Produtos de Limpeza Cozinha e Roupas");
		lblProdutosDeLimpeza.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblNewLabel_4 = new JLabel("Maxclean - Comercio de Materiais de Higiene e Limpeza");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_5 = new JLabel("CNPJ: 08.456.756/0001-51");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_6 = new JLabel("Jardim Santo Antonio, Quadra20 Lote 06, Rua 10, Goiania GO  ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_7 = new JLabel("CEP: 58020-000");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_8 = new JLabel("CEP: 74.853-230");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_10 = new JLabel("Data de fabrica\u00E7\u00E3o: 20/03/2020           Data de Vencimento: 20/03/2022");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label = new JLabel("Data de fabrica\u00E7\u00E3o: 20/03/2020           Data de Vencimento: 20/03/2022");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
							.addGap(24))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(75, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(286, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(21, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(661, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProdutosDeLimpeza, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(501, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(357, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 765, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(613, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(424, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(662, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(4)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProdutosDeLimpeza, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(lblNewLabel_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_8)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
