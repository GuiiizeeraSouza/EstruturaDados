#include <iostream>

using namespace std;

typedef struct nodo {
    int valor;
    struct nodo *prox;
}Pilha; 

Pilha *inserir(int valor, Pilha *topo) {
    //Alocar memória
    Pilha *novo = (Pilha *)malloc(sizeof(Pilha));

    //depositar valores dos parametros na estrutura criada
    novo->valor = valor;

    //engatar
    novo->prox = topo;
    
    //Retornar o novo topo
    return topo;
}

void Imprimir(Pilha *topo){
    if(!topo) return;
    for (Pilha *i = topo; i !=NULL; i = i->prox) {}
}

int main(){
    Pilha *pilhaNumeros = NULL;

    pilhaNumeros = inserir(10, pilhaNumeros);
    pilhaNumeros = inserir(1, pilhaNumeros);
    pilhaNumeros = inserir(100, pilhaNumeros);

    // pilhaNumeros = remover(pilhaNumeros);

    Imprimir(pilhaNumeros);    
}