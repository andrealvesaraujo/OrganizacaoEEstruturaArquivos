package principal;

import java.io.*;


class Pessoa
{
	int idade;
	float peso;
	float altura;
	String nome;
	String telefone;
}

public class GeraCSV
{
	
	public static void main(String args[]) throws IOException
	{

		FileOutputStream fout = new FileOutputStream("dados2.csv");
		PrintWriter pw = new PrintWriter(fout);

		Pessoa p = new Pessoa();
		p.idade = 44;
		p.peso = 100.0f;
		p.altura = 1.84f;
		p.nome = "Renato";
		p.telefone = "190";


		pw.println("idade,peso,altura,nome,telefone");
		pw.println(p.idade + "," + p.peso + "," + p.altura + "," + p.nome + "," + p.telefone);

		pw.close();
		fout.close();

	}

}