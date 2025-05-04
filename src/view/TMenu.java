package view;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

/**
 * Elaboração da interface gráfica do menu: Caixa, cadastro de produtos, cadastro de usuários, relatórios, login e fornecedores 
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TMenu extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public TMenu(JDesktopPane desktopPane, String caminho, String operador, String acesso) {
		setBounds(0, 0, 1920, 1080);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Op\u00E7\u00F5es do Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(141, 186, 1259, 632);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Caixa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// *********************************************************************************
						TCaixa tc = new TCaixa(desktopPane, caminho, operador, acesso);
						desktopPane.add(tc);
						tc.setVisible(true);
						dispose();
						// *********************************************************************************
					}
				}).start();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(156, 94, 300, 180);
		panel_1.add(btnNewButton);

		JButton btnCadastroProdutos = new JButton("Cadastro Produtos");
		btnCadastroProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// *****************************************************
						if (acesso.equals("adm")) {
							TProdutos tp = new TProdutos(desktopPane, caminho, operador, acesso);
							desktopPane.add(tp);
							tp.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Acesso não autorizado");
						}
						// *****************************************************
					}
				}).start();
			}
		});
		btnCadastroProdutos.setForeground(Color.WHITE);
		btnCadastroProdutos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		if (acesso.equals("adm")) {
			btnCadastroProdutos.setBackground(Color.GRAY);
		} else {
			btnCadastroProdutos.setBackground(Color.LIGHT_GRAY);
		}
		btnCadastroProdutos.setBounds(476, 94, 300, 180);
		panel_1.add(btnCadastroProdutos);

		JButton btnCadastroUsuarios = new JButton("Cadastro Usu\u00E1rios");
		btnCadastroUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// *****************************************************
						if (acesso.equals("adm")) {
							TPessoas tp = new TPessoas(desktopPane, caminho, operador, acesso);
							desktopPane.add(tp);
							tp.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Acesso não autorizado");
						}
						// *****************************************************
					}
				}).start();
			}
		});
		btnCadastroUsuarios.setForeground(Color.WHITE);
		btnCadastroUsuarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		if (acesso.equals("adm")) {
			btnCadastroUsuarios.setBackground(Color.GRAY);
		} else {
			btnCadastroUsuarios.setBackground(Color.LIGHT_GRAY);
		}
		btnCadastroUsuarios.setBounds(793, 94, 300, 180);
		panel_1.add(btnCadastroUsuarios);

		JButton btnRelatriosDeVendas = new JButton("Relat\u00F3rios");
		btnRelatriosDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// *****************************************************
						if (acesso.equals("adm")) {
							TRelatorios tr = new TRelatorios(desktopPane, caminho, operador, acesso);
							desktopPane.add(tr);
							tr.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Acesso não autorizado");
						}
						// *****************************************************
					}
				}).start();
			}
		});
		btnRelatriosDeVendas.setForeground(Color.WHITE);
		btnRelatriosDeVendas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		if (acesso.equals("adm")) {
			btnRelatriosDeVendas.setBackground(Color.GRAY);
		} else {
			btnRelatriosDeVendas.setBackground(Color.LIGHT_GRAY);
		}
		btnRelatriosDeVendas.setBounds(156, 288, 300, 180);
		panel_1.add(btnRelatriosDeVendas);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// *************************************************
						TLogin tl = new TLogin(desktopPane, caminho);
						tl.setLocation(0, 0);
						desktopPane.add(tl);
						tl.setVisible(true);
						// *************************************************
					}
				}).start();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setBounds(476, 288, 300, 180);
		panel_1.add(btnLogin);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFornecedores exibir = new TFornecedores();
				exibir.setVisible(true);
			}
		});
		btnFornecedores.setForeground(Color.WHITE);
		btnFornecedores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnFornecedores.setBackground(Color.GRAY);
		btnFornecedores.setBounds(793, 288, 300, 180);
		panel_1.add(btnFornecedores);

		Calendar d = Calendar.getInstance();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		String data = (String) dataFormatada.format(d.getTime());

		JLabel label = new JLabel("Operador : " + operador);
		label.setBounds(204, 64, 247, 62);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label.setBackground(Color.WHITE);
		JLabel label_1 = new JLabel(data);
		label_1.setBounds(1244, 125, 168, 34);
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
				JLabel lblMenu = new JLabel("Menu");
				lblMenu.setBounds(874, 64, 107, 37);
				panel.add(lblMenu);
				lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
				lblMenu.setHorizontalAlignment(SwingConstants.CENTER);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBorder(null);

	}
}
