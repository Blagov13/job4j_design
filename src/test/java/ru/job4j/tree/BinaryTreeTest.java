package ru.job4j.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BinaryTreeTest {
    @Test
    public void whenAddElementInEmptyBSTThenTrue() {
        BinaryTree<String> rsl = new BinaryTree<>();
        rsl.add("1");
        assertThat(rsl.getRoot().getValue()).isEqualTo("1");
    }

    @Test
    public void whenAddElementLessThanRootThenLeft() {
        BinaryTree<Integer> bst = new BinaryTree<>();
        bst.add(5);
        bst.add(4);
        bst.add(6);
        bst.add(7);
        assertThat(bst.getRoot().getLeft().getValue()).isEqualTo(4);
        assertThat(bst.getRoot().getRight().getValue()).isEqualTo(6);
        assertThat(bst.getRoot().getRight().getRight().getValue()).isEqualTo(7);
    }

}