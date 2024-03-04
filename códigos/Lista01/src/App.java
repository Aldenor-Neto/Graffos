import java.util.Scanner;

public class App {

    // Questão 08
    public static int[][] grafoBiPartido() {
        Scanner input = new Scanner(System.in);
        int m;
        int n;

        do {
            System.out.println("qual a quantidade de nós que possui na parte M do grafo, informe valor entre 2 e 20.");
            m = input.nextInt();

            if (m < 2 || m > 20) {
                System.out.println("O valor de M deve estar entre 2 e 20");
            }
        } while (m < 2 || m > 20);

        do {
            System.out.println("qual a quantidade de nós que possui na parte N do grafo, informe valor entre 2 e 20.");
            n = input.nextInt();

            if (n < 2 || n > 20) {
                System.out.println("O valor de N deve estar entre 2 e 20");
            }
        } while (n < 2 || n > 20);

        int[][] biPartido = new int[m + n][m + n];

        for (int i = 0; i < m; i++) {
            for (int j = m; j < m + n; j++) {
                biPartido[i][j] = 1;
            }
        }

        for (int i = 0; i < m + n; i++) {
            for (int j = 0; j < m + n; j++) {
                System.out.print(biPartido[i][j] + " ");
            }
            System.out.println();
        }

        return biPartido;
    }

    // Questão 09
    public static int[] contaGrausGrafos(int[][] matriz) {
        int tamanho = matriz[0].length;
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (matriz[i][j] == 1) {
                    vetor[i]++;
                    vetor[j]++;
                    if (i == j) {
                        vetor[i]--;
                    }
                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        return vetor;
    }

    public static void main(String[] args) {

        int[][] matriz = grafoBiPartido();
        System.out.println();
        int[] graus = contaGrausGrafos(matriz);

    }
}
