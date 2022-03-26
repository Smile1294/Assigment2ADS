import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

class BinaryTreeTest {

    private BinaryTreeNode treeRoot;
    private BinaryTree tree;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        treeRoot = new BinaryTreeNode(1);

        treeRoot.addLeftChild(new BinaryTreeNode(2));
        treeRoot.addRightChild(new BinaryTreeNode(3));

        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(4));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(5));

        tree = new BinaryTree(treeRoot);
    }

    @org.junit.jupiter.api.Test
    void getRoot() {
        Assertions.assertEquals(1, tree.getRoot().getElement());
    }

    @org.junit.jupiter.api.Test
    void setRoot() {
        BinaryTreeNode testRoot = new BinaryTreeNode(10);
        tree.setRoot(testRoot);
        Assertions.assertEquals(10, tree.getRoot().getElement());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Assertions.assertFalse(tree.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        Assertions.assertEquals(5, tree.size());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Assertions.assertTrue(tree.contains(1));
        Assertions.assertTrue(tree.contains(2));
        Assertions.assertTrue(tree.contains(3));
        Assertions.assertTrue(tree.contains(4));
        Assertions.assertTrue(tree.contains(5));
        Assertions.assertFalse(tree.contains(7));
    }

    @org.junit.jupiter.api.Test
    void inOrder() {
        ArrayList<BinaryTreeNode> order = new ArrayList<>();
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode leftLeft = new BinaryTreeNode(4);
        BinaryTreeNode leftRight = new BinaryTreeNode(5);
        order.add(leftLeft);
        order.add(left);
        order.add(leftRight);
        order.add(root);
        order.add(right);
        ArrayList<Integer> dummy = tree.inOrder();
        for (Integer binaryTreeNode : dummy) {
            System.out.println(binaryTreeNode);
        }

        for (int i = 0; i < dummy.size(); i++) {
            Assertions.assertEquals(order.get(i).getElement(), dummy.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void preOrder() {
        ArrayList<BinaryTreeNode> order = new ArrayList<>();
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode leftLeft = new BinaryTreeNode(4);
        BinaryTreeNode leftRight = new BinaryTreeNode(5);
        order.add(root);
        order.add(left);
        order.add(leftLeft);
        order.add(leftRight);
        order.add(right);
        ArrayList<Integer> dummy = tree.preOrder();
        for (Integer binaryTreeNode : dummy) {
            System.out.println(binaryTreeNode);
        }

        for (int i = 0; i < dummy.size(); i++) {
            Assertions.assertEquals(order.get(i).getElement(), dummy.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void levelOrder() {
        ArrayList<BinaryTreeNode> order = new ArrayList<>();
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode leftLeft = new BinaryTreeNode(4);
        BinaryTreeNode leftRight = new BinaryTreeNode(5);
        order.add(root);
        order.add(left);
        order.add(right);
        order.add(leftLeft);
        order.add(leftRight);
        ArrayList<Integer> dummy = tree.levelOrder();
        for (Integer binaryTreeNode : dummy) {
            System.out.println(binaryTreeNode);
        }

        for (int i = 0; i < dummy.size(); i++) {
            Assertions.assertEquals(order.get(i).getElement(), dummy.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void postOrder() {
        ArrayList<BinaryTreeNode> order = new ArrayList<>();
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode leftLeft = new BinaryTreeNode(4);
        BinaryTreeNode leftRight = new BinaryTreeNode(5);
        order.add(leftLeft);
        order.add(leftRight);
        order.add(left);
        order.add(right);
        order.add(root);
        ArrayList<Integer> dummy = tree.postOrder();
        for (Integer binaryTreeNode : dummy) {
            System.out.println(binaryTreeNode);
        }

        for (int i = 0; i < dummy.size(); i++) {
            Assertions.assertEquals(order.get(i).getElement(), dummy.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void height() {
        Assertions.assertEquals(2,tree.height());
    }
}