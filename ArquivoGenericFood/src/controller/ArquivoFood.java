package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoFood implements IArquivoFood {

	@Override
	public void readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo); 
			BufferedReader buffer = new BufferedReader(leitor); 
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] categoria = linha.split(",");
				
				if (categoria[2].contains("Fruit")) {
					System.out.println(categoria[0] + espaco(categoria[0].length()) + categoria[1] + espaco(categoria[1].length()) +categoria[3] +espaco(categoria[3].length()));
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			fluxo.close();
			leitor.close();
		} else {
			throw new IOException("Arquivo invalido");
		}
		
	}

	private String espaco(int length) {
		StringBuffer buffer = new StringBuffer();
		
		if(length == 50) {
			return buffer.append(" ").toString();
		}else {
			buffer.append(" ");
			buffer.append(espaco(length+1));
			return buffer.toString();
		}
	}

}
