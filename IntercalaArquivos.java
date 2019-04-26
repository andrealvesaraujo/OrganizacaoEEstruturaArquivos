import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;

public class IntercalaArquivos {
	
	 	public static boolean feof(RandomAccessFile f) throws IOException
	    {
	        return (f.getFilePointer() >= f.length());
	    }
	 	
	 	//Precisa de arquivos ordenados
	    public static void intercala(RandomAccessFile a, RandomAccessFile  b, DataOutput c, Comparator<Endereco> compara) throws IOException
	 
	    {
	    	boolean eofA = false;
	    	boolean eofB = false;
	        Endereco ea = new Endereco();
	        Endereco eb = new Endereco();
	 
	        eofA = !ea.leEndereco(a);//Le linha do arquivo a 
	        eofB = !eb.leEndereco(b);// Le linha do arquivo b
	       
	        while(!eofA && !eofB)
	        {
	        	
	            if(compara.compare(ea,eb)<0)
	            {
	            	
	                ea.escreveEndereco(c);
	                eofA = !ea.leEndereco(a);
	            }
	            else
	            {
	            	eb.escreveEndereco(c);
	                eofB = !eb.leEndereco(b);
	            }
	        }
	        while(!eofA)
	        {
	        		ea.escreveEndereco(c);
	                eofA = !ea.leEndereco(a);
	            
	            
	        }
	        while(!eofB)
	        {
	        		eb.escreveEndereco(c);
	                eofB = !eb.leEndereco(b);
	            
	        }
	    }
	    
}
