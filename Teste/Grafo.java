package Teste;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Grafo {
    public int matrizAdjacencia[][];
    public ArrayList<String> vertices;
    public int qtdVertices;
    public int qtdArestas;

    public Grafo(String arquivoCidades) {
        this.vertices = new ArrayList<>();
        lerVerticesDoCSV(arquivoCidades);
        this.qtdVertices = vertices.size();
        this.qtdArestas = 0;
        this.matrizAdjacencia = new int[this.qtdVertices][this.qtdVertices];
        inicializarMatrizAdjacencia();
        lerArestasDoCSV(arquivoCidades);
    }

    private void lerVerticesDoCSV(String arquivoCidades) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCidades))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("@");
                if (!vertices.contains(partes[0])) {
                    vertices.add(partes[0]);
                }
                if (!vertices.contains(partes[1])) {
                    vertices.add(partes[1]);
                }
            }
            vertices.sort(null); // Ordena os vértices alfabeticamente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inicializarMatrizAdjacencia() {
        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.matrizAdjacencia[i][j] = 0;
            }
        }
    }

    private void lerArestasDoCSV(String arquivoCidades) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCidades))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("@");
                inserirArestaSimetrica(partes[0], partes[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirArestaSimetrica(String origem, String destino) {
        int indiceOrigem = this.vertices.indexOf(origem);
        int indiceDestino = this.vertices.indexOf(destino);
        if (origem.equalsIgnoreCase(destino) || indiceOrigem == -1 || indiceDestino == -1) {
            return;
        }

        if (this.matrizAdjacencia[indiceOrigem][indiceDestino] == 0) {
            this.matrizAdjacencia[indiceOrigem][indiceDestino] = 1;
            this.qtdArestas++;
        }
        if (this.matrizAdjacencia[indiceDestino][indiceOrigem] == 0) {
            this.matrizAdjacencia[indiceDestino][indiceOrigem] = 1;
            this.qtdArestas++;
        }
    }

    public void show() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(this.vertices.get(i) + "\t\t\t");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matrizAdjacencia[i][j] != 0) {
                    System.out.print(this.vertices.get(j) + "\t\t\t");
                }
            }
            System.out.println();
        }
    }

    public int mostrarGrau(String cidade) {
        int indice = this.vertices.indexOf(cidade);
        if (indice == -1) return -27;
        int qtd = 0;
        for (int i = 0; i < this.qtdVertices; i++) {
            if (this.matrizAdjacencia[indice][i] != 0) {
                qtd++;
            }
            if (this.matrizAdjacencia[i][indice] != 0) {
                qtd++;
            }
        }
        return qtd;
    }
}
