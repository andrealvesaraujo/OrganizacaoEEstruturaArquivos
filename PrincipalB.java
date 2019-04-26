import java.io.RandomAccessFile;

public class PrincipalB {
	public static void main(String[] args) throws Exception{
		RandomAccessFile f =new RandomAccessFile("Arquivo.txt", "r");
		Registro r = new Registro();
		while(f.getFilePointer() < f.length()) {
			r.leRegistro(f);
			if(r.getNome().equals(args[0])) {
				System.out.println("Cpf :" + r.getCpf());
				System.out.println("Nome :" + r.getNome());
				System.out.println("Email :" + r.getEmail());
				System.out.println("telefone :" + r.getTelefone());
			}
		}
		
		f.close();
	}
}
