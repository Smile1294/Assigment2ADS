import com.sun.tools.jconsole.JConsoleContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BinarySearchTreeTest {

    private BinaryTreeNode treeRoot;
    private BinarySearchTree tree;
    private BinaryTreePrint print;

    @BeforeEach
    void setUp() {
        treeRoot = new BinaryTreeNode(10);

        treeRoot.addLeftChild(new BinaryTreeNode(6));
        treeRoot.addRightChild(new BinaryTreeNode(14));

        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(4));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(7));

        treeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(2));
        treeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(5));

        tree = new BinarySearchTree(treeRoot);

        print = new BinaryTreePrint();
    }

    @Test
    void findMin() {
        Assertions.assertEquals(2, tree.findMin());
    }

    @Test
    void findMax() {
        Assertions.assertEquals(14, tree.findMax());
    }

    @Test
    void removeElement() {
        print.printTree(treeRoot);
        tree.removeElement(4);
        print.printTree(treeRoot);
        tree.removeElement(73);
        print.printTree(treeRoot);
        Assertions.assertFalse(tree.contains(4));
    }

    @Test
    void rebalance() {
        print.printTree(tree.getRoot());
        tree.removeElement(4);
        System.out.println();
        print.printTree(tree.getRoot());
        System.out.println();
        tree.rebalance();
        print.printTree(tree.getRoot());

        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(6);
        preOrder.add(2);
        preOrder.add(5);
        preOrder.add(10);
        preOrder.add(7);
        preOrder.add(14);
        Assertions.assertEquals(preOrder, tree.preOrder());

    }

    @Test
    void insert() {
        print.printTree(treeRoot);
        System.out.println();
        tree.insert(13);
        print.printTree(treeRoot);
        System.out.println();
        tree.insert(12);
        print.printTree(treeRoot);
        System.out.println();
        tree.insert(15);
        print.printTree(treeRoot);
        System.out.println();
        tree.insert(6);
        print.printTree(treeRoot);
        System.out.println();
        tree.insert(10);
        print.printTree(treeRoot);

        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(10);
        preOrder.add(6);
        preOrder.add(4);
        preOrder.add(2);
        preOrder.add(5);
        preOrder.add(7);
        preOrder.add(14);
        preOrder.add(13);
        preOrder.add(12);
        preOrder.add(15);
        Assertions.assertEquals(preOrder, tree.preOrder());
    }
}