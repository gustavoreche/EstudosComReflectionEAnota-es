package sistema.main;

import java.util.ArrayList;

import sistema.conversor.ConversorXML;
import sistema.modelo.Produto;

public class Main {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto(123456, "COCA", 3.50);
		Produto p2 = new Produto(99999, "PAO DE QUEIJO", 1.20);
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		listaProduto.add(p1);
		listaProduto.add(p2);
		
		String converte = new ConversorXML().converte(listaProduto);
		System.out.println(converte);
		
	}

}
