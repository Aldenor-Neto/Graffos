package com.lista02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[][] geraMatriz() {
        int n = 3;
        int[][] matriz = new int[n][n];
        Scanner input = new Scanner(System.in);

        System.out.println("""
                        informe os dados da matriz
                        ***Opções***
                        Saída= 1
                        Entrada= -1
                laço=2
                        """);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Posição " + (i + 1) + " " + (j + 1));
                matriz[i][j] = input.nextInt();
            }
        }

        return matriz;
    }

    public static void printMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void contaGraus(int[][] matriz) {
        List<No> listaNos = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            No novoNo = new No();
            novoNo.setNo("" + (i + 1));
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1) {
                    novoNo.setGrauSaida(novoNo.getGrauSaida() + 1);
                } else if (matriz[i][j] == -1) {
                    novoNo.setGrauEnttrada(novoNo.getGrauEnttrada() + 1);
                } else if (matriz[i][j] == 2 & i == j) {
                    novoNo.setGrauEnttrada(novoNo.getGrauEnttrada() + 1);
                    novoNo.setGrauSaida(novoNo.getGrauSaida() + 1);
                } else if (matriz[i][j] == 2) {
                    novoNo.setGrauSaida(novoNo.getGrauSaida() + 2);
                } else if (matriz[i][j] == -2) {
                    novoNo.setGrauEnttrada(novoNo.getGrauEnttrada() + 2);
                }
            }
            listaNos.add(novoNo);
        }
        System.out.println(listaNos);
    }

    public static void main(String[] args) {
        int[][] matriz = geraMatriz();
        printMatriz(matriz);
        contaGraus(matriz);
    }
}