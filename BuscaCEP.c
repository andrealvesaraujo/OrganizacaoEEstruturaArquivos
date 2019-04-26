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

int main(int argc, char**argv)
{
	FILE *f;
	Endereco e;
	int qt;

	if(argc != 2)
	{
		fprintf(stderr, "USO: %s [CEP]", argv[0]);
		return 1;
	}

	printf("Tamanho da Estrutura: %ld\n\n", sizeof(Endereco));
	f = fopen("cep.dat","r");
	qt = fread(&e,sizeof(Endereco),1,f);
	int c=0;
	while(qt > 0)
	{
		if(strncmp(argv[1],e.cep,8)==0)//O argumento � seu cep
		{
			printf("%.72s\n%.72s\n%.72s\n%.72s\n%.2s\n%.8s\n",e.logradouro,e.bairro,e.cidade,e.uf,e.sigla,e.cep);//Numero maximo de quantidade de bytes
			break;
		}
		qt = fread(&e,sizeof(Endereco),1,f);//Le linha por linha
		c++;
	}
    printf("valor de c %d\n",c);
	fclose(f);
	//Necessario usar o git e mandar as intru��es do readme
}

