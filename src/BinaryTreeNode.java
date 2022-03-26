public class BinaryTreeNode {
    private int element;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    BinaryTreeNode(int element) {
        this.element = element;
        this.right = null;
        this.left = null;
    }

    public void setElement(int element)
    {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode node)
    {
        this.left = node;
    }

    public void addRightChild(BinaryTreeNode node)
    {
        this.right = node;
    }

    public BinaryTreeNode getLeftChild() {
        return left;
    }

    public BinaryTreeNode getRightChild() {
        return right;
    }
}