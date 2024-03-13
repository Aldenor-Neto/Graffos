package com.lista02;

public class BinaryTree {

    private Node source;

    BinaryTree(int data) {
        source = new Node(data);
    }

    public void printTree(Node current) {
        while (current != null) {
            System.out.println(current.getData());
            printTree(current.getLeft());
            printTree(current.getRight());
        }
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

}
