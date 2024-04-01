#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>

int gerarNumeroAleatorio(int min, int max) {
    return min + rand() % (max - min + 1);
}

std::vector<int> generateRandomList(int N, int min, int max) {
    std::vector<int> list;
    for (int i = 0; i < N; ++i) {
        list.push_back(gerarNumeroAleatorio(min, max));
    }
    return list;
}

void displayList(const std::vector<int>& list) {
    for (int num : list) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

void intersection(const std::vector<int>& list1, const std::vector<int>& list2) {
    std::vector<int> common;
    for (int num : list1) {
        if (std::find(list2.begin(), list2.end(), num) != list2.end()) {
            common.push_back(num);
        }
    }

    std::cout << "Números que aparecem nas duas listas: ";
    for (int num : common) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

void uniqueNumbers(const std::vector<int>& list1, const std::vector<int>& list2) {
    std::vector<int> unique1, unique2;
    
    for (int num : list1) {
        if (std::find(list2.begin(), list2.end(), num) == list2.end() &&
            std::find(unique1.begin(), unique1.end(), num) == unique1.end()) {
            unique1.push_back(num);
        }
    }

    for (int num : list2) {
        if (std::find(list1.begin(), list1.end(), num) == list1.end() &&
            std::find(unique2.begin(), unique2.end(), num) == unique2.end()) {
            unique2.push_back(num);
        }
    }

    std::cout << "Números que aparecem somente na primeira lista: ";
    displayList(unique1);
    std::cout << "Números que aparecem somente na segunda lista: ";
    displayList(unique2);
}

int main() {
    srand(static_cast<unsigned int>(time(nullptr)));

    int N;
    std::cout << "Digite o tamanho das listas: ";
    std::cin >> N;

    // Gerando as duas listas
    std::vector<int> lista1 = generateRandomList(N, 1, 100);
    std::vector<int> lista2 = generateRandomList(N, 1, 100);

    std::cout << "Conteúdo da primeira lista: ";
    displayList(lista1);
    std::cout << "Conteúdo da segunda lista: ";
    displayList(lista2);

    intersection(lista1, lista2);
    uniqueNumbers(lista1, lista2);

    return 0;
}
