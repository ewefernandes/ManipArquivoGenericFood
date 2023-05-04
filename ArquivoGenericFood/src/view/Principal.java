package view;

import java.io.IOException;

import controller.ArquivoFood;
import controller.IArquivoFood;

public class Principal {

	public static void main(String[] args) {
		String path = "C:\\TEMP";
		String name = "generic_food.csv";
		
		IArquivoFood arqFood = new ArquivoFood();
		
		try {
			arqFood.readFile(path, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
