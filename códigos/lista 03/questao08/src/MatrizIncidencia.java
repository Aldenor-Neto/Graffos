import java.util.ArrayList;
import java.util.List;

public class MatrizIncidencia {

    public int numNos;
    List<Aresta> arestas;

    MatrizIncidencia(int numNos) {
        this.numNos = numNos;
        arestas = new ArrayList<>();
    }

    public void addAresta(int origem, int destino) {
        Aresta newAresta = new Aresta(origem - 1, destino - 1);
        arestas.add(newAresta);
    }

    public void geraMatriz() {
        int[][] matriz = new int[numNos][arestas.size()];

        for (int i = 0; i < arestas.size(); i++) {
            matriz[arestas.get(i).origem][i] = 1;
            matriz[arestas.get(i).destino][i] = -1;

            if (arestas.get(i).origem == arestas.get(i).destino) {
                matriz[arestas.get(i).origem][i] = 2;
            }
        }
        printMatriz(matriz);
        contagraus(matriz);
    }

    public void printMatriz(int[][] matriz) {
        System.out.println("Matriz de incidência:");
        for (int i = 0; i < numNos; i++) {
            for (int j = 0; j < arestas.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void contagraus(int[][] matriz) {
        System.out.println("quantidade de graus:");
        for (int i = 0; i < numNos; i++) {
            int entrada = 0;
            int saida = 0;

            for (int j = 0; j < arestas.size(); j++) {
                if (matriz[i][j] == 1) {
                    saida++;
                }
                if (matriz[i][j] == -1) {
                    entrada++;
                }
                if (matriz[i][j] == 2) {
                    saida++;
                    entrada++;
                }
            }
            System.out.println(
                    "Nó " + (i + 1) + " : Graus de entrada = " + entrada + " ; Graus de saída = " + saida + ".");
        }
    }
}
