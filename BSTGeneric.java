package bst;
import java.util.*;
public class BSTGeneric<T extends Comparable <T>> {
    // Initialization
    public class Node<T>
    {
        // Each node has a key, left and right branch
        T key;
        Node<T> left;
        Node<T> right;

        // Constructor
        Node(T key, Node<T> left, Node<T> right)
        {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        // Constructor that accepts the key item as parameter
        Node(T item)
        {
            key = item;
            left = right = null;
        }

    }

    // Forms the root of the BST
    Node<T> root;

    // Recursive insertion
    Node<T> recursiveInsert(Node<T> currentNode, T val)
    {
    /*
        When inserting there are mainly 3 scenarios:
        a) The node is empty
        b) The value to be inserted is lesser than the key of the node
        c) The value to be inserted is more than the key of the node
        d) The value to be inserted is equal to the key of the node
    */

        // Condition a)
        if (currentNode == null)
        {
            currentNode = new Node<T>(val);
            return currentNode;
        }

        // Condition b)
        if (compare(val, currentNode) < 0)
        {
            currentNode.left = recursiveInsert(currentNode.left, val);
        }

        // Condition c)
        else if (compare(val, currentNode) > 0)
        {
            currentNode.right = recursiveInsert(currentNode.right, val);
        }

        // Condition d)
        else if (val == currentNode.key)
        {
            // Returns the current node state
            return currentNode;
        }

        return currentNode;
    }

    // Recursive delete
    /*
        Before deleting, searching has to be carried out
        to look for the node to be deleted

        After searching for the node, deletion can occur

        During deletion, there are 3 cases:
        a) The deleted node does not have any child
        b) The deleted node has one child
        c) The deleted node has two children
    */
    Node<T> recursiveDelete(Node<T> currentNode, T val)
    {
        // Searching for the node to be deleted

        // If the node isn't found
        if (currentNode == null)
        {
            return null;
        }

        // Node to delete is found
        if (currentNode.key == val)
        {
            // Condition a)
            if (currentNode.left == null &&
                currentNode.right == null)
            {
                return null;
            }

            // Condition b) i) No left child
            else if (currentNode.left == null)
            {
                return currentNode.right;
            }

            // Condition c) No right child
            else if (currentNode.right == null)
            {
                return currentNode.left;
            }

            // Condition c)
            // Looking for the minimum value in the right
            // subtree
            T minValue = findMinVal(currentNode.right);

            // Replacing the current node's key with the min
            // value
            currentNode.key = minValue;

            // Deleting the minimum value of the right subtree
            // since it has already replaced the currentNode
            currentNode.right = recursiveDelete(currentNode.right, minValue);
            return currentNode;
        }

        // Returns the right sub tree if val > node's key
        else if (compare(val, currentNode) > 0)
        {
            currentNode.right = recursiveDelete(currentNode.right, val);
            return currentNode;
        }

        // Returns the left sub tree if val < node's key
        else if (compare(val, currentNode) < 0)
        {
            currentNode.left = recursiveDelete(currentNode.left, val);
            return currentNode;
        }

        return currentNode;

    }

        // findMinVal
    /*
        This function is used to search for the minimum value
        in the right subtree

        This is used during the deletion method, where the node
        has two children
    */
    T findMinVal(Node<T> rightLargest)
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

    // Recursive search
    /*
        Takes the root as a parameter and searches from the root
        node to the target node
    */
    Node<T> recursiveSearch(Node<T> root, T target)
    {
        if (root == null || root.key == target)
        {
            return root;
        }

        // Returns right node if target > key
        if (compare(target, root) > 0)
        {
            return recursiveSearch(root.right, target);
        }

        // Returns left node if target < key
        else
        {
            return recursiveSearch(root.left, target);
        }

        // null value will be returned if the value is not found
        // thus, there is no need to write an else statement for it
    }

    // Traversal
    void inOrder(Node<T> root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(" "+ root.key);
            inOrder(root.right);
        }
    }


    // Insert method
    /*
        Takes in the value to be inserted and passes it to the
        recursiveInsert method
    */
    void insertVal(T val)
    {
        // The return type of the function is a root, so the method
        // can be assigned to root
        root = recursiveInsert(root, val);
        System.out.println("The value "+ val + " has been inserted\n");
    }

    // Deletion method
    void deleteVal(T val)
    {
        // To check whether the val to be deleted is in tree
        Node<T> preDel = recursiveSearch(root, val);

        // To call the recursiveDelete method
        root = recursiveDelete(root, val);

        // To check if the number is deleted
        Node<T> postDel = recursiveSearch(root, val);

        // If the number is in the tree and has been deleted
        if (preDel != null && postDel == null)
        {
            System.out.printf("\nThe node "+ val + " was present"
            +" in the tree and has been deleted\n");
        }

        // // Number is not in the tree
        if (preDel == null)
        {
            System.out.printf("\nThe node "+ val +" is not in the tree\n");
        }

    }

    // Searching method
    void searchVal(T val)
    {
        // Assigning a variable to hold the return value of the function
        Node<T> currentNode = recursiveSearch(root, val);

        // If the node is not found
        if (currentNode != null)
        {
            System.out.printf("The node " + val + " is found!\n");
        }

        // If the node is found
        else
        {
            System.out.printf("The node " + val + " is not found!\n");
        }
    }

    // Compare method that simplifies the compareTo function
    int compare(T val, Node<T> node)
    {
        int comparedVal = val.compareTo(node.key);
        return comparedVal;
    }

}