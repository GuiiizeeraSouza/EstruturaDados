#include <iostream>
#include <stack>
#include <cstdlib>
#include <ctime>
#include <locale>

using namespace std;

void generateRandomNumbers(stack<int> &numberStack, int N) {
    srand(time(nullptr)); 

    for (int i = 0; i < N; ++i) {
        int randomNumber = rand() % 10 + 1;
        cout << "Número gerado: " << randomNumber << endl;

        if (randomNumber % 2 == 0) {
            cout << "Número par inserido na pilha: " << randomNumber << endl;
            numberStack.push(randomNumber);
        } else {
            if (!numberStack.empty()) {
                cout << "Número ímpar encontrado, removendo um par do topo da pilha." << endl;
                numberStack.pop();
            } else {
                cout << "Número ímpar encontrado, mas a pilha está vazia. Nenhum par para remover." << endl;
            }
        }
    }
}

int main() {
    
  setlocale(LC_ALL, "portuguese");  

    stack<int> numberStack;
    int N;

    cout << "Digite a quantidade de números aleatórios a serem gerados: ";
    cin >> N;

    generateRandomNumbers(numberStack, N);

    cout << "Conteúdo final da pilha:" << endl;
    while (!numberStack.empty()) {
        cout << numberStack.top() << " ";
        numberStack.pop();
    }
    cout << endl;

    return 0;
}
