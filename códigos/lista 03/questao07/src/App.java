public class App {
    public static void main(String[] args) throws Exception {
        int numAresta = 7; 
        Dijkstra dijkstra = new Dijkstra(numAresta);

        dijkstra.adicionarAresta(1, 3, 3);
        dijkstra.adicionarAresta(1, 2, 5);
        dijkstra.adicionarAresta(3, 4, 5);
        dijkstra.adicionarAresta(3, 6, 6);
        dijkstra.adicionarAresta(2, 5, 2);
        dijkstra.adicionarAresta(4, 6, 6);
        dijkstra.adicionarAresta(4, 6, 6);
        dijkstra.adicionarAresta(5, 6, 3);dijkstra.adicionarAresta(6, 7, 4);
        dijkstra.adicionarAresta(5, 7, 4);

        dijkstra.encontrarCaminhoMaisCurto(1, 7);
    }
}
