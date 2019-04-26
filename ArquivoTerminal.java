
import java.io.*;

public class ArquivoTerminal {
	
	public static final int TAMANHO=4096; 
	public static void main(String[] args) {
		
		InputStream entrada =null;
		byte buffer[] = new byte[TAMANHO];
		
		int qtd;
		
		if(args.length != 1){
			System.err.println("Erro na chamada do comando.");
			System.err.println("Uso: java ArquivoTerminal [Arquivo]");
			System.exit(1);
		}
		
		try {
			
			entrada = new FileInputStream(args[0]);
			
			
		}catch(IOException e){
			System.err.println("Arquivo " + args[0] + " não pode ser aberto para leitura\n");
			System.exit(1);
		}
		
		try {
			qtd=entrada.read(buffer);
			while(qtd>0) {	
				for(int i=0;i<TAMANHO;i++) {
					System.out.print((char) buffer[i]);
					
				}
				qtd=entrada.read(buffer);
				System.out.println("Acabou");
			}
			try{
				entrada.close();
			}catch(IOException e) {
				System.err.println("Aquivo não pode ser fechado");
				System.exit(2);
				
			}
		}catch(IOException e) {
			System.err.println("Erro ao mostrar o arquivo no terminal");
		}
		
		
		
		
	}
}
