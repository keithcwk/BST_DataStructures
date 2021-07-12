package bst;

import java.util.*;

public class BST <T extends Comparable <T>>
{

    public class Node<T>
    {
        T key;
        Node<T> left;
        Node<T> right;

        Node(T key, Node<T> left, Node<T> right)
        {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        Node(T item) 
        {
            key = item;
            left = right = null;
        }

    }

    Node<T> root;

    Node<T> recursiveInsert(Node<T> currentNode, T val)
    {
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
            return currentNode;
        }

        return currentNode;
    }

    Node<T> recursiveDelete(Node<T> currentNode, T val)
    {
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

            // Condition b)i) No left child 
            else if (currentNode.left == null)
            {
                return currentNode.right;
            }

            // Condition b)ii) No right child
            else if (currentNode.right == null)
            {
                return currentNode.left;
            }

            // Condition c)
            T minValue = findMinVal(currentNode.right);

            currentNode.key = minValue;

            currentNode.right = recursiveDelete(currentNode.right, minValue);
            return currentNode;
        }

        else if (compare(val, currentNode) < 0)
        {
            currentNode.left = recursiveDelete(currentNode.left, val);
            return currentNode;
        }

        else if (compare(val, currentNode) > 0)
        {
            currentNode.right = recursiveDelete(currentNode.right, val);
            return currentNode;
        }

        else if (compare(val, currentNode) < 0)
        {
            currentNode.left = recursiveDelete(currentNode.left, val);
            return currentNode;
        }

        return currentNode;
        
    } 

    T findMinVal(Node<T> rightSmallest)
    {
        if (rightSmallest.left == null)
        {
            return rightSmallest.key;
        }

        else 
        {
            return findMinVal(rightSmallest.left);
        }
    }

    Node<T> recursiveSearch(Node<T> root, T target)
    {
        if (root == null || root.key == target)
        {
            return root;
        }

        if (compare(target, root) > 0)
        {
            return recursiveSearch(root.right, target);
        }

        else
        {
            return recursiveSearch(root.left, target);
        }
    }

    void inOrder(Node<T> root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(" "+ root.key);
            inOrder(root.right);
        }
    }

    void insertVal(T val)
    {
        root = recursiveInsert(root, val);
        System.out.println("The value "+ val + " has been inserted\n");
    }

    void deleteVal(T val)
    {
        Node<T> preDel = recursiveSearch(root, val);

        root = recursiveDelete(root, val); 

        Node<T> postDel = recursiveSearch(root, val);

        if (preDel != null && postDel == null)
        {
            System.out.printf("\nThe node "+ val + " was present" 
            +" in the tree and has been deleted");
        }

        if (preDel == null)
        {
            System.out.printf("\nThe node "+ val +" is not in the tree");
        }
        
    }

    void searchVal(T val)
    {
        Node<T> currentNode = recursiveSearch(root, val);

        if (currentNode != null)
        {
            System.out.printf("The node " + val + " is found!\n");
        }

        else
        {
            System.out.printf("The node " + val + " is not found!\n");
        }
    }

    int compare(T val, Node<T> node)
    {
        int comparedVal = val.compareTo(node.key);
        return comparedVal;
    }

}