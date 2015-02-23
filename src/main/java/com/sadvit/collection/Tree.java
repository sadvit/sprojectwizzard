package com.sadvit.collection;


import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public Tree(T value) {
        root = new Node<T>();
        root.setValue(value);
        root.setChilds(new LinkedList<Node<T>>());
    }

    public static class Node<T> {

        private T value;
        private Node<T> parent;
        private List<Node<T>> childs;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public List<Node<T>> getChilds() {
            return childs;
        }

        public void setChilds(List<Node<T>> childs) {
            this.childs = childs;
        }

    }
}


