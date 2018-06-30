import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * Arquivo cujo foco é criar indice de um arquivo do bolsa familia utilizando uma função hash
 * @author Andre
 *
 */
public class CriarEInserirIndice {

	
	private static final int TAMANHO_HASH = 17000023;
	
	private static long h(String nis)
	{
		return Math.abs(nis.hashCode()) % TAMANHO_HASH;
		
	}
	
	private static void criaArquivoIndice() throws Exception
	{
		RandomAccessFile fileInd = new RandomAccessFile("IndicePrincipal.dat","rw");
		fileInd.setLength(0);
		Indice i = new Indice();
		System.out.println("Criando arquivo indice vazio");
		
		for(int j=0; j<TAMANHO_HASH;j++) {
			i.escreveElemento(fileInd);
			if(j%100000 == 0)
			{
				//System.out.println(j);
			}
		}
		fileInd.close();
	}
	
	private static void incluiIndice() throws Exception
	{
		int j=0;
		String linha, nis;
        String colunas[];
        long posicao;
		RandomAccessFile fileInd = new RandomAccessFile("IndicePrincipal.dat","rw");
		RandomAccessFile fileBolsaJan = new RandomAccessFile("BolsaFamiliaJaneiro.csv","r");
		
		Indice i = new Indice();
		long tamanhoArquivoIndice = fileInd.length();
		fileBolsaJan.readLine();
		System.out.println("Inserindo no arquivo indice elementos de BolsaFamiliaJaneiro");
		while(fileBolsaJan.getFilePointer() < fileBolsaJan.length())
		{
			
			j++;
			long arquivoPos=fileBolsaJan.getFilePointer();
            linha = fileBolsaJan.readLine();
            colunas = linha.split("\t");
            nis = colunas[7];
            
            posicao = h(nis);
            fileInd.seek(posicao * 24);
			i.leElemento(fileInd);
			fileInd.seek(posicao * 24);
			
			
			if(i.getChave() == 0 && i.getPosicao()==0)
			{
				
				i.setChave(Long.valueOf(nis).longValue());
				i.setPosicao(arquivoPos);
				i.setProximo(0);
				i.escreveElemento(fileInd);
			}
			else
			{
				
				long proximo = i.getProximo();
				i.setProximo(tamanhoArquivoIndice);
				i.escreveElemento(fileInd);
				i.setChave(Long.valueOf(nis).longValue());
				i.setPosicao(arquivoPos);
				i.setProximo(proximo);
				fileInd.seek(fileInd.length());
				i.escreveElemento(fileInd);
				tamanhoArquivoIndice = fileInd.length();
			}
			
			
			
		}
		fileInd.close();
		fileBolsaJan.close();
		System.out.println("Inserção terminada");
		
	}

	/**
	 * Imprime informações de cada linha do indice
	 * @throws Exception
	 */
	private static void imprimirHash() throws Exception{
		RandomAccessFile fileInd = new RandomAccessFile("IndicePrincipal.dat","r");
		Indice i = new Indice();
		int j=0;
		while(fileInd.getFilePointer() < fileInd.length()) {
			System.out.println(fileInd.getFilePointer());
			i.leElemento(fileInd);
			System.out.println(i);
			j++;
			
			
		}
		fileInd.close();
		
		
	}
	
	public static void main(String[] args) throws Exception {
			
			criaArquivoIndice();
			incluiIndice();
			
			
	}

}
