import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private int numVertices;
    private List<List<Aresta>> adj;

    public Dijkstra(int numVertices) {
        this.numVertices = numVertices;
        adj = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++)
            adj.add(new ArrayList<>());
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        Aresta aresta = new Aresta(origem - 1, destino - 1, peso);
        adj.get(origem - 1).add(aresta);
    }

    public void encontrarCaminhoMaisCurto(int origem, int destino) {
        origem--;
        destino--;

        PriorityQueue<Integer> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int[] distancia = new int[numVertices];
        int[] antecessor = new int[numVertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;
        fila.offer(origem);

        while (!fila.isEmpty()) {
            int u = fila.poll();
            for (Aresta aresta : adj.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;
                if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                    antecessor[v] = u;
                    fila.offer(v);
                }
            }
        }

        List<Integer> caminho = new ArrayList<>();
        int atual = destino;
        while (atual != origem) {
            caminho.add(atual + 1);
            atual = antecessor[atual];
        }
        caminho.add(origem + 1);
        Collections.reverse(caminho);

        System.out.print("Caminho mais curto de " + (origem + 1) + " para " + (destino + 1) + ": ");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i));
            if (i < caminho.size() - 1)
                System.out.print(" -> ");
        }
        System.out.println("\nDistância mínima: " + distancia[destino]);
    }
}
