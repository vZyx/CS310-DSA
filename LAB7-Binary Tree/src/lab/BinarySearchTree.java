package lab;

import java.util.Scanner;

/**
 * BST implementation using a linked list of 3 pointers in a node
 * @author maltassan
 */
public class BinarySearchTree {

    class BinaryTreeNode {

        private int value;
        private BinaryTreeNode parent;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;

        public BinaryTreeNode(int value, BinaryTreeNode leftChild,
                              BinaryTreeNode rightChild, BinaryTreeNode parent) {
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }//end of constructor

        //Setters and Getters
        public int getValue(){ return value; }
        public BinaryTreeNode getParent(){ return parent; }
        public BinaryTreeNode getLeftChild(){ return leftChild;  }
        public BinaryTreeNode getRightChild(){ return rightChild; }

        public void setValue(int value){ this.value = value; }
        public void setParent(BinaryTreeNode parent){ this.parent = parent;}

        public void setLeftChild(BinaryTreeNode leftChild){
            this.leftChild = leftChild;        }

        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;        }

        public String toString(){return value+"";} //should be more detailed for any BTNode object but now we just need the value
    }//end of BTNode

    private BinaryTreeNode root=null; //root of BST
    private int size=0;               //number of nodes in BST

    public BinarySearchTree() { }

    public int getSize(){ return size; }
    public boolean isEmpty(){return size==0;}

    public BinaryTreeNode getRoot(){
        if(isEmpty()) return null;
        return root;
    }//end of getRoot

    // insert/delete methods:

    public void insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value, null, null, null);

        //case-1: add root node
        if (isEmpty()){
            root = newNode;
            size++;
            System.out.println(value + " - Added to Binary Search Tree");
            return;
        }//end if

        //case-2: any other node
        BinaryTreeNode current = root;
        BinaryTreeNode parent;

        while (true) {
            parent = current;
            if (value == current.value) {
                System.out.println(">> Duplicate Found!");
                return;
            }
            else if (value < current.value) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    break;
                }//end inner-if
            }
            else
            {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    break;
                }//end inner-if
            }//end outer if-else
        }//end loop

        newNode.parent = parent;
        size++;
        System.out.println(value + " - Added to Binary Search Tree");
    }//end of insert

    public void delete(BinaryTreeNode node, int value) {
        BinaryTreeNode current, parent;
        current = find(node, value);

        if(current==null) //not found
        {
            System.out.println("Not Found!");
            return;
        }//end if

        //Found has 3 cases:
        // Case-1: delete a leaf Node
        if (current.leftChild == null && current.rightChild == null) {
            parent = current.parent;
            if (parent.value > current.value)
                parent.leftChild=null;
            else
                parent.rightChild=null;

        }// Case-2: delete a Node with 1 child only
        else if (current.leftChild == null || current.rightChild == null) {
            parent = current.parent;
            if (parent.value > current.value) {
                if (current.leftChild != null)
                    parent.leftChild=current.leftChild;
                else
                    parent.leftChild=current.rightChild;

            }else {
                if (current.rightChild != null)
                    parent.rightChild=current.rightChild;
                else
                    parent.rightChild=current.leftChild;
            }
        } // Case-3: delete a full node (i.e. a node with 2 children)
        else {
            BinaryTreeNode minNode = findMin(current.rightChild);
            current.value=minNode.value;
            size++; //to avoid another decrement of the size after recursion, we actually just replacing the min value not deleting it
            delete(minNode, minNode.value);
        }//end outer if-else
        size--;
        //System.out.println(value + " - Deleted from Binary Search Tree");
    }//end of delete

    //Find methods in a BST:

    public BinaryTreeNode find(BinaryTreeNode node, int value) {
        //not found
        if (node == null) {
            // System.out.println("ERROR: NULL Node Parameter!"); //no
            return null;
        }//end if

        if (node.value == value) //found (base case)
            return node;

        if (value < node.value) //recursive find in subtrees
            return find(node.leftChild, value);
        else
            return find(node.rightChild, value);
    }//end of find

    //Find Min/Max methods
    public BinaryTreeNode findMin(BinaryTreeNode node) {
        //min node in a BST is the leaf node at the last left subtree
        if (isEmpty()) return null;

        while (node.leftChild != null)
            node = node.leftChild;

        return node;
    }//end of findMin

    public BinaryTreeNode findMax(BinaryTreeNode node) {
        //max node in a BST is the leaf node at the last right subtree
        if (isEmpty()) return null;

        while (node.rightChild != null)
            node = node.rightChild;

        return node;
    }//end of findMax

    // Traversal Methods: InOrder, PostOrder, PreOrder

    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node.value);
            inOrder(node.rightChild);
        }//end if
    }//end of inOrder

    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }//end if
    }//end of preOrder

    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.value);
        }//end if
    }//end of postOrder

    public int depth(BinaryTreeNode node) {
        if (isEmpty()) {
            System.out.println("ERROR: Empty Tree!");
            return 0;
        }//end if

        if (node == root)  //not found
            return 0;
        else
            return 1+depth(node.parent);
    }//end of find

    public int height(BinaryTreeNode node) {

        int h=0;
        if (node != null)
            h= Math.max(depth(node),Math.max(height(node.leftChild),height(node.rightChild)));
        return h;
    }//end of height

    public static void main(String[] args) {
        //create a BST with few nodes
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50); bst.insert(30);
        bst.insert(100); bst.insert(40);
        bst.insert(70); bst.insert(60); bst.insert(80);
        bst.insert(10); bst.insert(90);
        //System.out.println("\nBST height: "+ bst.height(bst.getRoot()));

        //try traversal methods
        System.out.println("\n>> InOrder Traversal:");
        bst.inOrder(bst.getRoot());
        System.out.println("\n>> PreOrder Traversal:");
        bst.preOrder(bst.getRoot());
        System.out.println("\n>> PostOrder Traversal:");
        bst.postOrder(bst.getRoot());

        //try info methods
        System.out.println("\nMinimum Node value: "+ bst.findMin(bst.getRoot()));
        System.out.println("\nMaximum Node value: "+ bst.findMax(bst.getRoot()));
        System.out.println("\nBST size: "+ bst.getSize());

        //try find method
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter a value to search for: ");
        int num=input.nextInt();
        if (bst.find(bst.getRoot(), num) != null)
            System.out.println("Found!");
        else
            System.out.println("Not found!");

        BinarySearchTree.BinaryTreeNode n=bst.find(bst.getRoot(), num);
        if (n != null)
            System.out.println("Found with depth "+bst.depth(n));
        else
            System.out.println("Not found!");


        //try delete method
        System.out.println("\nPlease enter a value to delete: ");
        num=input.nextInt();
        bst.delete(bst.getRoot(), num);
        System.out.println("\n>> PreOrder Traversal:");
        bst.preOrder(bst.getRoot());
    }//end of main


}//end of class

