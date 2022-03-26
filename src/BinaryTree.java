import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (isEmpty()) return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        int size = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();
            if (node.getLeftChild() != null) {
                size++;
                q.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                size++;
                q.offer(node.getRightChild());
            }
        }

        return size;
    }

    public boolean contains(int element) {
        if (root == null) return false;
        return inOrder().contains(element);
    }

    public ArrayList<Integer> inOrder() {

        if (isEmpty()) return null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<Integer> finalTraversal = new ArrayList<>();
        BinaryTreeNode current = root;

        while (!stack.isEmpty() || current != null) {

            while(current != null)
            {
                stack.push(current);
                current = current.getLeftChild();
            }

            current = stack.pop();
            finalTraversal.add(current.getElement());
            current = current.getRightChild();

        }
        return finalTraversal;
    }

    public ArrayList<Integer> preOrder()
    {
        if(isEmpty()) return null;

        Stack<BinaryTreeNode> q = new Stack<BinaryTreeNode>();
        q.push(root);

        ArrayList<Integer> preList = new ArrayList<>();

        while (!q.isEmpty())
        {
            BinaryTreeNode node = q.pop();
            preList.add(node.getElement());

            if (node.getRightChild() != null)
            {
                q.push(node.getRightChild());
            }
            if (node.getLeftChild() != null)
            {
                q.push(node.getLeftChild());
            }
        }

        return preList;
    }

    public ArrayList<Integer> levelOrder()
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return null;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            root = q.peek();
            res.add(root.getElement());
            q.poll();
            if (root.getLeftChild() != null)
                q.add(root.getLeftChild());
            if (root.getRightChild() != null)
                q.add(root.getRightChild());
        }
        return res;
    }

    public ArrayList<Integer> postOrder() {

        if (root == null) return null;
        ArrayList<Integer> postList = new ArrayList<>();

        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            BinaryTreeNode temp = (BinaryTreeNode) stack1.pop();
            stack2.push(temp);

            if (temp.getLeftChild() != null)
                stack1.push(temp.getLeftChild());
            if (temp.getRightChild() != null)
                stack1.push(temp.getRightChild());
        }

        while (!stack2.isEmpty()) {
            BinaryTreeNode temp = (BinaryTreeNode) stack2.pop();
            postList.add(temp.getElement());
        }
        return postList;
    }

    private int height(BinaryTreeNode node)
    {
        if (node == null || (node.getLeftChild() == null && node.getRightChild() == null))
        {
            return 0;
        }
        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int height()
    {
        return height(getRoot());
    }
}