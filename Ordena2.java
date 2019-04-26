import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Ordena2 {
	
	public static void main(String[] args) throws Exception 
	{
		ArrayList<Endereco> a1 = new ArrayList<Endereco>();
		RandomAccessFile f = new RandomAccessFile("Arquivos/cep.dat", "r");//Não esta ordenado
		//f.lenght() tamanho em bytes.Ultima posição do byte.
		long qtd=f.length()/300;//Sabe o numero de registros
		long metade = qtd/2;
		//Primeira metade
		
		long valor=metade*300;
		while( f.getFilePointer() < valor) // para Detectar EOF
		{
			Endereco e = new Endereco();
			e.leEndereco(f);
			a1.add(e);
			
		}
		
		System.out.println("Ja leu");
		Collections.sort(a1,new ComparaCEP());//Isso é ordenar em memoria != ordena em disco(intercalação)
		
		RandomAccessFile saida = new RandomAccessFile("Arquivos/cep_a.dat", "rw");
		for(Endereco e: a1)
		{
			e.escreveEndereco(saida);
		}
		saida.close();
		System.out.println("Ja escreveu primeira metade");
		
		//Segunda metade
		
		ArrayList<Endereco> a2 = new ArrayList<Endereco>();
		while( f.getFilePointer() < f.length() ) // para Detectar EOF
		{
			Endereco e = new Endereco();
			e.leEndereco(f);
			a2.add(e);
		}
		
		System.out.println("Ja leu segunda metade");
		Collections.sort(a2,new ComparaCEP());//Ordena em memoria != ordena em disco
		
		RandomAccessFile saida_b = new RandomAccessFile("Arquivos/cep_b.dat", "rw");
		for(Endereco e: a2)
		{
			e.escreveEndereco(saida_b);
		}
		saida_b.close();
	
		System.out.println("Ja escreveu segunda metade");
		
		f.close();//Acabou a leitura de vez
		
		
	}

}
