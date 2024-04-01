package prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import kruskal.Aresta;

public class Prim {
    int V;
    List<List<Aresta>> grafo;

    Prim(int v) {
        V = v;
        grafo = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            grafo.add(new ArrayList<>());
    }

    void adicionarAresta(int origem, int destino, int peso) {
        grafo.get(origem-1).add(new Aresta(origem-1, destino-1, peso));
        grafo.get(destino-1).add(new Aresta(destino-1, origem-1, peso)); 
    }

    void prim() {
        boolean[] visitado = new boolean[V];
        int[] pai = new int[V];
        int[] pesoMinimo = new int[V];
        for (int i = 0; i < V; i++) {
            pesoMinimo[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Aresta> filaPrioridade = new PriorityQueue<>((a, b) -> a.peso - b.peso);
        pesoMinimo[0] = 0;
        filaPrioridade.offer(new Aresta(-1, 0, 0)); // Origem fictícia

        while (!filaPrioridade.isEmpty()) {
            Aresta arestaAtual = filaPrioridade.poll();
            int u = arestaAtual.destino;

            if (visitado[u])
                continue;

            visitado[u] = true;

            for (Aresta aresta : grafo.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (!visitado[v] && peso < pesoMinimo[v]) {
                    pai[v] = u;
                    pesoMinimo[v] = peso;
                    filaPrioridade.offer(new Aresta(u, v, peso));
                }
            }
        }

        System.out.println("Arestas na Árvore de Extensão Mínima (Prim):");
        for (int i = 1; i < V; i++) {
            System.out.println((pai[i]+1) + " - " + (i+1) + ": " + pesoMinimo[i]);
        }
    }
}
