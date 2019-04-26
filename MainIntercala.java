import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MainIntercala {
	public static void main(String args[]) throws Exception{
    		RandomAccessFile a=null,b=null,saida=null;
    		System.out.println("Lendo arquivos de entrada");
		
			a = new RandomAccessFile("Arquivos/cep_a.dat", "r");
			b = new RandomAccessFile("Arquivos/cep_b.dat", "r");
			
			
		
			
			System.out.println("Lendo arquivo de saida");
		
		
			saida = new RandomAccessFile("Arquivos/cepOrdenado_resultado.dat", "rw");
	
			System.out.println("Intercalando agora");
			IntercalaArquivos.intercala(a, b, saida,new ComparaCEP());
		
			
			a.close();
			b.close();
			saida.close();
			System.out.println("Sucesso");
		
    }
}
