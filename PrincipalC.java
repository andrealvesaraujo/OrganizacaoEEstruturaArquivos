import java.io.DataOutput;
import java.io.RandomAccessFile;
import java.util.Comparator;

public class PrincipalC {
	public static void Igual(RandomAccessFile a, RandomAccessFile  b, RandomAccessFile c) throws Exception { 
		boolean eofA = false;
    	boolean eofB = false;
        Registro ea = new Registro();
        Registro eb = new Registro();
 
        eofA = !ea.leRegistro(a);//Le linha do arquivo a 
        eofB = !eb.leRegistro(b);// Le linha do arquivo b
        while(!eofA && !eofB)
        {
        	
            if(ea.equals(eb)){
            	 ea.escreveRegistro(c);
            	 eofA = !ea.leRegistro(a);//Le linha do arquivo a 
                 eofB = !eb.leRegistro(b);// Le linha do arquivo b
            }
        }
        
	}
	public static void main(String[] args) throws Exception{
		RandomAccessFile a=null,b=null,saida=null;
		System.out.println("Lendo arquivos de entrada");
	
		a = new RandomAccessFile("Arquivos/cep_a.dat", "r");
		b = new RandomAccessFile("Arquivos/cep_b.dat", "r");
		
		
	
		
		System.out.println("Lendo arquivo de saida");
	
	
		saida = new RandomAccessFile("Arquivos/cepOrdenado_resultado.dat", "rw");

		System.out.println("Metodo agora");
		//IntercalaArquivos.intercala(a, b, saida,new ComparaCEP());
	
		
		a.close();
		b.close();
		saida.close();
		System.out.println("Sucesso");
	}
}
