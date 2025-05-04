package view;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import control.Pagamento;
import control.Relatorios;

/**
 * Elaboração da interface gráfica dos relatórios com o valor total de todas as compras feitas no dia, solicitação de nota fiscal específica e arquivo de notas fiscais 
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TRelatorios extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea txtRelatorio;
	private String data;
	private ArrayList<String> lista = new ArrayList<String>();

	public TRelatorios(JDesktopPane desktopPane, String caminho, String operador, String acesso) {
		setBounds(0, 0, 1920, 1080);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu Relatorios Gerenciais",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu ", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(92, 119, 1487, 885);
		panel.add(panel_1);
		panel_1.setLayout(null);

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
		btnMenu.setBounds(150, 427, 280, 100);
		panel_1.add(btnMenu);

		JButton btnResumo = new JButton("Resumo do dia");
		btnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						Relatorios r = new Relatorios();
						String vetor[] = r.vendaPeriodo(caminho, data, data, true).split("@");
						txtRelatorio.append("\t\t\t\tSonho Verde - Produtos de Limpeza\n\n\n");
						txtRelatorio.append("Resumo do periodo : " + data + "\n");
						// txtRelatorio.append("Periodo Final : " + dataF + "\n");
						txtRelatorio.append("*****************************************\n\n");
						for (int i = 0; i < vetor.length; i++) {
							txtRelatorio.append(vetor[i] + "\n");
						}
						txtRelatorio.append("\n*****************************************\n\n");
						// ******************************************************
					}
				}).start();
			}
		});
		btnResumo.setForeground(Color.WHITE);
		btnResumo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnResumo.setBackground(new Color(0, 51, 0));
		btnResumo.setBounds(150, 52, 280, 100);
		panel_1.add(btnResumo);

		JButton btnNota = new JButton("Nota Fiscal");
		btnNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// ******************************************************
						Relatorios r = new Relatorios();
						String nf = JOptionPane.showInputDialog(null,
								"Digite número nota da fiscal a ser localizada : ");
						if (nf != null && !nf.isEmpty()) {
							boolean aux = r.notaFiscal(caminho, nf, lista);
							if (aux == true) {
								txtRelatorio.append("\t\t         Sonho Verde - Produtos de Limpeza\n\n\n\nResumo do cupom fiscal \n\n");
								for (int i = 0; i < lista.size(); i++) {
									txtRelatorio.append(lista.get(i) + "\n");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Nota Fiscal não encontrada");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Informe número da Nota Fiscal!");
						}
						// ******************************************************
					}
				}).start();
			}
		});
		btnNota.setForeground(Color.WHITE);
		btnNota.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNota.setBackground(new Color(0, 51, 0));
		btnNota.setBounds(150, 178, 280, 100);
		panel_1.add(btnNota);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Relatorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(637, 11, 814, 852);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		txtRelatorio = new JTextArea();
		txtRelatorio.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		txtRelatorio.setEditable(false);
		txtRelatorio.setBounds(10, 21, 772, 820);
		panel_2.add(txtRelatorio);


		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// **************************************************
				txtRelatorio.setText("");
				lista.clear();
				// **************************************************
			}
		});
		btnLimparTela.setForeground(Color.WHITE);
		btnLimparTela.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnLimparTela.setBackground(Color.CYAN);
		btnLimparTela.setBounds(470, 807, 140, 56);
		panel_1.add(btnLimparTela);

		JButton btnNotasFiscais = new JButton(
				"<html><body><center>" + "Arquivo Notas Fiscais" + "</center></body></html>");
		btnNotasFiscais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						// **********************************************************
						Pagamento p = new Pagamento();
						p.exibirCupom(caminho, true);
						// **********************************************************
					}
				}).start();
			}
		});
		btnNotasFiscais.setForeground(Color.WHITE);
		btnNotasFiscais.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNotasFiscais.setBackground(new Color(0, 51, 0));
		btnNotasFiscais.setBounds(150, 302, 280, 100);
		panel_1.add(btnNotasFiscais);

		JLabel lblCadastroDeProdutos = new JLabel("Relat\u00F3rios");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblCadastroDeProdutos.setBounds(798, 45, 430, 64);
		panel.add(lblCadastroDeProdutos);

		JLabel label = new JLabel("Operador : " + operador);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(372, 61, 275, 49);
		panel.add(label);

		Calendar d = Calendar.getInstance();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		data = (String) dataFormatada.format(d.getTime());
		JLabel lblData = new JLabel(data);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.BLACK);
		lblData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblData.setBounds(1692, 64, 156, 43);
		panel.add(lblData);

	}
}
