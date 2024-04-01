package kruskal;
public class App {
    public static void main(String[] args) {
        Kruskal grafo = new Kruskal(7);

        grafo.adicionarAresta(1, 3, 3);
        grafo.adicionarAresta(1, 2, 5);
        grafo.adicionarAresta(2, 3, 4);
        grafo.adicionarAresta(3, 4, 5);
        grafo.adicionarAresta(2, 4, 6);
        grafo.adicionarAresta(3, 6, 6);
        grafo.adicionarAresta(2, 5, 2);
        grafo.adicionarAresta(4, 6, 6);
        grafo.adicionarAresta(4, 5, 6);
        grafo.adicionarAresta(5, 6, 3);
        grafo.adicionarAresta(6, 7, 4);
        grafo.adicionarAresta(5, 7, 5);

        grafo.kruskal();
    }
}