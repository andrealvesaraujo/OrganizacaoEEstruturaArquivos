import java.io.RandomAccessFile;

public class InnerJoin {
	public static void main(String[] args) throws Exception{
		RandomAccessFile a =new RandomAccessFile("outro_a.dat", "r");
		RandomAccessFile b =new RandomAccessFile("outro_b.dat", "r");
		RandomAccessFile saida =new RandomAccessFile("ArquivoInnerJoin.dat", "rw");
		//Iguais no logradouro
		System.out.println("Começou InnerJoin");
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
			if(igual) {
				ra.escreveEndereco(saida);
			}
			
		}
		System.out.println("Terminou InnerJoin");
		
		
		a.close();
		b.close();
		saida.close();
		
	}
}
