package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Roman on 05.04.2020
 */
public class MyTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void isBinaryFalse() {
        MyTree<String> tree = new MyTree<>("C");
        tree.add("C", "B");
        tree.add("C", "D");
        tree.add("C", "F");
        tree.add("B", "A");
        tree.add("F", "G");
        tree.add("F", "I");
        tree.add("I", "H");
        assertFalse(tree.isBinary());
    }

    @Test
    public void isBinaryTrue() {
        MyTree<String> tree = new MyTree<>("C");
        tree.add("C", "B");
        tree.add("C", "F");
        tree.add("B", "A");
        tree.add("F", "G");
        tree.add("F", "I");
        tree.add("I", "H");
        assertTrue(tree.isBinary());
    }
}