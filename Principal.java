package meuPacote;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Principal {
	//Ler um arquivo e criar novos arquivos separados por estado(guardar na pasta estados)
	//Primeiro ve um estado especifico
	public static void main(String[] args) throws Exception 
	{
		ArrayList<Endereco> a = new ArrayList<Endereco>();
		RandomAccessFile f = new RandomAccessFile("Arquivos/cep.dat", "r");
		while( f.getFilePointer() < f.length() ) // para Detectar EOF
		{
			Endereco e = new Endereco();
			e.leEndereco(f);
			a.add(e);
		}
		f.close();
		
		String s;
		
		String nomeArq;
		for(Endereco e: a) {
			System.out.println(e.getSigla());
			s=e.getSigla();
			if(s.compareTo("RJ")==0) {
				System.out.println("entrou");
				nomeArq ="Estados/RJ.dat";
			
				RandomAccessFile f2 = new RandomAccessFile(nomeArq, "rw");
				e.escreveEndereco(f2);
				
				
				f2.close();
			}	
			
		}
		System.out.println("terminou");
		
	}
}
