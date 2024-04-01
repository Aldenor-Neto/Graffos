package kruskal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Kruskal {
    int V; // número de vértices
    List<Aresta> arestas;

    Kruskal(int v) {
        V = v;
        arestas = new ArrayList<>();
    }

    void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    int encontrar(int subset[], int i) {
        if (i >= 0 && i < subset.length) { // Verificando se i está dentro dos limites do array
            if (subset[i] == -1)
                return i;
            return encontrar(subset, subset[i]);
        }
        return -1; // Retorna -1 se o índice estiver fora dos limites
    }

    void unir(int subset[], int x, int y) {
        int xroot = encontrar(subset, x);
        int yroot = encontrar(subset, y);
        subset[xroot] = yroot;
    }

    void kruskal() {
        List<Aresta> resultado = new ArrayList<>();
        int[] subset = new int[V + 1];
        for (int i = 0; i <= V; i++)
            subset[i] = -1;

        Collections.sort(arestas, Comparator.comparingInt(a -> a.peso));

        int i = 0, e = 0;

        while (e < V - 1 && i < arestas.size()) {
            Aresta proxima_aresta = arestas.get(i++);
            int x = encontrar(subset, proxima_aresta.origem);
            int y = encontrar(subset, proxima_aresta.destino);

            if (x != y) {
                resultado.add(proxima_aresta);
                unir(subset, x, y);
                e++;
            }
        }

        System.out.println("Arestas na Árvore de Extensão Mínima (Kruskal):");
        for (Aresta aresta : resultado) {
            System.out.println(aresta.origem + " - " + aresta.destino + ": " + aresta.peso);
        }
    }
}