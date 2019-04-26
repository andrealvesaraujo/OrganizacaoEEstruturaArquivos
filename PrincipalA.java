import java.io.RandomAccessFile;

public class PrincipalA {
		public static void main(String args[]) throws Exception{
			//Busca binaria
			RandomAccessFile f = new RandomAccessFile("Arquivo.dat", "r");//Ordenado por cpf
			
			long ultimo=f.length()/131 - 1;
			long inicio=0;
			long meio;
			boolean encontrado=false;
			while(inicio<=ultimo) {
				Registro r = new Registro();
				meio=(ultimo+inicio)/2;
				f.seek(meio*131);
				r.leRegistro(f);
				
				String cpfDoMeio=r.getCpf();
				if(args[0].compareTo(cpfDoMeio) == 0) {
					System.out.println("Cpf :" + r.getCpf());
					System.out.println("Nome :" + r.getNome());
					System.out.println("Email :" + r.getEmail());
					System.out.println("telefone :" + r.getTelefone());
					encontrado=true;
					
				}else if(args[0].compareTo(cpfDoMeio) < 0){
					ultimo = meio -1;
					
				}else {
					inicio = inicio +1;
				}
				
			}
			if(!encontrado) {
				System.out.println("Cpf não encontrado");
			}
			f.close();
			
		}
}
