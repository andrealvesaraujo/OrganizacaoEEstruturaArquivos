#include <stdio.h>
#include <string.h>
typedef struct _Pessoa Pessoa;

struct _Pessoa{

    int idade;
    float peso;
    float altura;
    char nome[40];
    char telefone[20];
};

int main(int argc,char** argv)
{
    Pessoa p;
    FILE *f = fopen("dados.csv","w");

    p.idade =44;
    p.peso=100;
    p.altura = 1.84;
    strcpy(p.nome,"Renato");
    strcpy(p.telefone,"190");

    fprintf(f,"idade,peso,altura,nome,telefone\n");
    fprintf(f,"%d,%f,%f,%s,%s\n",p.idade,p.peso,p.altura,p.nome,p.telefone);

    fclose(f);
    return 0;
}