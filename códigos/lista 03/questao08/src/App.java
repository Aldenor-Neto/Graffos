public class App {
    public static void main(String[] args) throws Exception {

        MatrizIncidencia matrizIncidencia = new MatrizIncidencia(6);

        matrizIncidencia.addAresta(1, 3);
        matrizIncidencia.addAresta(1, 2);
        matrizIncidencia.addAresta(2, 5);
        matrizIncidencia.addAresta(2, 4);
        matrizIncidencia.addAresta(3, 5);
        matrizIncidencia.addAresta(5, 6);
        matrizIncidencia.addAresta(4, 6);

        matrizIncidencia.geraMatriz();
    }
}
