public class BinarySearchTree {

    private class BinaryTreeNode {
        private int value;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;
        private BinaryTreeNode parent;

        // Constructor
        public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent)
        {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        // Getter for value
        public int getValue() {
            return value;
        }
        // Getter for leftChild
        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }
        // Getter for rightChild
        public BinaryTreeNode getRightChild() {
            return rightChild;
        }
        // Getter for parent
        public BinaryTreeNode getParent() {
            return parent;
        }


        // Setter for value
        public void setValue(int value) {
            this.value = value;
        }
        // Setter for leftChild
        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
            if (leftChild != null) {
                leftChild.setParent(this);
            }
        }
        // Setter for rightChild
        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
            if (rightChild != null) {
                rightChild.setParent(this);
            }
        }
        // Setter for parent
        public void setParent(BinaryTreeNode parent) {
            this.parent = parent;
        }

        // toString method to represent the node as a string
        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    ", leftChild=" + (leftChild != null ? leftChild.getValue() : "null") +
                    ", rightChild=" + (rightChild != null ? rightChild.getValue() : "null") +
                    ", parent=" + (parent != null ? parent.getValue() : "null") +
                    '}';
        }

    }

    private BinaryTreeNode root; // root of BST
    private int size; // number of nodes in BST

    // Constructor
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Getter for root
    public BinaryTreeNode getRoot() {
        return root;
    }
    // Getter for size
    public int getSize() {
        return size;
    }
    // Check if the tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert a value into the tree
    public void insert(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value, null, null, null);
        } else {
            insertRec(root, value);
        }
        size++;
    }

    private void insertRec(BinaryTreeNode node, int value) {
        if (value < node.getValue()) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new BinaryTreeNode(value, null, null, node));
            } else {
                insertRec(node.getLeftChild(), value);
            }
        } else if (value > node.getValue()) {
            if (node.getRightChild() == null) {
                node.setRightChild(new BinaryTreeNode(value, null, null, node));
            } else {
                insertRec(node.getRightChild(), value);
            }
        }
    }

    // Delete a value from the tree
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private BinaryTreeNode deleteRec(BinaryTreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeftChild(deleteRec(node.getLeftChild(), value));
        } else if (value > node.getValue()) {
            node.setRightChild(deleteRec(node.getRightChild(), value));
        } else {
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                size--;
                return null;
            } else if (node.getLeftChild() == null) {
                size--;
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                size--;
                return node.getLeftChild();
            } else {
                BinaryTreeNode minNode = findMin(node.getRightChild());
                node.setValue(minNode.getValue());
                node.setRightChild(deleteRec(node.getRightChild(), minNode.getValue()));
            }
        }
        return node;
    }

    // Find a value in the tree
    public BinaryTreeNode find(int value) {
        return findRec(root, value);
    }

    private BinaryTreeNode findRec(BinaryTreeNode node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
        }
        if (value < node.getValue()) {
            return findRec(node.getLeftChild(), value);
        } else {
            return findRec(node.getRightChild(), value);
        }
    }

    // Find the minimum value in the tree
    public BinaryTreeNode findMin() {
        return findMin(root);
    }

//    private BinaryTreeNode findMin(BinaryTreeNode node) {
//        while (node != null && node.getLeftChild() != null) {
//            node = node.getLeftChild();
//        }
//        return node;
//    }
    private BinaryTreeNode findMin(BinaryTreeNode node){
        if (isEmpty()) return null;
        while(node.getLeftChild() != null )
            node = node.getLeftChild();
        return node;
    }

    // Find the maximum value in the tree
    public BinaryTreeNode findMax() {
        return findMax(root);
    }

//    private BinaryTreeNode findMax(BinaryTreeNode node) {
//        while (node != null && node.getRightChild() != null) {
//            node = node.getRightChild();
//        }
//        return node;
//    }

    public BinaryTreeNode findMax(BinaryTreeNode node){
        if (isEmpty()) return null;
        while(node.getRightChild() != null )
            node = node.getRightChild();
        return node;
    }


    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BinaryTreeNode node) {
        if (node != null) {
            inorderRec(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inorderRec(node.getRightChild());
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preorderRec(node.getLeftChild());
            preorderRec(node.getRightChild());
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(BinaryTreeNode node) {
        if (node != null) {
            postorderRec(node.getLeftChild());
            postorderRec(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        // Example usage
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inorder(); // Should print the values in ascending order
        System.out.println();

        System.out.println("Pre-order traversal:");
        bst.preorder(); // Should print the root value first, then left subtree, then right subtree
        System.out.println();

        System.out.println("Post-order traversal:");
        bst.postorder(); // Should print the left subtree, then right subtree, then root value
        System.out.println();

        System.out.println("Find 7: " + (bst.find(7) != null));
        System.out.println("Find 20: " + (bst.find(20) != null));

        System.out.println("Minimum value: " + bst.findMin().getValue());
        System.out.println("Maximum value: " + bst.findMax().getValue());

        bst.delete(10);
        System.out.println("In-order traversal after deleting 10:");
        bst.inorder(); // Should print the values in ascending order without 10
        System.out.println();


    }
}
