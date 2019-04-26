import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Questao14 {

	public static void main(String[] args) throws Exception{
		InputStream entrada = null;
		
		if(args.length != 1) {
			System.out.println("Erro:Texto n encontrado");
			System.exit(0);
		}
		int cont=0;
		entrada = new FileInputStream("cep_a_menor.dat");
		int valor  = entrada.read();
		
		while(valor != -1) {
			
			if(valor == '\n') {
				
				cont++;
				
			}
			valor=entrada.read();
		}
		System.out.println(cont);
		entrada.close();
	}
}
