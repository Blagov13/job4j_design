package ru.job4j.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BinaryTree() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }


    class TreeNode<E> {
        private E value;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public TreeNode<E> getRight() {
            return right;
        }
    }

    public void add(E e) {
        TreeNode<E> node = this.search(this.root, e);
        if (node == null) {
            this.root = new TreeNode<>(e);
        } else if (e.compareTo(node.value) <= 0) {
            node.left = new TreeNode<>(e);
        } else {
            node.right = new TreeNode<>(e);
        }
        this.size++;
    }

    private TreeNode<E> search(TreeNode<E> node, E e) {
        Deque<TreeNode<E>> data = new LinkedList<>();
        data.offer(node);
        TreeNode<E> current = null;
        while (!data.isEmpty()) {
            current = data.poll();
            if (current == null) {
                break;
            }
            if (e.compareTo(current.value) <= 0 && current.left != null) {
                data.offer(current.left);
            } else if (e.compareTo(current.value) > 0 && current.right != null) {
                data.offer(current.right);
            }
        }
        return current;
    }
}
