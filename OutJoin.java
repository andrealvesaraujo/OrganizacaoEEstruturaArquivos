import java.io.RandomAccessFile;
public class OutJoin {
	
	public static void main(String[] args) throws Exception{
		RandomAccessFile a =new RandomAccessFile("outro_a.dat", "r");
		RandomAccessFile b =new RandomAccessFile("outro_b.dat", "r");
		RandomAccessFile saida =new RandomAccessFile("ArquivoOutJoin.dat", "rw");
		//Iguais no logradouro
		System.out.println("Começou Out Join");
		System.out.println("Começou Left Join");
		esquerda(a,b,saida);
		System.out.println("Terminou Left Join");
		System.out.println("Começou Right Join");
		direita(a,b,saida);
		System.out.println("Terminou Right Join");
		System.out.println("Terminou Out Join");
		
		a.close();
		b.close();
		saida.close();
		
	}
	public static void direita(RandomAccessFile a,RandomAccessFile b,RandomAccessFile saida) throws Exception{
		a.seek(0);
		b.seek(0);
		Endereco ra = new Endereco();
		Endereco rb = new Endereco();
		boolean igual;
		while(b.getFilePointer() < b.length()) {
			rb.leEndereco(b);
			igual=false;
			while(a.getFilePointer() < a.length()) {
				
				ra.leEndereco(a);
				if((ra.getLogradouro().equals(rb.getLogradouro()))) {
					igual=true;
					break;
				}
				
			
			}
			a.seek(0);
			if(!igual) {
				rb.escreveEndereco(saida);
			}
			
		}
	}
	
	public static void esquerda(RandomAccessFile a,RandomAccessFile b,RandomAccessFile saida) throws Exception{
		a.seek(0);
		b.seek(0);
		Endereco ra = new Endereco();
		Endereco rb = new Endereco();
		boolean igual;
		while(a.getFilePointer() < a.length()) {
			ra.leEndereco(a);
			igual=false;
			while(b.getFilePointer() < b.length()) {
				
				rb.leEndereco(b);
				if((ra.getLogradouro().equals(rb.getLogradouro()))) {
					igual=true;
					break;
				}
				
			
			}
			b.seek(0);
			if(!igual) {
				ra.escreveEndereco(saida);
			}
			
		}
	}
	
}
