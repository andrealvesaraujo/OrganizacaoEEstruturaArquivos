import java.io.RandomAccessFile;
import java.util.*;


public class Ordena {

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
		System.out.println("Ja leu");
		Collections.sort(a,new ComparaCEP());//Ordena em memoria != ordena em disco
		RandomAccessFile f2 = new RandomAccessFile("Arquivos/cep_ordenado_java.dat", "rw");
		for(Endereco e: a)
		{
			e.escreveEndereco(f2);
		}
		f2.close();
		System.out.println("Ja escreveu");
	}

}
