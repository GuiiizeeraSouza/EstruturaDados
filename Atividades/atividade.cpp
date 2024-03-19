#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>

int gerarRandom(int min, int max)
{
    return rand() % (max - min + 1) + min;
}

int main()
{

    srand(time(0));

    int N;

    std::cout << "Digite o tamanho das listas: ";
    std::cin >> N;

    std::vector<int> lista1, lista2;
    for (int i = 0; i < N; i++)
    {
        lista1.push_back(gerarRandom(1, 100));
        lista2.push_back(gerarRandom(1, 100));
    }

    std::cout << "Mostrar conteudo da lista 1; \n ";
    for (int num : lista1)
    {
        std::cout << num << "\n";
    }
       std::cout << "\n\n";
    std::cout << "Mostrar conteudo da lista 2; \n ";
    for (int num : lista2)
    {
        std::cout << num << "\n";
    }
    std::cout << "\n\n";

    std::sort(lista1.begin(), lista1.end());
    std::sort(lista2.begin(), lista2.end());

    std::cout << "Numeros que aparecem em ambas as listas:";
    std::vector<int> intersect;
    std::set_intersection(lista1.begin(), lista1.end(), lista2.begin(), lista2.end(), std::back_inserter(intersect));
    for (int num : intersect)
    {
        std::cout << num << "\n";
    }
    std::cout << "\n\n";

    std::cout << "Números que aparecem somente em uma das listas:\n";
    std::vector<int> difference;
    std::set_difference(lista1.begin(), lista1.end(), lista2.begin(), lista2.end(), std::back_inserter(difference));
    for (int num : difference)
    {
        std::cout << num << " \n";
    }
    std::cout << "\n";
    
    return 1;
}