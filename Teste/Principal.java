package Teste;
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        String arquivoCidades = "cidades.csv";
        Grafo grafo_rs = new Grafo(arquivoCidades);
        grafo_rs.show();
    }
}
