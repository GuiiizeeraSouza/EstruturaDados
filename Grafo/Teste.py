import networkx as nx
import matplotlib.pyplot as plt
import csv

class Grafo:
    def __init__(self, vertices):
        self.vertices = vertices
        self.qtdVertices = len(vertices)
        self.qtdArestas = 0
        self.matrizAdjacencia = [[0] * self.qtdVertices for _ in range(self.qtdVertices)]

    def inserirArestaSimetrica(self, origem, destino):
        indiceOrigem = self.vertices.index(origem)
        indiceDestino = self.vertices.index(destino)
        if origem == destino or indiceOrigem == -1 or indiceDestino == -1:
            return
        
        if self.matrizAdjacencia[indiceOrigem][indiceDestino] == 0:
            self.matrizAdjacencia[indiceOrigem][indiceDestino] = 1
            self.qtdArestas += 1
        
        if self.matrizAdjacencia[indiceDestino][indiceOrigem] == 0:
            self.matrizAdjacencia[indiceDestino][indiceOrigem] = 1
            self.qtdArestas += 1

    def show(self):
        for i in range(self.qtdVertices):
            print(self.vertices[i], end='\t\t\t')
            for j in range(self.qtdVertices):
                if self.matrizAdjacencia[i][j] != 0:
                    print(self.vertices[j], end='\t\t\t')
            print()

    def mostrarGrau(self, cidade):
        indice = self.vertices.index(cidade)
        if indice == -1:
            return -27
        
        qtd = 0
        for i in range(self.qtdVertices):
            if self.matrizAdjacencia[indice][i] != 0:
                qtd += 1
            if self.matrizAdjacencia[i][indice] != 0:
                qtd += 1
        
        return qtd

    def saveToCSV(self, filename):
        with open(filename, 'w', newline='') as csvfile:
            writer = csv.writer(csvfile)
            
            writer.writerow(["Vertices"] + self.vertices)
            
            for i in range(self.qtdVertices):
                row = [self.vertices[i]] + [str(self.matrizAdjacencia[i][j]) for j in range(self.qtdVertices)]
                writer.writerow(row)

    def visualizarGrafo(self):
        G = nx.Graph()

        for i in range(self.qtdVertices):
            G.add_node(self.vertices[i])

        for i in range(self.qtdVertices):
            for j in range(i + 1, self.qtdVertices):
                if self.matrizAdjacencia[i][j] != 0:
                    G.add_edge(self.vertices[i], self.vertices[j])

        pos = nx.spring_layout(G) 

        plt.figure(figsize=(10, 8))
        nx.draw_networkx_nodes(G, pos, node_size=700, node_color='skyblue')
        nx.draw_networkx_edges(G, pos, width=2, alpha=0.5, edge_color='b')
        nx.draw_networkx_labels(G, pos, font_size=12, font_family='sans-serif')

        plt.title("Visualização do Grafo")
        plt.axis('off') 
        plt.show()

if __name__ == "__main__":
    cidades = [
        "Sao Pedro", "Santa Maria", "Agudo", "Santa Cruz", "Itaara",
        "Sao Martinho", "Julio de Castilhos", "Cruz Alta", "Soledade",
        "Lajeado", "Porto Alegre"
    ]

    cidades.sort()

    grafo_rs = Grafo(cidades)
    grafo_rs.inserirArestaSimetrica("Sao Pedro", "Santa Maria")
    grafo_rs.inserirArestaSimetrica("Santa Maria", "Agudo")
    grafo_rs.inserirArestaSimetrica("Agudo", "Santa Cruz")
    grafo_rs.inserirArestaSimetrica("Santa Cruz", "Porto Alegre")
    grafo_rs.inserirArestaSimetrica("Porto Alegre", "Lajeado")
    grafo_rs.inserirArestaSimetrica("Lajeado", "Soledade")
    grafo_rs.inserirArestaSimetrica("Soledade", "Cruz Alta")
    grafo_rs.inserirArestaSimetrica("Cruz Alta", "Julio de Castilhos")
    grafo_rs.inserirArestaSimetrica("Julio de Castilhos", "Itaara")
    grafo_rs.inserirArestaSimetrica("Itaara", "Sao Martinho")
    grafo_rs.inserirArestaSimetrica("Itaara", "Santa Maria")

    grafo_rs.show()

    grafo_rs.visualizarGrafo()
