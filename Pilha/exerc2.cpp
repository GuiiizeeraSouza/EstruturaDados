#include <iostream>
#include <fstream>
#include <stack>
#include <cstdlib>
#include <ctime>

using namespace std;

// Função para gerar números aleatórios e escrevê-los em um arquivo
void generateRandomNumbersToFile(const string& filename, int N) {
    ofstream file(filename);

    if (!file.is_open()) {
        cerr << "Erro ao abrir o arquivo." << endl;
        return;
    }

    srand(time(nullptr)); // Seed para geração de números aleatórios

    for (int i = 0; i < N; ++i) {
        int randomNumber = rand() % 100 + 1; // Gera um número aleatório entre 1 e 100
        file << randomNumber << endl;
    }

    file.close();
}

// Função para ler números de um arquivo e inseri-los em uma pilha
void readNumbersFromFileAndPushToStack(const string& filename, stack<int>& numberStack) {
    ifstream file(filename);

    if (!file.is_open()) {
        cerr << "Erro ao abrir o arquivo." << endl;
        return;
    }

    int number;
    while (file >> number) {
        numberStack.push(number);
    }

    file.close();
}

int main() {
    const string filename = "numeros.txt";
    int N;

    cout << "Digite a quantidade de números aleatórios a serem gerados e escritos no arquivo: ";
    cin >> N;

    generateRandomNumbersToFile(filename, N);

    stack<int> numberStack;
    readNumbersFromFileAndPushToStack(filename, numberStack);

    if (!numberStack.empty()) {
        cout << "Elemento no topo da pilha: " << numberStack.top() << endl;
        cout << "Tamanho da pilha: " << numberStack.size() << endl;
    } else {
        cout << "A pilha está vazia." << endl;
    }

    return 0;
}
