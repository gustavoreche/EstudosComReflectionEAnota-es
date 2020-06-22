package sistema.main;

import java.util.ArrayList;

import sistema.conversor.ConversorXML;
import sistema.modelo.Marca;
import sistema.modelo.Produto;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Object> listaDeCompra = new ArrayList<Object>();

		Produto p1 = new Produto(123456, "COCA", 3.50);
		Produto p2 = new Produto(99999, "PAO DE QUEIJO", 1.20);
		
		Marca m1 = new Marca(1, "Coca cola Andina");
		Marca m2 = new Marca(2, "Pao de Alho Zinho");
		
		listaDeCompra.add(p1);
		listaDeCompra.add(p2);
		listaDeCompra.add(m1);
		listaDeCompra.add(m2);
		
		String converte = new ConversorXML().converte(listaDeCompra);
		System.out.println(converte);
		
	}

}
