import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree extends BinaryTree{

    private BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
        this.root = root;
    }

    public int findMin(){
        if (isEmpty()) return 0;
        return inOrder().get(0);
    }

    //this is used for the removeElement method
    private int findMin(BinaryTreeNode node)
    {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.getElement();
        int lres = findMin(node.getLeftChild());
        int rres = findMin(node.getRightChild());

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    public int findMax(){
        if (isEmpty()) return 0;
        return inOrder().get(inOrder().size()-1);
    }

    public void removeElement(int element)
    {
        removeElement(root, element);
    }

    private BinaryTreeNode removeElement(BinaryTreeNode root, int element) {
        if(root == null)
            return null;
        if(element<root.getElement()) {
            root.addLeftChild(removeElement(root.getLeftChild(), element));
        }else if(element>root.getElement())
        {
            root.addRightChild(removeElement(root.getRightChild(), element));
        }
        else
        {
            if(root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            }
            else if(root.getLeftChild() != null && root.getRightChild() != null)
            {
                int successor = findMin(root.getRightChild());
                root.setElement(successor);

                root.addRightChild(removeElement(root.getRightChild(), successor));
            }
            else if(root.getLeftChild() != null && root.getRightChild() == null)
                root = root.getLeftChild();
            else if(root.getRightChild() != null && root.getLeftChild() == null)
                root = root.getRightChild();
        }
        return root;
    }

    public void rebalance()
    {
        int end = inOrder().size() - 1;
        setRoot(rebalance(inOrder(), 0, end));
    }

    private BinaryTreeNode rebalance(ArrayList<Integer> inOrder, int start, int end)
    {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;

        BinaryTreeNode node = new BinaryTreeNode(inOrder.get(mid));

        node.addLeftChild(rebalance(inOrder, start, mid-1));

        node.addRightChild(rebalance(inOrder, mid+1, end));
        return node;
    }

    public void insert(int element){
        BinaryTreeNode newNode = new BinaryTreeNode(element);

        BinaryTreeNode x = root;
        BinaryTreeNode y = null;

        while (x != null) {
            y = x;
            if(element == x.getElement())
            {
                return;
            }
            else if (element < x.getElement())
            {
                x = x.getLeftChild();
            }
            else
            {
                x = x.getRightChild();
            }
        }

        if (element < y.getElement())
            y.addLeftChild(newNode);
        else
            y.addRightChild(newNode);
    }

}