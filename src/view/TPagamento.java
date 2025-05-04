package view;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import control.Pagamento;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

/**
 * Elaboração da interface gráfica das formas de pagamento dizendo ao cliente se o pagamento foi realizado ou o dinheiro foi insuficiente
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TPagamento extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtSubtotal;
	private JTextField txtPay;
	private String pagamento = "";
	private double sub;
	private JComboBox<String> cmbPagamento;

	public void pay(String numero) {
		pagamento = pagamento + numero;
		if (pagamento.contains(".") && !pagamento.endsWith(".")
				&& pagamento.substring(pagamento.indexOf(".")).length() > 2) {
			pagamento = pagamento.substring(0, pagamento.indexOf(".") + 3);
		}
		txtPay.setText(pagamento);
	}

	public TPagamento(JDesktopPane desktopPane, String caminho, String subtotal, String operador, String acesso) {
		setBounds(0, 0, 1920, 1080);
		sub = Double.parseDouble(subtotal.replace(",", "."));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu Pagamento",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(660, 0, 516, 748);
		panel.add(panel_1);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setBounds(181, 10, 140, 48);
		panel_1.add(lblSubtotal);
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(128, 52, 260, 48);
		panel_1.add(txtSubtotal);
		txtSubtotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubtotal.setEditable(false);
		txtSubtotal.setColumns(10);
		txtSubtotal.setText(subtotal);

		JLabel label_1 = new JLabel("Formas de Pagamento");
		label_1.setBounds(160, 110, 207, 29);
		panel_1.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);

		cmbPagamento = new JComboBox<String>();
		cmbPagamento.setBounds(181, 146, 145, 35);
		panel_1.add(cmbPagamento);
		cmbPagamento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		cmbPagamento.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Dinheiro", "D\u00E9bito", "Cr\u00E9dito", "Ticket", "" }));
		cmbPagamento.setSelectedIndex(-1);

		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_1.setBounds(128, 191, 80, 80);
		panel_1.add(button_1);
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 51, 0));

		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_2.setBounds(218, 191, 80, 80);
		panel_1.add(button_2);
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 51, 0));

		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_3.setBounds(308, 191, 80, 80);
		panel_1.add(button_3);
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 51, 0));

		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_4.setBounds(128, 281, 80, 80);
		panel_1.add(button_4);
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(0, 51, 0));

		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_5.setBounds(218, 281, 80, 80);
		panel_1.add(button_5);
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(0, 51, 0));

		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_6.setBounds(308, 281, 80, 80);
		panel_1.add(button_6);
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(new Color(0, 51, 0));

		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_7.setBounds(128, 371, 80, 80);
		panel_1.add(button_7);
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(new Color(0, 51, 0));

		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_8.setBounds(218, 371, 80, 80);
		panel_1.add(button_8);
		button_8.setForeground(Color.WHITE);
		button_8.setBackground(new Color(0, 51, 0));

		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_9.setBounds(308, 371, 80, 80);
		panel_1.add(button_9);
		button_9.setForeground(Color.WHITE);
		button_9.setBackground(new Color(0, 51, 0));

		JButton button_10 = new JButton("0");
		button_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_10.setBounds(128, 461, 80, 80);
		panel_1.add(button_10);
		button_10.setForeground(Color.WHITE);
		button_10.setBackground(new Color(0, 51, 0));

		JButton button_11 = new JButton(".");
		button_11.setBounds(218, 461, 80, 80);
		panel_1.add(button_11);
		button_11.setForeground(Color.WHITE);
		button_11.setBackground(new Color(0, 51, 0));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pagamento.contains(".") && !pagamento.isEmpty()) {
					pay(".");
				}
			}
		});
		button_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));

		JButton button_12 = new JButton("X");
		button_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_12.setBounds(308, 461, 80, 80);
		panel_1.add(button_12);
		button_12.setForeground(Color.WHITE);
		button_12.setBackground(new Color(0, 51, 0));

		txtPay = new JTextField();
		txtPay.setBounds(128, 551, 260, 48);
		panel_1.add(txtPay);
		txtPay.setHorizontalAlignment(SwingConstants.CENTER);
		txtPay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtPay.setEditable(false);
		txtPay.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(128, 609, 260, 48);
		panel_1.add(btnRegistrar);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnRegistrar.setBackground(new Color(0, 51, 0));
		btnRegistrar.setForeground(Color.WHITE);

		JButton button_13 = new JButton("Voltar Caixa");
		button_13.setBounds(128, 679, 260, 48);
		panel_1.add(button_13);
		button_13.setForeground(Color.WHITE);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ************************************************
						TCaixa tc = new TCaixa(desktopPane, caminho, operador, acesso);
						desktopPane.add(tc);
						tc.setVisible(true);
						dispose();
						// ************************************************
					}
				}).start();
			}
		});
		button_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		button_13.setBackground(new Color(0, 51, 0));
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						if (cmbPagamento.getSelectedIndex() != -1) {
							String pay = (String) cmbPagamento.getSelectedItem();
							switch (pay) {
							case "Dinheiro": {
								if (pagamento.isEmpty()) {
									pagamento = "0";
								}
								if (Double.parseDouble(pagamento) >= sub) {
									String troco = Double.toString(Double.parseDouble(pagamento) - sub);
									Pagamento p = new Pagamento();
									Calendar d = Calendar.getInstance();
									SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
									String data = (String) dataFormatada.format(d.getTime());
									boolean aux = p.nota(caminho, subtotal, pay, pagamento, troco, data, operador);
									JOptionPane.showMessageDialog(null,
											"Pagamento efetuado com sucesso!\nTroco : " + troco);
									if (aux == true) {
										p.exibirCupom(caminho);
										TCaixa tc = new TCaixa(desktopPane, caminho, operador, acesso);
										desktopPane.add(tc);
										tc.setVisible(true);
										dispose();
									}
								} else {
									JOptionPane.showMessageDialog(null, "Pagamento insuficiente");
								}
								break;
							}
							default: {
								pagamento = subtotal.replace(",", ".");
								if (Double.parseDouble(pagamento) == sub) {
									Pagamento p = new Pagamento();
									Calendar d = Calendar.getInstance();
									SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
									String data = (String) dataFormatada.format(d.getTime());
									boolean aux = p.nota(caminho, subtotal, pay, pagamento, "0,00", data, operador);
									JOptionPane.showMessageDialog(null,
											"Pagamento efetuado com sucesso!\nTroco : 0,00");
									if (aux == true) {
										p.exibirCupom(caminho);
										TCaixa tc = new TCaixa(desktopPane, caminho, operador, acesso);
										desktopPane.add(tc);
										tc.setVisible(true);
										dispose();
									}
								} else {
									JOptionPane.showMessageDialog(null, "Pagamento excedente/insuficiente");
								}
								break;
							}
							}
						}
					}
				}).start();
			}
		});
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pagamento.isEmpty()) {
					pagamento = pagamento.substring(0, pagamento.length() - 1);
					txtPay.setText(pagamento);
				}
			}
		});
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("0");
			}
		});
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("9");
			}
		});
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("8");
			}
		});
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("7");
			}
		});
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("6");
			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("5");
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("4");
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("3");
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("2");
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay("1");
			}
		});

	}
}