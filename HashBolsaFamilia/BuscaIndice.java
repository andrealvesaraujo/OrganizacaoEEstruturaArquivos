import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class BuscaIndice {

	private static final int TAMANHO_HASH = 17000023;
	
	private static long h(String nis)
	{
		return Math.abs(nis.hashCode()) % TAMANHO_HASH;
	}
	
	private static boolean buscar(String nis) throws Exception
	{
		boolean encontrou;
		long posicao;
		RandomAccessFile fileInd = new RandomAccessFile("IndicePrincipal.dat","r");
		RandomAccessFile fileBolsaJan = new RandomAccessFile("BolsaFamiliaJaneiro.csv","r");
		Indice i = new Indice();
		fileBolsaJan.seek(0);
		fileInd.seek(0);
		long nisProcurado = Long.valueOf(nis).longValue();
		posicao = h(nis)*24;
		while(true)
		{
			
			fileInd.seek(posicao);
			i.leElemento(fileInd);
			if(i.getChave() == nisProcurado)
			{
				encontrou=true;
				break;
			}
			else
			{
				posicao = i.getProximo();
				if(posicao == 0)
				{
					encontrou=false;
					break;
				}
			}
		}
		fileInd.close();
		fileBolsaJan.close();
		
		return encontrou;
		
	}


	private static void CriarArquivoDiferenca() throws Exception{
		String linha, nis;
        String colunas[];
        
		RandomAccessFile fileBolsaFev = new RandomAccessFile("BolsaFamiliaFevereiro.csv","r");
		//Arquivo 'diferenca' contem os elementos presentes no Arquivo de Fevereiro que não estão em Janeiro.
		RandomAccessFile resultado = new RandomAccessFile("diferenca.csv","rw");
		linha=fileBolsaFev.readLine();
		resultado.writeChars(linha);
		resultado.writeChars("\n");
		int valor=0;
		System.out.println("Criando arquivo diferenca(Feveiro-Janeiro)");
		while(fileBolsaFev.getFilePointer() < fileBolsaFev.length())
		{
			
            linha = fileBolsaFev.readLine();
            colunas = linha.split("\t");
            nis = colunas[7];
            
			
			if(!buscar(nis)) {
				resultado.writeChars(linha);
				resultado.writeChars("\n");
				valor++;
				if(valor%1000 == 0) {
					System.out.println(valor);
				}
				
				
			}
			
		}
		System.out.println("Quantidade de elementos inseridos no arquivo resultado : " + valor);
		resultado.close();
		fileBolsaFev.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		CriarArquivoDiferenca();
		
		
	}
}
