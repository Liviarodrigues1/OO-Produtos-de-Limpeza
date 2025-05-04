package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Auxiliar;
import javax.swing.JDesktopPane;

/**
 * Elaboração da interface gráfica inicial  
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 */

public class TInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	private String caminho = System.getProperty("user.dir") + "\\src\\model";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TInicial frame = new TInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TInicial() {
		setTitle("Sonho Verde\r\n");
		Auxiliar a = new Auxiliar();
		a.arquivos(caminho);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2100, 1120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		TLogin tl = new TLogin(desktopPane, caminho);
		tl.setLocation(0, 0);
		desktopPane.add(tl);
		tl.setVisible(true);
	}

}

