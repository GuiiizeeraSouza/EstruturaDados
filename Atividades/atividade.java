import java.util.*;
public class atividade {
    
    public static void main(String[] args) {
        int N = 10; // Número de listas
        int M = 5;  // Tamanho das listas
        
        List<List<Integer>> listaGenerica = new ArrayList<>();

        // Gerar N listas de tamanho M com números aleatórios
        for (int i = 0; i < N; i++) {
            List<Integer> lista = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                lista.add((int)(Math.random() * 10)); // Números aleatórios de 0 a 9
            }
            listaGenerica.add(lista);
        }

        // Mostrar os conteúdos das listas
        for (int i = 0; i < N; i++) {
            System.out.println("Lista " + i + ": " + listaGenerica.get(i));
        }

        // Mostrar os números que aparecem nas N listas
        Set<Integer> numerosComuns = new HashSet<>(listaGenerica.get(0));
        for (int i = 1; i < N; i++) {
            numerosComuns.retainAll(listaGenerica.get(i));
        }
        System.out.println("Números que aparecem em todas as listas: " + numerosComuns);

        // Mostrar os números que aparecem somente em uma das listas
        Set<Integer> numerosUnicos = new HashSet<>();
        Set<Integer> numerosRepetidos = new HashSet<>();
        for (List<Integer> lista : listaGenerica) {
            for (Integer numero : lista) {
                if (!numerosUnicos.add(numero)) {
                    numerosRepetidos.add(numero);
                }
            }
        }
        numerosUnicos.removeAll(numerosRepetidos);
        System.out.println("Números que aparecem somente em uma das listas: " + numerosUnicos);
    }
}

