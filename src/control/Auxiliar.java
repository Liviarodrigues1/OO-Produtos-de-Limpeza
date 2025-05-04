package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Auxiliar no entendimento do código e categorizar os produtos
 * 
 * @author Livia Rodrigues
 * 
 * @version 1.0 (Nov 2020)
 * 
 * São 4 categorias de produtos de limpeza: banheiro, casa, roupas e cozinha
 * 
 */

public class Auxiliar {

	public void arquivos(String caminho) {
		try {
			File f = new File(caminho);
			if (!f.mkdirs()) {
				File produtos = new File(caminho + "\\CProdutos.txt");
				File pessoas = new File(caminho + "\\CPessoas.txt");
				File notas = new File(caminho + "\\CNotasFiscais.txt");
				File lista = new File(caminho + "\\CLista.txt");
				lista.delete();
				File nota = new File(caminho + "\\CNota.txt");
				nota.delete();
				produtos.createNewFile();
				pessoas.createNewFile();
				notas.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CPessoas.txt"));
				String linha = null;
				while (br.ready()) {
					linha = br.readLine();
				}
				br.close();
				if (linha == null) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(pessoas, true));
					bw.write("LOGIN:admin SENHA:admin @adm@admin#1001\n");
					bw.newLine();
					bw.close();
				}
				linha = null;
				BufferedReader brNovo = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
				while (brNovo.ready()) {
					linha = brNovo.readLine();
				}
				brNovo.close();
				if (linha == null) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(produtos, true));
					bw.write("Sabonete@Banheiro@1@98@1020\n");
					bw.write("Desinfetante OMO@Banheiro@8@96@1024\n");
					bw.write("Água Sanitária Ypê 2L@Banheiro@5@96@1025\n");
					bw.write("Limpador Sanitário Cloro Gel @Banheiro@8@99@1026\n");
					bw.write("Saco para Lixo Reforçado@Casa@8@96@1027\n");
					bw.write("Pano Multiuso@Casa@10@98@1028\n");
					bw.write("Vassoura@Casa@5@99@1029\n");
					bw.write("Pá de lixo@Casa@3@99@1030\n");
					bw.write("Detergente Líquido@Cozinha@1@99@1031\n");
					bw.write("Esponja@Cozinha@2@99@1032\n");
					bw.write("Bombril@Cozinha@2@99@1033\n");
					bw.write("Sabão em Pasta @Cozinha@5@99@1034\n");
					bw.write("Amaciante OMO@Roupas@12@99@1035\n");
					bw.write("Sabão em pó OMO@Roupas@7@99@1036\n");
					bw.newLine();
					bw.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int button(String caminho) {
		int n = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("Banheiro") || linha.contains("Casa")) {
					n++;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int button(String caminho, boolean x) {
		int n = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("Roupas") || linha.contains("Cozinha")) {
					n++;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	public String nomes(String caminho) {
		String nome = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("Banheiro") || linha.contains("Casa")) {
					nome = nome + "#" + linha.substring(0, linha.indexOf("@"));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nome;
	}

	public String nomes(String caminho, boolean x) {
		String nome = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("Roupas") || linha.contains("Cozinha")) {
					nome = nome + "#" + linha.substring(0, linha.indexOf("@"));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nome;
	}

	public boolean corButton(String caminho, String roupas) {
		boolean aux = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho + "\\CProdutos.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.startsWith(roupas)) {
					String vetor[] = linha.split("@");
					if (vetor[3].equals("0")) {
						aux = false;
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

}
