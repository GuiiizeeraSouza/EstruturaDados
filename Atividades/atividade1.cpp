#include <iostream>
#include <vector>
#include <unordered_set>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;


vector<int> gerarLista(int tamanho)
{
    vector<int> lista;
    for (int i = 0; i < tamanho; ++i)
    {
        lista.push_back(rand() % 100); 
    }
    return lista;
}


void mostrarLista(const vector<int> &lista)
{
    for (int num : lista)
    {
        cout << num << " ";
    }
    cout << endl;
}

int main()
{
    srand(time(nullptr));

    int numListas, tamanhoLista;
    cout << "Quantas listas voce deseja gerar? ";
    cin >> numListas;
    cout << "Qual eh o tamanho das listas? ";
    cin >> tamanhoLista;

    vector<vector<int>> listas(numListas);

  
    cout << "Listas geradas:" << endl;
    for (int i = 0; i < numListas; ++i)
    {
        listas[i] = gerarLista(tamanhoLista);
        cout << "Lista " << i + 1 << ": ";
        mostrarLista(listas[i]);
    }

    // Comparar as listas
    unordered_set<int> numerosRepetidos;
    unordered_set<int> todosNumeros;
    for (int i = 0; i < numListas; ++i)
    {
        for (int num : listas[i])
        {
            if (todosNumeros.count(num) > 0)
            {
                numerosRepetidos.insert(num);
            }
            else
            {
                todosNumeros.insert(num);
            }
        }
    }

    cout << "\nNumeros que se repetem em todas as listas:" << endl;
    if (numerosRepetidos.empty())
    {
        cout << "Nenhum numero se repete em todas as listas." << endl;
    }
    else
    {
        for (int num : numerosRepetidos)
        {
            cout << num << " ";
        }
        cout << endl;
    }

    cout << "\nNumeros que nao se repetem em todas as listas:" << endl;
    bool temNaoRepetido = false;
    for (int num : todosNumeros)
    {
        if (numerosRepetidos.find(num) == numerosRepetidos.end())
        {
            cout << num << " ";
            temNaoRepetido = true;
        }
    }
    if (!temNaoRepetido)
    {
        cout << "Todos os numeros se repetem em pelo menos uma lista." << endl;
    }
    cout << endl;

    return 0;
}
