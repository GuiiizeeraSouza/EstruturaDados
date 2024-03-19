import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class atividades {
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        int N = 10;

        // Criar duas listas de números aleatórios
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            lista1.add(generateRandomNumber(1, 20)); 
            lista2.add(generateRandomNumber(1, 20));
        }

        // Mostrar conteúdo das listas
        System.out.println("Conteúdo da primeira lista:");
        System.out.println(lista1);
        System.out.println("\nConteúdo da segunda lista:");
        System.out.println(lista2);
        System.out.println();

        // Encontrar e mostrar os números que aparecem nas duas listas
        System.out.println("Números que aparecem em ambas as listas:");
        Set<Integer> intersection = new HashSet<>(lista1);
        intersection.retainAll(lista2);
        System.out.println(intersection);
        System.out.println();

        // Encontrar e mostrar os números que aparecem somente em uma das listas
        System.out.println("Números que aparecem somente em uma das listas:");
        Set<Integer> symmetricDifference = new HashSet<>(lista1);
        symmetricDifference.addAll(lista2);
        Set<Integer> temp = new HashSet<>(lista1);
        temp.retainAll(lista2);
        symmetricDifference.removeAll(temp);
        System.out.println(symmetricDifference);
    }
}
