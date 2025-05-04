package view;
/*
 * Login do administrador:      login: admin        senha: admin
 * Login do usuário(cliente):   login: livia        senha: 123
 */
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import control.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Elaboração da interface gráfica do login indicando login ou senha inválido ou acesso 
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TLogin extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField pswSenha;

	public TLogin(JDesktopPane desktopPane, String caminho) {
		setBounds(0, 0, 1920, 1080);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);


		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(new Color(0, 51, 0));
		lblLogin.setBackground(new Color(255, 255, 255));
		lblLogin.setBounds(743, 451, 97, 51);
		panel.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(690, 512, 210, 44);
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(new Color(0, 51, 0));
		lblSenha.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblSenha.setBackground(new Color(0, 51, 0));
		lblSenha.setBounds(736, 566, 117, 51);
		panel.add(lblSenha);

		JButton btnOK = new JButton("ENTER");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
					public void run() {
						// ***********************************************************
						Login l = new Login();
						@SuppressWarnings("deprecation")
						String acesso = l.login(caminho, txtLogin.getText(), pswSenha.getText());
						if (acesso != null) {
							if (acesso.substring(acesso.indexOf(" ") + 1, acesso.indexOf("@")).contentEquals("adm")) {
								String operador = acesso.substring(acesso.indexOf("@") + 1, acesso.indexOf("#"));
								acesso = "adm";
								TMenu tm = new TMenu(desktopPane, caminho, operador, acesso);
								desktopPane.add(tm);
								tm.setVisible(true);
								dispose();
							} else {
								String operador = acesso.substring(acesso.indexOf("@") + 1, acesso.indexOf("#"));
								acesso = "Usuário";
								TMenu tm = new TMenu(desktopPane, caminho, operador, acesso);
								desktopPane.add(tm);
								tm.setVisible(true);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Login ou senha invalido!!");
						}
						// ***********************************************************
					}
				}).start();
			}
		});
		btnOK.setFont(new Font("Serif", Font.PLAIN, 16));
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBackground(new Color(204, 204, 204));
		btnOK.setBounds(743, 677, 110, 44);
		panel.add(btnOK);

		pswSenha = new JPasswordField();
		pswSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					new Thread(new Runnable() {
						public void run() {
							// ***********************************************************
							Login l = new Login();
							@SuppressWarnings("deprecation")
							String acesso = l.login(caminho, txtLogin.getText(), pswSenha.getText());
							if (acesso != null) {
								if (acesso.substring(acesso.indexOf(" ") + 1, acesso.indexOf("@"))
										.contentEquals("adm")) {
									String operador = acesso.substring(acesso.indexOf("@") + 1, acesso.indexOf("#"));
									acesso = "adm";
									TMenu tm = new TMenu(desktopPane, caminho, operador, acesso);
									desktopPane.add(tm);
									tm.setVisible(true);
									dispose();
								} else {
									String operador = acesso.substring(acesso.indexOf("@") + 1, acesso.indexOf("#"));
									acesso = "Usuário";
									TMenu tm = new TMenu(desktopPane, caminho, operador, acesso);
									desktopPane.add(tm);
									tm.setVisible(true);
									dispose();
								}
							} else {
								JOptionPane.showMessageDialog(null, "Login ou senha invalido!!");
							}
							// ***********************************************************
						}
					}).start();
				}
			}
		});
		pswSenha.setHorizontalAlignment(SwingConstants.CENTER);
		pswSenha.setBounds(690, 623, 210, 44);
		panel.add(pswSenha);
		
		JLabel lblNewLabel = new JLabel("Sonho Verde ");
		lblNewLabel.setForeground(new Color(0, 51, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 90));
		lblNewLabel.setBounds(441, 146, 536, 155);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produtos de Limpeza");
		lblNewLabel_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1.setFont(new Font("Serif", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(835, 286, 289, 51);
		panel.add(lblNewLabel_1);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBorder(null);

	}
}
