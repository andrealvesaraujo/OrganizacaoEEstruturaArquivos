import java.io.*;

public class FazBusca {

	public static void main(String[] args) {
		
		RandomAccessFile file=null;
		long inicio=0;//Armazena a primeira linha do arquivo
		long ultimo=0;//Armazena a ultima linha do arquivo
		long meio=0; // Armazena linha do meio do arquivo
		
		int contador=0;
		boolean encontrado =false;
		
		
		if(args.length != 1)
		{

			System.err.println("Erro na chamada do comando.");
			System.err.println("Uso: java FazBusca [Valor_Do_Cep_Que_Procura]");
			System.exit(1);
		}

		try {
			file = new RandomAccessFile("cep_ordenado.dat","r");			
		}catch(IOException ex) {
			System.err.println("Erro na leitura do arquivo \n");
			System.exit(1);
		}

		//Parte da busca binaria

		try {
			Address end = new Address();
			ultimo = file.length() / 300 - 1;
			System.out.println("Cep procurado: " + args[0]);
			meio = (inicio+ultimo)/2;
			
			
			while(inicio <=ultimo) {
				contador++;
				
				file.seek(meio*300);
				
				end.lerEndereco(file);
				
				String valorDoMeio = end.getCep();
				
				/*
				 * valor.compareTo(args[0]) < 0
				 * valor.compareTo(args[0]) > 0
				 */
				
				if(args[0].compareTo(valorDoMeio) > 0) {
					
					inicio = meio + 1;
					//args[0].compareTo(valor) > 0
					//args[0].compareTo(valor) < 0
				}else if(args[0].compareTo(valorDoMeio) < 0){ 
					ultimo = meio -1;
				}
				else {
					System.out.println("Cep Encontrado");
					System.out.println(end.getLogradouro());
					System.out.println(end.getBairro());
					System.out.println(end.getCidade());
					System.out.println(end.getEstado());
					System.out.println(end.getSigla());
					System.out.println(end.getCep());
					encontrado=true;
					break;
				}
				
				meio=(inicio+ultimo)/2;
				
			}
			if(!encontrado) {
				System.out.println("O cep não existe");
			}
			System.out.println("Numero de interações : " + contador);

		}catch(IOException ex){
			System.err.println("Erro na busca binaria\n" + ex);
			
			System.exit(3);	
		}
		



		try {
			file.close();
		}catch(IOException ex) {
			System.err.println("O Arquivo cep_ordenado.dat não pode ser fechado\n");
			System.exit(3);
		}
	}
}
