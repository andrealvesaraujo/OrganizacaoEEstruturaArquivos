import java.io.RandomAccessFile;


public class BuscaBinaria2Files
{
	public static void main(String[] args) throws Exception{
		RandomAccessFile nord =new RandomAccessFile("outro_a.dat", "r");
		RandomAccessFile ord =new RandomAccessFile("cep_ordenado_a.dat", "r");
		RandomAccessFile saida =new RandomAccessFile("BuscaBin2Files.dat", "rw");
		
		long inicio;//Armazena a primeira linha do arquivo
		long ultimo;//Armazena a ultima linha do arquivo
		long meio; // Armazena linha do meio do arquivo
		
		Endereco endO = new Endereco();
		Endereco endN = new Endereco();
		System.out.println("Começou");
		while(nord.getFilePointer() <nord.length()) {
			endN.leEndereco(nord);
			
			//Tudo busca bina
			inicio=0;
			ultimo = ord.length() / 300 - 1;
			
			meio = (inicio+ultimo)/2;
			
			
			while(inicio <=ultimo) {
				
				
				ord.seek(meio*300);
				
				endO.leEndereco(ord);
				
				String valorDoMeio = endO.getCep();
				
				
				
				if(endN.getCep().compareTo(valorDoMeio) > 0) {
					
					inicio = meio + 1;
					
				}else if(endN.getCep().compareTo(valorDoMeio) < 0){ 
					ultimo = meio -1;
				}
				else {
					endN.escreveEndereco(saida);
					
					break;
				}
				
				meio=(inicio+ultimo)/2;
				
			}
			
			ord.seek(0);
			
			
		}
		
		System.out.println("Acabou");
		
		
		
		
	}	
}
