import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Registro {
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public boolean leRegistro(RandomAccessFile din) throws IOException
	{
		if(din.getFilePointer()>=din.length())
		{
			return false;
		}
		byte cpf[] = new byte[72];
		byte nome[] = new byte[72];
		byte email[] = new byte[72];
		byte telefone[] = new byte[72];
		
		din.readFully(cpf);
		din.readFully(nome);
		din.readFully(email);
		din.readFully(telefone);
		
		
		// Definie a forma como caracteres especias estão codificados.
		Charset enc = Charset.forName("ISO-8859-1");
		
		this.cpf = new String(cpf,enc);
		this.nome = new String(nome,enc);
		this.email = new String(email,enc);
		this.telefone = new String(telefone,enc);
		return true;
	}


	public void escreveRegistro(DataOutput dout) throws IOException
	{		
		// Definie a forma como caracteres especias estão codificados.
		Charset enc = Charset.forName("ISO-8859-1");
		dout.write(this.cpf.getBytes(enc));
		dout.write(this.nome.getBytes(enc));
		dout.write(this.email.getBytes(enc));
		dout.write(this.telefone.getBytes(enc));
		
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Registro) {
			Registro x = (Registro) obj;
			if(x.nome.equals(this.nome) && x.cpf.equals(this.cpf) && x.email.equals(this.email) && x.nome.equals(this.telefone)) {
				return true;
			}
		}
		return false;
	}
}
