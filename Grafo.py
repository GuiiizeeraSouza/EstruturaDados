class Grafo:
    def __init__(self, vertices):
        self.vertices = vertices
        self.qtdVertices = len(vertices)
        self.qtdArestas = 0
        self.matrizAdjacencia = [[0] * self.qtdVertices for _ in range(self.qtdVertices)]

    def inserirArestaSimetrica(self, origem, destino):
        indiceOrigem = self.vertices.index(origem)
        indiceDestino = self.vertices.index(destino)
        
        if origem.lower() == destino.lower() or indiceOrigem == -1 or indiceDestino == -1:
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

    cidade = "Itaara"
    print(f"Grau da cidade de {cidade}: {grafo_rs.mostrarGrau(cidade)}")
