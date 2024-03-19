import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RemoveLista {
public static void exibir(ArrayList<Integer> lista) {
    for(Integer item : lista)
    {
        System.out.println(item);
    }

} 
public static void main(String a[]) {

ArrayList<Integer> lista = new ArrayList<Integer>();

int  valor, qtdNumeros=10;

    Scanner teclado = new Scanner (System.in);
    Random gerador = new Random();
    for (int i = 0; i < (qtdNumeros); i++)
    {
        valor = gerador.nextInt(100);

        if (!lista.contains(valor)){
            lista.add(valor);
            lista.sort(null);

        }
}

System.out.println("Tamanho da lista: " + lista.size());
exibir(lista);

System.out.println("Digite um valor para exclusão: ");
valor = teclado.nextInt();

lista.remove((Integer)valor);
System.out.println("Tamanho da lista apos remoção: " + lista.size());
exibir(lista);

    }
}