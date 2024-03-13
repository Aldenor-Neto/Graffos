package com.lista02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void geraArvore(Node raiz, int n) {
        List<Node> lista = new ArrayList<>();
        lista.add(raiz);

        int value = 2;
        for (int i = 1; value < n; i++) {
            Node newNode = new Node(2 * i);
            Node newNode2 = new Node((2 * i) + 1);
            value = 2 * i + 1;
            Node current = lista.get(i - 1);
            current.setLeft(newNode);
            lista.add(newNode);

            current.setRight(newNode2);
            lista.add(newNode2);
        }
    }

    public static void buscaProfundidade(Node raiz, int target) {
        if (raiz == null) {
            return;
        }
        if (raiz.getData() == target) {
            System.out.println(raiz.getData() + " : Alvo encontrado");
            return;
        }

        if (raiz.getData() != 0) {
            System.out.print(raiz.getData() + " ");
        }
        if (raiz.getLeft() != null) {
            buscaProfundidade(raiz.getLeft(), target);
        }
        if (raiz.getRight() != null) {
            buscaProfundidade(raiz.getRight(), target);
        }
    }

    public static void buscaLargura(Node raiz, int target) {
        List<Node> lista = new ArrayList<>();
        lista.add(raiz);

        while (lista != null) {
            Node current = lista.get(0);
            if (current.getData() == target) {
                System.out.println(current.getData() + " Alvo encontrado");
                return;
            }

            if (current.getLeft() != null) {
                lista.add(current.getLeft());
            }
            if (current.getRight() != null) {
                lista.add(current.getRight());
            }

            System.out.print(current.getData() + " ");
            lista.remove(0);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        geraArvore(tree.getSource(), 15);
        System.out.println("busca profundidade");
        buscaProfundidade(tree.getSource(), 11);
        System.out.println();
        System.out.println("busca por Largura");
        buscaLargura(tree.getSource(), 11);
    }
}