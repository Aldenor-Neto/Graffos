package com.lista02;

public class Node {

    private Node father;
    private int data;
    private Node left;
    private Node right;

Node(){}

Node(int data){
this.data = data;
left = new Node();
right = new Node();
}

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
