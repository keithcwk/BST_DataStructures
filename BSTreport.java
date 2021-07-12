package bst;
import java.util.*;
public class BSTreport {
    // Initialization
    public class Node 
    {
        int key; 
        Node left;
        Node right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root ; 

    BSTreport()
    {
        root = null; 
    }

    Node recursiveInsert(Node currentNode, int val)
    {

        if (currentNode == null)
        {
            currentNode = new Node(val);
            return currentNode;
        }

        if (val < currentNode.key)
        {
            currentNode.left = recursiveInsert(currentNode.left, val);
        }

        else if (val > currentNode.key)
        {
            currentNode.right = recursiveInsert(currentNode.right, val);
        }

        else if (val == currentNode.key)
        {
            return currentNode;
        }

        return currentNode;
    }

    Node recursiveDelete(Node currentNode, int val)
    {
        if (currentNode == null) 
        {
            return currentNode;
        }

        if (currentNode.key < val)
        {
            return recursiveDelete(currentNode.right, val);
        }

        else if (currentNode.key > val)
        {
            return recursiveDelete(currentNode.left, val);
        }

        else
        {
            if (currentNode.left == null && 
                currentNode.right == null)
            {
                return null; 
            }

            else if (currentNode.left == null)
            {
                return currentNode.right;
            }

            else if (currentNode.right == null)
            {
                return currentNode.left;
            }

            int minValue = findMinVal(currentNode.right);

            currentNode.key = minValue;

            currentNode.right = recursiveDelete(currentNode.right, minValue);

            return currentNode;
        }
    } 

    Node recursiveSearch(Node root, int target)
    {
        if (root == null || root.key == target)
        {
            return root;
        }

        if (root.key < target)
        {
            return recursiveSearch(root.right, target);
        }

        else
        {
            return recursiveSearch(root.left, target);
        }
    }

    int findMinVal(Node rightLargest)
    {
        if (rightLargest.left == null)
        {
            return rightLargest.key;
        }

        else 
        {
            return findMinVal(rightLargest.left);
        }
    }

    void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(" "+ root.key);
            inOrder(root.right);
        }
    }

    void insertVal(int val)
    {
        root = recursiveInsert(root, val);
    }

    void delete(int val)
    {
        Node preDel = recursiveSearch(root, val);
        root = recursiveDelete(root, val); 
        Node postDel = recursiveSearch(root, val);

        // If the number is in the tree and has been deleted
        if (preDel != null && postDel == null)
        {
            System.out.printf("The node %d was present" 
            ,"in the tree and has been deleted", val);
        }

        System.out.printf("The node %d is not in the tree", val);
    }

    void searchVal(int val)
    {
        Node currentNode = recursiveSearch(root, val);

        if (currentNode != null)
        {
            System.out.printf("The node %d is found!\n", val);
        }

        else
        {
            System.out.printf("The node %d is not found!\n", val);
        }
    }
}