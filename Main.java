import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		
		RandomAccessFile f = new RandomAccessFile("cep.dat", "r");//Permite voltar o arquivo.Permite dar seek.
		Endereco e = new Endereco();
		
		f.seek(390560L*300);//Numero da linha onde esta o cep-->Le o cep do terminal e procura sua linha
		while( f.getFilePointer() < f.length() ) // para Detectar EOF
		{
			System.out.println(f.getFilePointer());	//Onde estou no meu arquivo
			e.leEndereco(f);
			System.out.println(e.getLogradouro());
			System.out.println(e.getBairro());
			System.out.println(e.getCidade());
			System.out.println(e.getEstado());
			System.out.println(e.getSigla());
			System.out.println(e.getCep());
			break;
		}
		
		
		f.close();
	}

}
