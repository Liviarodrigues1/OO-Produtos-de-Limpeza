package view;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import control.Usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

/**
 * Elaboração da interface gráfica dos usuários
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TPessoas extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JComboBox<String> cmbAcesso;

	public void limparTela() {
		txtCodigo.setText("");
		txtUsuario.setText("");
		txtSenha.setText("");
		txtLogin.setText("");
		cmbAcesso.setSelectedIndex(-1);
	}

	public TPessoas(JDesktopPane desktopPane, String caminho, String operador, String acesso) {
		setBounds(0, 0, 1920, 1080);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu cadastro de Usu\u00E1rios",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informa\u00E7\u00F5es do Usu\u00E1rio",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(167, 139, 1267, 618);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCodigo.setBounds(223, 81, 120, 40);
		panel_1.add(lblCodigo);
		lblCodigo.setVisible(false);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(326, 77, 108, 40);
		panel_1.add(txtCodigo);
		txtCodigo.setVisible(false);

		JLabel lblNvelDeAcesso = new JLabel("N\u00EDvel de Acesso");
		lblNvelDeAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNvelDeAcesso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNvelDeAcesso.setBounds(205, 284, 187, 40);
		panel_1.add(lblNvelDeAcesso);

		cmbAcesso = new JComboBox<String>();
		cmbAcesso.setModel(new DefaultComboBoxModel<String>(new String[] { "adm", "Usu\u00E1rio" }));
		cmbAcesso.setSelectedIndex(-1);
		cmbAcesso.setBounds(406, 288, 88, 36);
		panel_1.add(cmbAcesso);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsurio.setBounds(204, 139, 139, 39);
		panel_1.add(lblUsurio);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(332, 130, 725, 64);
		panel_1.add(txtUsuario);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblLogin.setBounds(185, 207, 187, 56);
		panel_1.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setColumns(10);
		txtLogin.setBounds(332, 207, 176, 64);
		panel_1.add(txtLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSenha.setBounds(733, 215, 172, 40);
		panel_1.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setColumns(10);
		txtSenha.setBounds(881, 207, 176, 64);
		panel_1.add(txtSenha);

		JButton btnNewButton = new JButton("Salvar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						if (txtUsuario.getText() != null && txtLogin.getText() != null && txtSenha.getText() != null
								&& cmbAcesso.getSelectedIndex() != -1 ) {  //&& txtCodigo.getText() != null
							Usuarios u = new Usuarios();
							boolean aux = u.confere(caminho, txtCodigo.getText());
							if (aux == false) {
								u.salvar(caminho, txtLogin.getText(), txtSenha.getText(),
										(String) cmbAcesso.getSelectedItem(), txtUsuario.getText());
								limparTela();
							} else {
								aux = u.alterar(caminho, txtLogin.getText(), txtSenha.getText(),
										(String) cmbAcesso.getSelectedItem(), txtUsuario.getText(),
										txtCodigo.getText());
								if (aux == true) {
									limparTela();
								} else {
									JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro!");
									limparTela();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Preencha todos os dados para \nefetuar/alterar o cadastro!");
						}
						// ******************************************************
					}
				}).start();
			}
		});
		btnNewButton.setBackground(new Color(0, 51, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(307, 355, 230, 100);
		panel_1.add(btnNewButton);

		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						String usuario = JOptionPane.showInputDialog(null, "Digite nome do usuario a ser localizado :");
						Usuarios u = new Usuarios();
						boolean aux = u.localizar(usuario, caminho);
						if (aux == true) {
							txtUsuario.setText(u.getUsuario());
							txtLogin.setText(u.getLogin());
							txtSenha.setText(u.getSenha());
							txtCodigo.setText(u.getCodigo());
							cmbAcesso.setSelectedItem(u.getAcesso());
						} else {
							JOptionPane.showMessageDialog(null, "Usuário inexistente!");
						}
						// ******************************************************
					}
				}).start();
			}
		});
		btnLocalizar.setForeground(Color.WHITE);
		btnLocalizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnLocalizar.setBackground(new Color(0, 51, 0));
		btnLocalizar.setBounds(547, 355, 230, 100);
		panel_1.add(btnLocalizar);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						TMenu tm = new TMenu(desktopPane, caminho, operador, acesso);
						desktopPane.add(tm);
						tm.setVisible(true);
						dispose();
						// ******************************************************
					}
				}).start();
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnMenu.setBackground(new Color(0, 51, 0));
		btnMenu.setBounds(787, 355, 230, 100);
		panel_1.add(btnMenu);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						if (!txtUsuario.getText().isEmpty()) {
							Usuarios u = new Usuarios();
							boolean aux = u.alterar(caminho, txtLogin.getText(), txtSenha.getText(),
									(String) cmbAcesso.getSelectedItem(), txtUsuario.getText(), txtCodigo.getText());
							if (aux == true) {
								limparTela();
							} else {
								JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro!");
								limparTela();
							}
						} else {
							String usuario = JOptionPane.showInputDialog(null,
									"Digite nome do usuario a ser localizado :");
							Usuarios u = new Usuarios();
							boolean aux = u.localizar(usuario, caminho);
							if (aux == true) {
								txtUsuario.setText(u.getUsuario());
								txtLogin.setText(u.getLogin());
								txtSenha.setText(u.getSenha());
								txtCodigo.setText(u.getCodigo());
								cmbAcesso.setSelectedItem(u.getAcesso());
							} else {
								JOptionPane.showMessageDialog(null, "Usuário inexistente!");
							}
						}
						// ******************************************************
					}
				}).start();
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnEditar.setBackground(new Color(0, 51, 0));
		btnEditar.setBounds(307, 466, 230, 100);
		panel_1.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread (new Runnable() {
					public void run() {
				// ******************************************************
				if (txtUsuario.getText().isEmpty()) {
					String nome = JOptionPane.showInputDialog(null, "Digite nome do usuário a ser excluido :");
					Usuarios u = new Usuarios();
					boolean aux = u.excluir(nome, caminho);
					if (aux == true) {
						JOptionPane.showMessageDialog(null, "Cadastro deletado!");
						limparTela();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario não localizado!");
						limparTela();
					}
				} else {
					Usuarios u = new Usuarios();
					boolean aux = u.excluir(txtUsuario.getText(), caminho);
					if (aux == true) {
						JOptionPane.showMessageDialog(null, "Cadastro deletado!");
						limparTela();
					}
				}
				// ******************************************************
					}
				}).start();
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnExcluir.setBackground(new Color(0, 51, 0));
		btnExcluir.setBounds(547, 466, 230, 100);
		panel_1.add(btnExcluir);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// **************************************************
				limparTela();
				// **************************************************
			}
		});
		btnLimparTela.setForeground(Color.WHITE);
		btnLimparTela.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnLimparTela.setBackground(new Color(204, 204, 255));
		btnLimparTela.setBounds(139, 510, 140, 56);
		panel_1.add(btnLimparTela);
		
		JButton btnArq = new JButton("<html><body><center>Arquivo Usuários Cadastrados</center></body></html>");
		btnArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//****************************************************
				Usuarios u=new Usuarios();
				u.exibirArquivo(caminho);
				//****************************************************
				
			}
		});
		btnArq.setForeground(Color.WHITE);
		btnArq.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnArq.setBackground(new Color(0, 51, 0));
		btnArq.setBounds(787, 466, 230, 100);
		panel_1.add(btnArq);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Pessoas");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblCadastroDeProdutos.setBounds(707, 10, 430, 37);
		panel.add(lblCadastroDeProdutos);

		JLabel label = new JLabel("Operador : " + operador);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(289, 53, 261, 52);
		panel.add(label);

		Calendar d = Calendar.getInstance();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		String data = (String) dataFormatada.format(d.getTime());
		JLabel label_10 = new JLabel(data);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_10.setBounds(1319, 58, 188, 43);
		panel.add(label_10);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBorder(null);

	}
}
