import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class Indice {
		private long chave;
		private long posicao;
		private long proximo;
		
		public Indice() {
			
		}
		public Indice(long key,long pos,long next) {
			this.chave=key;
			this.posicao=pos;
			this.proximo=next;
		}
		
		public void leElemento(DataInput din) throws IOException {
			this.chave = din.readLong();
			this.posicao = din.readLong();
			this.proximo = din.readLong();
		}
		public void escreveElemento(DataOutput dout) throws IOException{
			dout.writeLong(this.chave);
			dout.writeLong(this.posicao);
			dout.writeLong(this.proximo);
		}
		
		
		public long getChave() {
			return chave;
		}
		public void setChave(long chave) {
			this.chave = chave;
		}
		public long getPosicao() {
			return posicao;
		}
		public void setPosicao(long posicao) {
			this.posicao = posicao;
		}
		public long getProximo() {
			return proximo;
		}
		public void setProximo(long proximo) {
			this.proximo = proximo;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (chave ^ (chave >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Indice other = (Indice) obj;
			if (chave != other.chave)
				return false;
			if (posicao != other.posicao)
				return false;
			if (proximo != other.proximo)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "chave: " +this.chave +" pos:" +this.posicao + "  prox:" + this.proximo;
		}
		
}
