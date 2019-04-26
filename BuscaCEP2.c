#include <stdio.h>

#pragma pack(1)

typedef struct _Endereco Endereco;

struct _Endereco
{
	char logradouro[72];
	char bairro[72];
	char cidade[72];
	char uf[72];
	char sigla[2];
	char cep[8];
	char lixo[2];
};
//Tem exercicio sobre unidade federativa
int main(int argc, char**argv)
{
	FILE *f;
	Endereco e;
	int qt;
	long posicao, primeiro, ultimo, meio;

	if(argc != 2)
	{
		fprintf(stderr, "USO: %s [CEP]", argv[0]);
		return 1;
	}
	f = fopen("cep_ordenado.dat","r");
	fseek(f,0,SEEK_END);//Seek_end e Seek_Set(Inicio do arquivo) e Seek_Cur(Onde estou).Mexe com a cabeça de leitura
	posicao = ftell(f);//tamanho do arquivo em byte
	rewind(f);//Volta a cabeça de leitura pro inicio equivalente a fseek(f,0,Seek_Set)
	printf("Tamanho do Arquivo: %ld\n", posicao);
	printf("Tamanho do Registro: %ld\n", sizeof(Endereco));
	printf("Tamanho do Arquivo em Registros: %ld\n", posicao/sizeof(Endereco));
	primeiro = 0;//Posição do Primeiro registro
	ultimo = (posicao/sizeof(Endereco))-1;//Posição do ultimo registro
	meio = (primeiro+ultimo)/2;
	fread(&e,sizeof(Endereco),1,f);
	printf("PRIMEIRO:\n%.72s\n%.72s\n%.72s\n%.72s\n%.2s\n%.8s\n",e.logradouro,e.bairro,e.cidade,e.uf,e.sigla,e.cep);
	printf("Posicao Atual: %ld\n", ftell(f));
	fseek(f, meio * sizeof(Endereco), SEEK_SET);
	printf("Posicao Atual: %ld\n", ftell(f));
	fread(&e,sizeof(Endereco),1,f);
	printf("MEIO:\n%.72s\n%.72s\n%.72s\n%.72s\n%.2s\n%.8s\n",e.logradouro,e.bairro,e.cidade,e.uf,e.sigla,e.cep);
	printf("Posicao Atual: %ld\n", ftell(f));
	fseek(f, ultimo * sizeof(Endereco), SEEK_SET);
	printf("Posicao Atual: %ld\n", ftell(f));
	fread(&e,sizeof(Endereco),1,f);
	printf("ULTIMO:\n%.72s\n%.72s\n%.72s\n%.72s\n%.2s\n%.8s\n",e.logradouro,e.bairro,e.cidade,e.uf,e.sigla,e.cep);
	printf("Posicao Atual: %ld\n", ftell(f));

	rewind(f);
	qt = fread(&e,sizeof(Endereco),1,f);

	while(qt > 0)
	{
		if(strncmp(argv[1],e.cep,8)==0)
		{
			printf("%.72s\n%.72s\n%.72s\n%.72s\n%.2s\n%.8s\n",e.logradouro,e.bairro,e.cidade,e.uf,e.sigla,e.cep);
			break;
		}
		qt = fread(&e,1,sizeof(Endereco),f);
	}
	//Fazer busca binaria do cep.ordenado e botar contador que deve ser no final 19
	fclose(f);
}

